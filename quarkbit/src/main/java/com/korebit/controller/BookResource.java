package com.korebit.controller;

import com.korebit.model.Book;
import com.korebit.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/books")
public class BookResource {

    private final BookRepository bookRepository;

    @Inject
    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GET
    public List<Book> getBooks() {
        return bookRepository.listAll();
    }

    @POST
    @Transactional
    public Response addBook(Book book) {
        assert book != null : "Book cannot be null";
        bookRepository.persist(book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }
}
