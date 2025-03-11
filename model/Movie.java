package movies.model;

import movies.model.enums.MovieType;

public class Movie {
    private final String title;
    private final MovieType priceType;

    public Movie(String title, MovieType priceType) {
        this.title = title;
        this.priceType = priceType;
    }

    public MovieType getPriceType() {
        return priceType;
    }

    public String getTitle() {
        return title;
    }
}
