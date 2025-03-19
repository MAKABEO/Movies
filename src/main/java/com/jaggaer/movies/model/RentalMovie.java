package com.jaggaer.movies.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rental_movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentalMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    private int daysRented;

    public RentalMovie(Rental rental, Movie movie, int daysRented) {
        this.rental = rental;
        this.movie = movie;
        this.daysRented = daysRented;
    }
}
