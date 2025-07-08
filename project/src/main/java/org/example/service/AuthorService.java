package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.models.Author;
import org.example.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author addAuthor(int birth_year, String name) {
        Author author = new Author();
        author.setName(name);
        author.setBirth_year(birth_year);
        return authorRepository.save(author);
    }

    public Page<Author> getAllAuthors(int page, int size) {
        return authorRepository.findAll(PageRequest.of(page, size));
    }

    public Author findAuthorById(Long id) throws IllegalAccessException {
        return authorRepository.findById(id)
                .orElseThrow(()-> new IllegalAccessException("Автор с ID " + id + " не найден"));
    }
}
