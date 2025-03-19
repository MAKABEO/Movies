package com.jaggaer.movies.model;

import com.jaggaer.movies.model.enums.MovieType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private MovieType priceType;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentalMovie> rentalMovies;

    public Movie() {
        this.rentalMovies = new ArrayList<>();
    }

    public Movie(String title, MovieType priceType) {
        this.title = title;
        this.priceType = priceType;
        this.rentalMovies = new ArrayList<>();
    }
}
