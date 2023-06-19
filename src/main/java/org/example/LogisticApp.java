package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;


public class LogisticApp {

    List<Package> packages = new ArrayList<>();

    public void loadFileToList() {

        Path path = Path.of("file.csv");
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String targetLocation = values[0];
                int targetDistance = Integer.parseInt(values[1]);
                int value = Integer.parseInt(values[2]);
                LocalDate deliveryDate = LocalDate.parse(values[3]);
                packages.add(new Package(targetLocation, targetDistance, value, deliveryDate));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void groupPackages() throws InterruptedException {
        Set<Package> groupPackage = listToSet(packages);
        for (Package pkg : groupPackage) {
            DeliveryThread deliveryThread = new DeliveryThread(pkg.getTargetLocation(), pkg.getTargetDistance(), pkg.getDeliveryDate());
            deliveryThread.start();
            deliveryThread.join();
        }
        System.out.println("Total value of packages = " + calculateTotalValue(packages) + " LEI");
        System.out.println("Total revenue for all groups = " + calculateTotalRevenue(packages) + " LEI");
    }

    public int calculateTotalValue(List<Package> packages) {
        int totalValue = 0;
        for (Package pkg : packages) {
            totalValue += pkg.getValue();
        }
        return totalValue;
    }

    public int calculateTotalRevenue(List<Package> packages) {
        int totalRevenue = 0;
        for (Package pkg : packages) {
            totalRevenue += pkg.getTargetDistance();
        }
        return totalRevenue;
    }

    public Set<Package> listToSet(List<Package> packages) {
        TreeSet<Package> pkgSet = new TreeSet<>(new DateLocationComparator());
        for (Package pkg : packages) {
            pkgSet.add(new Package(pkg.getTargetLocation(), pkg.getTargetDistance(), pkg.getValue(),
                    pkg.getDeliveryDate()));
        }
        return pkgSet;
    }

    public int calculateGroupRevenue(String targetLocation) {
        int grpRevenue = 0;
        for (Package pkg : packages) {
            if (pkg.getTargetLocation().equals(targetLocation)) {
                grpRevenue += pkg.getTargetDistance();
            }
        }
        System.out.println(targetLocation + " revenue = " + grpRevenue + " LEI");
        return grpRevenue;
    }

    public int calculateGroupValue(String targetLocation) {
        int grpValue = 0;
        for (Package pkg : packages) {
            if (pkg.getTargetLocation().equals(targetLocation)) {
                grpValue += pkg.getValue();
            }
        }
        System.out.println(targetLocation + " value= " + grpValue + " LEI");
        return grpValue;
    }
}










