package org.example.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private int publicationYear; // year нельзя в SQL ключевое слово

    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
