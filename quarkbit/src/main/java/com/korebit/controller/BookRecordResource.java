package com.korebit.controller;

import com.korebit.model.BookRecordEntity;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/book-records")
public class BookRecordResource {

    @GET
    @Path("/all")
    public List<?> getAllBookRecords() {
        return BookRecordEntity.listAll();
    }

    @POST
    @Path("/add")
    public void addBookRecord(BookRecordEntity bookRecord) {
        bookRecord.persist();
    }
}
