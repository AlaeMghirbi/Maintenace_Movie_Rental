package fr.r6a06.movie;

import fr.r6a06.movie.builder.MovieBuilder;
import fr.r6a06.movie.states.ChildrensPrice;
import fr.r6a06.movie.states.NewReleasePrice;
import fr.r6a06.movie.states.Price;
import fr.r6a06.movie.states.RegularPrice;

public class Movie {
    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    private String _title;
    private Price _priceCode;

    public Movie(String title, Price priceCode) {
        this._title = title;
        this._priceCode = priceCode;
    }
    public int getPriceCode() {
        return _priceCode.getPriceCode();
    }
    public void setPriceCode(Price priceCode) {
        this._priceCode = priceCode;
    }
    public String getTitle (){
        return _title;
    };
    public double getCharge(int daysRented) {
        return  _priceCode.getCharge(daysRented);
    }
    public  int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 0 ;
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((this.getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented> 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }
}