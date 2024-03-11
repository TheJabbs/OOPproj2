/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopproj;

/**
 *
 * @author johnn
 */
public class Package extends DeliveryItem {

    private double height, width, length, volume, weight;

    public Package(String senderName, String receiverName, int receiverPostalCode,
            double height, double width, double length,
             double weight) {
        super(senderName, receiverName, receiverPostalCode);
        if (height >= 0) {
            this.height = height;
        } else {
            this.height = 0.2;
        }

        if (weight >= 0) {
            this.weight = weight;
        } else {
            this.weight = 0.1;
        }

        if (width >= 0) {
            this.width = width;
        } else {
            this.width = 0.2;
        }
        if (length >= 0) {
            this.length = length;
        } else {
            this.length = 0.2;
        }

        setVolume();
    }

    public Package(String senderName, int senderPostalCode, String receiverName,
            int receiverPostalCode, double height, double width,
            double length, double weight) {
        super(senderName, senderPostalCode, receiverName, receiverPostalCode);
        if (height >= 0) {
            this.height = height;
        } else {
            this.height = 0.2;
        }

        if (weight >= 0) {
            this.weight = weight;
        } else {
            this.weight = 0.1;
        }

        if (height >= 0) {
            this.height = height;
        } else {
            this.height = 0.2;
        }
        if (length >= 0) {
            this.length = length;
        } else {
            this.length = 0.2;
        }

        volume = height * width * length;
    }

    private void setCost() {
        cost = 2;
        if(volume <= 2){
            cost += 2 + 3 * weight;
        } else if( volume > 2 && volume <= 5){
            cost += 2.8 + 3 * weight;
        } else {
            cost = + 2.8 + 3 * weight + 5 * (volume - 5);
        }
        
        if(getInsurance())
            cost += 20 * weight;
    }

    private void setVolume() {
        volume = height * width * length;
    }



    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    
        @Override
    public void addInsurance() {
        if (!getInsurance()) {
            super.addInsurance();
            setCost();
        }
    }
    
    @Override
    public void removeInsurance(){
        if(getInsurance()){
            super.removeInsurance();
            setCost();
        }
    }
    
    @Override
    public String toString(){
        return "Envelope: " + getSerialNumber() + " - " + getDate() + 
                "\nDimension: " + height + '*' + width + '*' + length
                + "\nVolume: " + getVolume() + " - Weight: " + weight + "\n"
                + super.toString() + "\nCost: " + cost;
    }
}
