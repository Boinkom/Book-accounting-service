package org.example.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int birth_year;

}
