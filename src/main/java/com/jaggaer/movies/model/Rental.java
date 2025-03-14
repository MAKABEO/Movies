package com.jaggaer.movies.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rental")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int daysRented;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double calculateRentalAmount() {
        return movie.getPriceType().calculateRentalAmount(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return movie.getPriceType().calculateFrequentRenterPoints(daysRented);
    }
}