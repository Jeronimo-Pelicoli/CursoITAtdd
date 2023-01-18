package org.tdd.semana4;

public class Regular extends Movie{

    public Regular(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 2;
        if(daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount;
    }

}
