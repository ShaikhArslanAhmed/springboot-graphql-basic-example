package com.sample.project.springgraphql.controller;

import com.sample.project.springgraphql.entities.Book;
import com.sample.project.springgraphql.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    //@PostMapping("/create")
    //public Book createBook(@RequestBody Book book) {
      //  return bookService.createBook(book);
    //}

    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        Book b=new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setPages(book.getPages());
        return this.bookService.createBook(b);
    }


    @GetMapping
    //@QueryMapping("getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }


    //@QueryMapping("getBookByName")
    @GetMapping("/getBookByName")
    public Book getBookByName(@RequestParam String name){
    //public Book getBookByName(@Argument String name){
        return bookService.getBookByName(name);
    }

}

@Getter
@Setter
class BookInput{
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
