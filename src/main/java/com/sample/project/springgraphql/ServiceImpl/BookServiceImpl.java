package com.sample.project.springgraphql.ServiceImpl;

import com.sample.project.springgraphql.entities.Book;
import com.sample.project.springgraphql.repositories.BookRepository;
import com.sample.project.springgraphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book b) {
        Book a = bookRepository.save(b);
        return getBook(a.getId());
    }

    @Override
    public Book getBook(int id) {
       return bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
    }

    @Override
    public Book getBookByName(String name) {
        return bookRepository.findBookByTitle(name);
    }


    @Override
    public List<Book> getAll() {
       return bookRepository.findAll();
    }
}
