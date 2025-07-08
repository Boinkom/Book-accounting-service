package org.example.controller;

import jakarta.validation.Valid;
import lombok.*;
import org.example.dto.BookDto;
import org.example.models.Book;
import org.example.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookControl {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookDto bookDto) {
        Book book = bookService.addBook(
          bookDto.getTitle(),
          bookDto.getGenre(),
          bookDto.getPublicationYear(),
                bookDto.getAuthor_id()
        );
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public List<Book> findAllBook(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id) throws IllegalAccessException {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) throws IllegalAccessException {
        bookService.deleteBookById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @Valid @RequestBody BookDto bookDto) throws IllegalAccessException {
        Book updateBook = bookService.updateBook(
                id,
                bookDto.getTitle(),
                bookDto.getGenre(),
                bookDto.getPublicationYear(),
                bookDto.getAuthor_id()
        );
        return ResponseEntity.ok(updateBook);
    }
}
