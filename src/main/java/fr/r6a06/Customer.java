package fr.r6a06;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;

    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public double getTotalAmout(){
        double totalAmount = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }

    public int getFrequentRentalPoints(){
        Enumeration rentals = _rentals.elements();
        int frequentRenterPoints = 0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
        }
        return frequentRenterPoints;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        int frequentRenterPoints = 0;
        String result = "Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmout()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRentalPoints()) +
                " frequent renter points";
        return result;
    }






}
