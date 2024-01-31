package com.sample.project.springgraphql;

import com.sample.project.springgraphql.entities.Book;
import com.sample.project.springgraphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGraphqlApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlApplication.class, args);
		System.out.println(" - - - Running - - - ");
	}

	@Override
	public void run(String... args) throws Exception {

		Book b1 = new Book();
		b1.setAuthor("Author 1");
		b1.setId(1);
		b1.setDesc("description 1");
		b1.setTitle("title 1");
		b1.setPages(10);
		b1.setPrice(1000);

		Book b2 = new Book();
		b2.setAuthor("Author 2");
		b2.setId(2);
		b2.setDesc("description 2");
		b2.setTitle("title 2");
		b2.setPages(20);
		b2.setPrice(2000);

		bookService.createBook(b1);
		bookService.createBook(b2);


	}
}
