package com.test.annotationTest;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.annotations.Book;
import com.demo.annotations.BookRepository;
import com.demo.annotations.BookService;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationsTest {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;

	@Test
	public void demoCreateMocksUsingAnnotations() {
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);

		when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

		assertEquals(2, newBooksWithAppliedDiscount.size());
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());

	}

}