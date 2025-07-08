package org.example.service;

import org.example.models.Author;
import org.example.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AuthorServiceTest {

    private AuthorRepository authorRepository;
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        authorRepository = mock(AuthorRepository.class);
        authorService = new AuthorService(authorRepository);
    }

    @Test
    void addAuthor_shouldReturnAuthor() {
        Author expected = new Author();
        expected.setId(1L);
        expected.setName("Пушкин");
        expected.setBirth_year(1799);

        when(authorRepository.save(any(Author.class))).thenReturn(expected);

        Author result = authorService.addAuthor(1799, "Пушкин");

        assertEquals("Пушкин", result.getName());
        assertEquals(1799, result.getBirth_year());
    }

    @Test
    void findAuthorById_shouldReturnAuthor() throws IllegalAccessException {
        Author author = new Author();
        author.setId(1L);
        author.setName("Толстой");
        author.setBirth_year(1828);

        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        Author result = authorService.findAuthorById(1L);

        assertEquals("Толстой", result.getName());
    }

    @Test
    void findAuthorById_notFound_shouldThrow() {
        when(authorRepository.findById(1L)).thenReturn(Optional.empty());

        Exception ex = assertThrows(IllegalAccessException.class, () ->
                authorService.findAuthorById(1L));

        assertEquals("Автор с ID 1 не найден", ex.getMessage());
    }
}
