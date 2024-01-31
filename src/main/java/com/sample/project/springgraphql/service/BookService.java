package com.sample.project.springgraphql.service;

import com.sample.project.springgraphql.entities.Book;

import java.util.List;

public interface BookService {

    public Book createBook (Book b);

    public Book getBook(int i);

    public List<Book> getAll();
}
