package com.sample.project.springgraphql.controller;

import com.sample.project.springgraphql.entities.Book;
import com.sample.project.springgraphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
//@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    public Book createBook(Book book) {
        return bookService.createBook(book);
    }

    //@GetMapping
    @QueryMapping("getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    //@GetMapping("/{id}")
    @QueryMapping("getBook")
    //public Book getBookById(@PathVariable int id){
    public Book getBookById(@Argument int id){
        return bookService.getBook(id);
    }

}
