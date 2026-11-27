// Copyright (c) 2024-2026 CryptaCount, Inc.
// SPDX-License-Identifier: MIT
package com.cryptascreen.sdk;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Every Java source file starts with the two-line copyright and SPDX licence header. */
class SourceHeaderTest {

    static final String L1 = "// Copyright (c) 2024-2026 CryptaCount, Inc.";
    static final String L2 = "// SPDX-License-Identifier: MIT";
    static final PathMatcher SOURCE = FileSystems.getDefault().getPathMatcher("glob:**.{java}");

    static String problem(String content) {
        if (content.startsWith("\uFEFF")) content = content.substring(1);
        String[] lines = content.split("\r?\n", -1);
        return lines.length > 1 && lines[0].equals(L1) && lines[1].equals(L2) ? null : "missing or wrong header";
    }

    @Test
    void everyJavaSourceFileStartsWithTheHeader() throws IOException {
        List<Path> files;
        try (Stream<Path> s = Files.walk(Path.of("src"))) {
            files = s.filter(SOURCE::matches).collect(Collectors.toList());
        }
        List<String> bad = new ArrayList<>();
        for (Path f : files) {
            if (problem(Files.readString(f, StandardCharsets.UTF_8)) != null) bad.add(f.toString());
        }
        assertTrue(files.size() > 50, "java files found: " + files.size());
        assertEquals(List.of(), bad, "files without the header");
    }

    @Test
    void theRuleCatchesAMissingHeader() {
        assertNull(problem(L1 + "\n" + L2 + "\npackage a;\n"));
        assertNull(problem(L1 + "\r\n" + L2 + "\r\npackage a;\r\n"));
        assertNotNull(problem("package a;\n"));
        assertNotNull(problem("// Copyright (c) 2026 Someone Else\n" + L2 + "\npackage a;\n"));
    }
}
