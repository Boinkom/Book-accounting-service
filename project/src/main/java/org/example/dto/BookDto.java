package org.example.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.example.repository.AuthorRepository;

@Data
public class BookDto {

    @NotBlank(message = "Название книги не должно быть пустым")
    private String title;

    @Max(value = 2025 , message = "Год публикации не должен быть больше 2025")
    private int publicationYear;

    @NotBlank(message = "Жанр книги не должен быть пустым")
    private String genre;

    private Long author_id;

}
