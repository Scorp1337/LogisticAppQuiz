package org.example;


public class App {

    public static void main(String[] args) throws InterruptedException {

        LogisticApp app = new LogisticApp();

        app.loadFileToList();
        app.calculateGroupValue("Apahida");
        app.calculateGroupValue("Floresti");
        app.calculateGroupValue("Turda");
        app.calculateGroupRevenue("Apahida");
        app.calculateGroupRevenue("Floresti");
        app.calculateGroupRevenue("Turda");
        app.groupPackages();


    }

}
