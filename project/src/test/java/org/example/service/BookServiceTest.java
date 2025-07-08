package org.example.service;

import org.example.models.Author;
import org.example.models.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        authorRepository = mock(AuthorRepository.class);
        bookService = new BookService(bookRepository, authorRepository);
    }

    @Test
    void addBook_shouldReturnBook() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Булгаков");
        author.setBirth_year(1891);

        Book book = new Book();
        book.setId(1L);
        book.setTitle("Мастер и Маргарита");
        book.setGenre("Роман");
        book.setPublicationYear(1967);
        book.setAuthor(author);

        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book result = bookService.addBook("Мастер и Маргарита", "Роман", 1967, 1L);

        assertEquals("Мастер и Маргарита", result.getTitle());
        assertEquals("Роман", result.getGenre());
        assertEquals(author, result.getAuthor());
    }
}
