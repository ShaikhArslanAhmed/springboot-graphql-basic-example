package com.sample.project.springgraphql.repositories;

import com.sample.project.springgraphql.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public Book findBookByTitle(String name);
}
