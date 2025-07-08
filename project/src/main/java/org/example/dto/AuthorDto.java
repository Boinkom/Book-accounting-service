package org.example.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AuthorDto {

    @NotBlank(message = "Имя автора не должно быть пустым")
    private String name;

    @Max(value = 2025, message = "Год рождения должен быть меньше 2025")
    private int birth_year;

}
