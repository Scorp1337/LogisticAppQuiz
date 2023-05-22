package org.example;

import java.util.Comparator;

public class DateLocationComparator implements Comparator<Package> {


    @Override
    public int compare(Package pkg1, Package pkg2) {
        if (!pkg1.getTargetLocation().equals(pkg2.getTargetLocation())) {
            return pkg1.getTargetLocation().compareTo(pkg2.getTargetLocation());
        } else {
            return pkg1.getDeliveryDate().compareTo(pkg2.getDeliveryDate());
        }
    }
}
