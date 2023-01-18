package org.tdd;

import junit.framework.TestCase;
import org.tdd.semana4.Customer;
import org.tdd.semana4.Movie;
import org.tdd.semana4.Rental;

public class TestCustomer extends TestCase {

    Customer client;

    protected void setUp() throws Exception {
        client = new Customer("John");
    }

    public void testNameCreation() {
        String result = client.statement();
        assertContain(result, "Rental Record for John");
    }

    public void testOneRegularOneDay() {
        rentMovie("Indiana Jones", Movie.REGULAR, 1);
        String result = client.statement();
        assertContain(result, "Amount owed is 2.0");
        assertContain(result, "You earned 1 frequent renter points");
    }

    public void testeOneRegularTreeDays() {
        rentMovie("Indiana Jones", Movie.REGULAR, 3);
        String result = client.statement();
        assertContain(result, "Amount owed is 3.5");
        assertContain(result, "You earned 1 frequent renter points");
    }

    public void testOneChildrensOneDay() {
        rentMovie("Procurando Nemo", Movie.CHILDRENS, 1);
        String result = client.statement();
        assertContain(result, "Amount owed is 1.5");
        assertContain(result, "You earned 1 frequent renter points");
    }

    public void testOneChildrensFiveDay() {
        rentMovie("Procurando Nemo", Movie.CHILDRENS, 5);
        String result = client.statement();
        assertContain(result, "Amount owed is 4.5");
        assertContain(result, "You earned 1 frequent renter points");
    }

    public void testOneNewReleaseOneDay() {
        rentMovie("Vingadores 2", Movie.NEW_RELEASE, 1);
        String result = client.statement();
        assertContain(result, "Amount owed is 3.0");
        assertContain(result, "You earned 1 frequent renter points");
    }

    public void testOneNewReleaseTreeDay() {
        rentMovie("Vingadores 2", Movie.NEW_RELEASE, 3);
        String result = client.statement();
        assertContain(result, "Amount owed is 9.0");
        assertContain(result, "You earned 2 frequent renter points");
    }

    public void testManyRents() {
        rentMovie("Vingadores 2", Movie.NEW_RELEASE, 2);
        rentMovie("Star Wars - Episodio VII", Movie.NEW_RELEASE, 3);
        rentMovie("Procurando Nemo", Movie.CHILDRENS, 3);
        rentMovie("Indiana Jones", Movie.REGULAR, 2);
        rentMovie("Divertidamente", Movie.CHILDRENS, 4);
        rentMovie("E o vento levou ... ", Movie.REGULAR, 3);
        String result = client.statement();
        assertContain(result, "Amount owed is 25.0");
        assertContain(result, "You earned 8 frequent renter points");
    }

    private void rentMovie(String title, int type, int days) {
        Movie movie = Movie.createMovie(title, type);
        Rental rent = new Rental(movie, days);
        client.addRental(rent);
    }

    private void assertContain(String result, String content) {
        assertTrue(result.indexOf(content) >= 0);
    }
}
