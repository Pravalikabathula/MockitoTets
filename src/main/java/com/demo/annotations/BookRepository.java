package com.demo.annotations;

import java.util.List;

public interface BookRepository {

	List<Book> findNewBooks(int days);
}