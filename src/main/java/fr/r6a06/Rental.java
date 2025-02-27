package fr.r6a06;

import fr.r6a06.movie.Movie;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }


    public double getCharge() {
        Movie movie = getMovie();
        return movie.getCharge(_daysRented);
    }
        public  int getFrequentRenterPoints() {
            Movie movie = getMovie();
            return movie.getFrequentRenterPoints(_daysRented);

    }
}
