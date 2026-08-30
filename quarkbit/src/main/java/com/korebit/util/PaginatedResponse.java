package com.korebit.util;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.util.List;

public record PaginatedResponse<E>(int pageNumber, int pageSize, long totalElements, List<E> content) {

    public PaginatedResponse(PanacheQuery<E> query){
        this(query.page().index, query.page().size, query.count(), query.list());
    }
}
