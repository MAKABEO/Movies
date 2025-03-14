package com.jaggaer.movies.model;

import com.jaggaer.movies.model.enums.MovieType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private MovieType priceType;

    public Movie(String title, MovieType priceType) {
        this.title = title;
        this.priceType = priceType;
    }
}
