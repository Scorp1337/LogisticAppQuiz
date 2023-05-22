package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogisticAppTest {

    @org.junit.jupiter.api.Test
    void testCalculateTotalValue() {

        LogisticApp app = new LogisticApp();
        List<Package> newList = new ArrayList<>();

        newList.add(new Package("Suceava", 15, 100, LocalDate.of(1999, 1, 1)));
        newList.add(new Package("Bucuresti", 15, 200, LocalDate.of(2015, 3, 1)));
        newList.add(new Package("Iasi", 15, 300, LocalDate.of(2021, 5, 2)));

        app.calculateTotalValue(newList);
        assertEquals(600, app.calculateTotalValue(newList));

    }

    @org.junit.jupiter.api.Test
    void testCalculateTotalRevenue() {
        LogisticApp app = new LogisticApp();
        List<Package> newList = new ArrayList<>();

        newList.add(new Package("Suceava", 15, 100, LocalDate.of(1999, 1, 1)));
        newList.add(new Package("Bucuresti", 20, 200, LocalDate.of(2015, 3, 1)));
        newList.add(new Package("Iasi", 100, 300, LocalDate.of(2021, 5, 2)));

        app.calculateTotalValue(newList);
        assertEquals(135, app.calculateTotalRevenue(newList));
    }

    @Test
    void testCalculateGroupRevenue() {
        LogisticApp app = new LogisticApp();

        app.packages.add(new Package("Suceava", 15, 100, LocalDate.of(1995, 1, 1)));
        app.packages.add(new Package("Suceava", 15, 100, LocalDate.of(1991, 1, 1)));
        app.packages.add(new Package("Suceava", 15, 100, LocalDate.of(1999, 1, 1)));

        int revenue = app.calculateGroupRevenue("Suceava");
        assertEquals(45, revenue);
    }

    @Test
    void testCalculateGroupValue() {
        LogisticApp app = new LogisticApp();

        app.packages.add(new Package("Bucuresti", 20, 100, LocalDate.of(2015, 3, 1)));
        app.packages.add(new Package("Bucuresti", 20, 100, LocalDate.of(2015, 3, 1)));
        app.packages.add(new Package("Bucuresti", 20, 100, LocalDate.of(2015, 3, 1)));


        int value = app.calculateGroupValue("Bucuresti");
        assertEquals(300, value);
    }
}