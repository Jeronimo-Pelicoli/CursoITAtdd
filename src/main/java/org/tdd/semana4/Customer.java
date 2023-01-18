package org.tdd.semana4;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector rentals = new Vector();
    private int frequentRenterPoints;
    private double totalAmount;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
        frequentRenterPoints += rental.getFrequentRenterPoints();
        totalAmount += rental.getAmount();
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

}
