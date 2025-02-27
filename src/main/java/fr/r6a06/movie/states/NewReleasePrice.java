package fr.r6a06.movie.states;

import fr.r6a06.movie.Movie;

public class NewReleasePrice implements Price {
    @Override
    public int  getPriceCode(){
        return Movie.NEW_RELEASE;
    }
    @Override
    public double getCharge(int daysRented){
        return daysRented * 3;
    }
}
