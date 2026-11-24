package com.cryptascreen.sdk.model;

import java.util.List;

/**
 * A page of results.
 *
 * @param <T>        the item type
 * @param data       the items
 * @param page       the page index
 * @param pageSize   the page size
 * @param totalItems the total number of items
 * @param totalPages the total number of pages
 */
public record PaginatedResponse<T>(List<T> data, Long page, Long pageSize, Long totalItems, Long totalPages) {}
