package fr.r6a06.movie.states;

import fr.r6a06.movie.Movie;

public class ChildrensPrice implements Price {
    @Override
    public int getPriceCode(){
        return Movie.CHILDRENS;
    }
    @Override
    public double getCharge(int daysRented){
        double prix= 1.5;
        if (daysRented > 3)
            prix += (daysRented - 3) * 1.5;
        return prix;
    }

}
