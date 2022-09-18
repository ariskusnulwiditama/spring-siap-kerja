package com.subrutin.service.impl;

import com.subrutin.domain.Author;
import com.subrutin.domain.Book;
import com.subrutin.dto.BookDetailDTO;
import com.subrutin.repository.BookRepository;
import com.subrutin.service.BookService;

public class BookServiceImpl implements BookService{
    private Book book;
    private BookRepository bookRepository;
    
    public BookServiceImpl() {
        Author author = new Author();
        this.book = new Book(author);
    }

	@Override
	public BookDetailDTO findBookDetailById(Long bookId) {
		Book book = bookRepository.findBookById(bookId);
		BookDetailDTO dto = new BookDetailDTO();
		dto.setBookId(book.getId());
		dto.setAuthorName(book.getAuthor().getName());
		dto.setBookTitle(book.getTitle());
		dto.setBookTitle(book.getDescription());
		return dto;
	}

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
}
