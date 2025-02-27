package fr.r6a06;

import fr.r6a06.movie.Movie;
import fr.r6a06.movie.builder.MovieBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void should_check_costumer_creted() {
        //arrange
        Customer cos = new CostumerBuilder().build();
        //act
        //assert
        Assertions.assertNotNull(cos);
    }
    @Test
    public void should_check_costumer_getName(){
        //arrange
        Customer cos = new CostumerBuilder().withName("Cos").build();
        Assertions.assertEquals("Cos", cos.getName());
    }
    @Test
    public void should_check_Regular_statement(){
        Movie movie1= new MovieBuilder()
                .withTitle("Titanic")
                .withPriceCode(0)
                .build();

        Rental rental1=new Rental(movie1,1);
        Customer cos=new CostumerBuilder()
                .withName("Alae")
                .withRental(rental1)
                .build();
        //act
        String expected="Record for Alae\n\tTitanic\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points";
        String actual = cos.statement();
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void statementForNewReleaseMovie() {
        Movie movie1= new MovieBuilder()
                .withTitle("Star Wars")
                .withPriceCode(Movie.NEW_RELEASE)
                .build();

        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        Customer customer2 =
                new CostumerBuilder()
                        .withName("Sallie")
                        .withRental(rental1)
                        .build();
        String expected = "Record for Sallie\n" +
                "\tStar Wars\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";
        String statement = customer2.statement();
        assertEquals(expected, statement);
    }

    @Test
    public void statementForChildrensMovie() {
        Movie movie1= new MovieBuilder()
                .withTitle("Madagascar")
                .withPriceCode(Movie.CHILDRENS)
                .build();

        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        Customer customer2
                = new CostumerBuilder()
                .withName("Sallie")
                .withRental(rental1)
                .build();
        String expected = "Record for Sallie\n" +
                "\tMadagascar\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        String statement = customer2.statement();
        assertEquals(expected, statement);
    }
    @Test
    public void statementForManyMovies() {
        Movie movie1= new MovieBuilder()
                .withTitle("Madagascar")
                .withPriceCode(Movie.CHILDRENS)
                .build();
        Movie movie2= new MovieBuilder()
                .withTitle("Sallie")
                .withPriceCode(Movie.NEW_RELEASE)
                .build();
        Movie movie3= new MovieBuilder()
                .withTitle("Titanic")
                .withPriceCode(Movie.REGULAR)
                .build();


        Rental rental1 = new Rental(movie1, 6);
        Rental rental2 = new Rental(movie2, 2);
        Rental rental3 = new Rental(movie3, 8);
        Customer cos=new CostumerBuilder()
                .withName("Alae")
                .withRental(rental1,rental2,rental3)
                .build();
        String expected = "Record for Alae\n" +
                "\tMadagascar\t6.0\n" +
                "\tSallie\t6.0\n" +
                "\tTitanic\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points";
        String statement = cos.statement();
        assertEquals(expected, statement);
    }

}
