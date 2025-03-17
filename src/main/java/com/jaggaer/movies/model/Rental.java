package com.jaggaer.movies.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rental")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentalMovie> rentalMovies;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Rental() {
        this.rentalMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, int daysRented) {
        RentalMovie rentalMovie = new RentalMovie(this, movie, daysRented);
        rentalMovies.add(rentalMovie);
    }
}