// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/** Test double: the JDK's own HttpServer on an ephemeral loopback port, recording every request. */
final class WireServer implements AutoCloseable {

    /** One recorded request. */
    record Req(String method, String rawPath, String rawQuery, Map<String, String> headers, String body) {
        String header(String name) {
            return headers.get(name);
        }
    }

    /** A scripted response. */
    record Resp(int status, String body, Map<String, String> headers) {
        static Resp json(int status, String body) {
            return new Resp(status, body, Map.of("Content-Type", "application/json"));
        }

        static Resp withHeader(int status, String body, String name, String value) {
            return new Resp(status, body, Map.of("Content-Type", "application/json", name, value));
        }
    }

    final List<Req> requests = new CopyOnWriteArrayList<>();
    private final HttpServer server;
    private final List<Resp> script = new ArrayList<>();
    private Function<Req, Resp> handler;

    WireServer(Resp... responses) throws IOException {
        script.addAll(List.of(responses));
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/", this::handle);
        server.start();
    }

    WireServer(Function<Req, Resp> handler) throws IOException {
        this.handler = handler;
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/", this::handle);
        server.start();
    }

    String baseUrl() {
        return "http://127.0.0.1:" + server.getAddress().getPort();
    }

    Req last() {
        return requests.get(requests.size() - 1);
    }

    private void handle(HttpExchange ex) throws IOException {
        Map<String, String> headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        ex.getRequestHeaders().forEach((k, v) -> headers.put(k, v.get(0)));
        String body = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
        Req req = new Req(ex.getRequestMethod(), ex.getRequestURI().getRawPath(), ex.getRequestURI().getRawQuery(), headers, body);
        requests.add(req);
        Resp resp = handler != null ? handler.apply(req) : script.get(Math.min(requests.size() - 1, script.size() - 1));
        byte[] bytes = resp.body() == null ? new byte[0] : resp.body().getBytes(StandardCharsets.UTF_8);
        resp.headers().forEach((k, v) -> ex.getResponseHeaders().add(k, v));
        ex.sendResponseHeaders(resp.status(), resp.status() == 204 ? -1 : bytes.length);
        if (resp.status() != 204) {
            try (OutputStream os = ex.getResponseBody()) {
                os.write(bytes);
            }
        }
        ex.close();
    }

    @Override
    public void close() {
        server.stop(0);
    }
}
