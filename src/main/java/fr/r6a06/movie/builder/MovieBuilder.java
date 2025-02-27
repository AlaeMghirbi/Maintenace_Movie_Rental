package fr.r6a06.movie.builder;

import fr.r6a06.movie.Movie;
import fr.r6a06.movie.states.ChildrensPrice;
import fr.r6a06.movie.states.NewReleasePrice;
import fr.r6a06.movie.states.Price;
import fr.r6a06.movie.states.RegularPrice;

import static fr.r6a06.movie.Movie.CHILDRENS;
import static fr.r6a06.movie.Movie.NEW_RELEASE;

public class MovieBuilder {
    private String title;
    private Price _priceCode;

    public Movie build() {
        Movie movie =new Movie(title,_priceCode);
        return movie;
    }
    public MovieBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
    public MovieBuilder withPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                this._priceCode = new RegularPrice();
                break;
            case NEW_RELEASE:
                this._priceCode = new NewReleasePrice();
                break;
            case CHILDRENS:
                this._priceCode= new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Code prix invalide");
        }
        return this;
    }

}
