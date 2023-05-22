package org.example;

import java.time.LocalDate;

public class DeliveryThread extends Thread {

    private final String targetLocation;

    private final int targetDistance;

    private final LocalDate deliveryDate;

    public DeliveryThread(String targetLocation, int targetDistance, LocalDate deliveryDate) {
        this.targetLocation = targetLocation;
        this.targetDistance = targetDistance;
        this.deliveryDate = deliveryDate;
    }

    @Override
    public void  run() {

        System.out.println("[Delivering for <" + targetLocation + "> and date <" + deliveryDate + "> in <" + targetDistance + "> seconds.");
        countdown();
        System.out.println("[Delivered]");
    }

    public void countdown() {
        int countdown = targetDistance;
        while (countdown > 0) {
            System.out.print("." + " ");
            try {
                countdown--;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}


