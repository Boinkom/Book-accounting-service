package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.models.Author;
import org.example.models.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Book addBook(String title,String genre, int publicationYear, Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Автор с ID " + authorId + " не найден"));

        Book book = new Book();
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setGenre(genre);
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) throws IllegalAccessException {
        return bookRepository.findById(id)
                .orElseThrow(()-> new IllegalAccessException("Книга с ID "+ id + " не найдена."));
    }

    public void deleteBookById(Long id) throws IllegalAccessException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Книга не найдена"));
        bookRepository.delete(book);
    }

    public Book updateBook(Long id, String title, String genre, int year, Long authorId) throws IllegalAccessException {
        Book book = bookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Книга не найдена"));

        Author author = authorRepository.findById(authorId).orElseThrow(()-> new IllegalArgumentException(("Автор не найден")));

        book.setAuthor(author);
        book.setTitle(title);
        book.setGenre(genre);
        book.setPublicationYear(year);

        return bookRepository.save(book);
    }
}
