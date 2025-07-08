package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.AuthorDto;
import org.example.models.Author;
import org.example.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authors")
public class AuthorControl {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> addAuthor(@Valid @RequestBody AuthorDto authorDto) {
        Author author = authorService.addAuthor(
                authorDto.getBirth_year(),
                authorDto.getName()
        );
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<Page<Author>>findAllAuthors(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "10") int size
    ) {
        Page<Author> authorPage = authorService.getAllAuthors(page, size);
        return ResponseEntity.ok(authorPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id) throws IllegalAccessException {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }
}
