/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopproj;

import java.util.ArrayList;

/**
 *
 * @author johnn
 */
public class Driver {

    private String name, carRegistrationNumber;
    private double maxWeight, maxVolume, currentWeight, currentVolume;
    private int[] zone;
    ArrayList<DeliveryItem> deliveries;

    public Driver(String name) {
        this(name, "", 500, 50, null);
    }

    public Driver(String name, String carRegistrationNumber,
            double maxWeight, double maxVolume, int[] zone) {
        this.zone = new int[2];

        if (zone.length == 2 && zone != null) {
            this.zone[0] = zone[0];
            this.zone[1] = zone[1];
        } else {
            this.zone[0] = 10000;
            this.zone[1] = 50000;
        }

        this.name = name;
        this.carRegistrationNumber = carRegistrationNumber;
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;

        deliveries = new ArrayList<>();
    }

    public boolean assignDelivery(DeliveryItem item) {
        if (item.getSerialNumber() >= zone[0] && item.getSerialNumber() <= zone[1]) {

            if (item instanceof Package) {
                Package poliItem = (Package) item;

                if (poliItem.getVolume() + currentVolume <= maxVolume
                        && poliItem.getWeight() + currentWeight <= maxWeight) {
                    deliveries.add(item);
                    currentVolume += poliItem.getVolume();
                    currentWeight += poliItem.getWeight();
                    item.setSatus('A');
                    return true;

                } else {
                    System.out.println("The driver has reached his capacity:\n"
                            + "Weight: " + currentWeight + "/" + maxWeight
                            + "\n Volume: " + currentVolume + "/" + maxVolume);
                    return false;
                }

            } else {
                deliveries.add(item);
                item.setSatus('A');
                return true;
            }

        } else {
            System.out.println("This item code doesn't respect the zone "
                    + "of delivery of the current driver.");
            return false;
        }
    }

    public boolean accomplishDelivery(int serial) {

        for (int i = 0; i < deliveries.size(); i++) {
            if (deliveries.get(i).getSerialNumber() == serial) {
                deliveries.get(i).setSatus('D');

                if (deliveries.get(i) instanceof Package) {
                    Package poliItem = (Package) deliveries.get(i);
                    currentVolume -= poliItem.getVolume();
                    currentWeight -= poliItem.getWeight();
                }

                deliveries.remove(deliveries.get(i));
                return true;
            }
        }

        System.out.println("Delivery Item not found.");
        return false;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public void setZone(int[] zone) {
        this.zone = zone.clone();
    }
    
     public String getName() {
        return name;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public int[] getZone() {
        return zone.clone();
    }

    public ArrayList<DeliveryItem> getDeliveries() {
        return (ArrayList<DeliveryItem>) deliveries.clone();
    }


    @Override
    public String toString() {
        return name + "\nActive Zone: " + '[' + zone[0] + '-' + zone[1]
                + "\nCar: " + carRegistrationNumber + "\nMax Weight: "
                + maxWeight + " - " + "Max Volume " + maxVolume + "\n";
    }

}
