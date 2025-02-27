package fr.r6a06.movie.states;

import fr.r6a06.movie.Movie;

public class RegularPrice implements Price {
    @Override
    public int getPriceCode(){
        return Movie.REGULAR;
    }
    @Override
    public double getCharge(int daysRented){
        double price = 2;
        if (daysRented > 2)

            price += (daysRented - 2) * 1.5;
        return price;
    }
}
