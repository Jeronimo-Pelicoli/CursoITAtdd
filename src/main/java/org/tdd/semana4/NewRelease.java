package org.tdd.semana4;

public class NewRelease extends Movie{

    public NewRelease(String title) {
        super(title);
    }

    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if(daysRented > 1) {
            return 2;
        }
        return 1;
    }

}
