package org.springboot.basics.springbootlearning.controller;

import java.util.Arrays;
import java.util.List;

import org.springboot.basics.springbootlearning.book.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return Arrays.asList(new Book(1L, "Mastering Spring 5.0","Rwitam"));
	}
}