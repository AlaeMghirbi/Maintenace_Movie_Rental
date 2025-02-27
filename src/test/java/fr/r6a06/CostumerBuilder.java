package fr.r6a06;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class CostumerBuilder {
    private static final String Name="Costumer1";
    private String name=Name;
    private Vector<Rental> rentals= new Vector<Rental>();

    public Customer build() {
        Customer cos =new Customer(name);
        for (Rental r : rentals) {
            cos.addRental(r);
        }
        return cos;
    }
    public CostumerBuilder withName(String name) {
        this.name = name;
        return this;
    }
    public CostumerBuilder withRental(Rental... rentals) {
        Collections.addAll(this.rentals,rentals);
        return this;
    }
}
