/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopproj;

import java.time.LocalDate;


/**
 *
 * @author johnn
 */
public class DeliveryItem {

    private static int serialGenerator = 1000;
    private int serialNumber, senderPostalCode, receiverPostalCode;
    protected double cost;
    private char status;
    private String senderName, receiverName;
    private LocalDate date;
    private boolean insurance;

    public DeliveryItem(String senderName, String receiverName, int receiverPostalCode) {
        this(senderName, 1000, receiverName, receiverPostalCode);
    }

    public DeliveryItem(String senderName, int senderPostalCode, String receiverName, int receiverPostalCode) {
        date = LocalDate.now();
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.senderPostalCode = senderPostalCode;
        this.receiverPostalCode = receiverPostalCode;
        serialNumber = serialGenerator;
        serialGenerator++;
        status = 'R';
        insurance = false;
        cost = 2;

    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getSenderPostalCode() {
        return senderPostalCode;
    }

    public int getReceiverPostalCode() {
        return receiverPostalCode;
    }

    public double getCost() {
        return cost;
    }

    public char getStatus() {
        return status;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean getInsurance() {
        return insurance;
    }

    public void setSatus(char status) {
        if (status == 'A' || status == 'D' || status == 'R') {
            this.status = status;
        }
    }

    public void addInsurance() {
        if (insurance == false) {
            insurance = true;
            cost += 3;
        }
    }

    public void removeInsurance() {
        if (insurance == true) {
            insurance = false;
            cost -= 3;
        }
    }

    
    @Override
    public String toString(){
        return (this instanceof Envelope || this instanceof Package 
                ? "" : (serialNumber + "-" + date)) 
                + "\nSender : " + senderName + "-"
                + senderPostalCode + "\nReceiver : " + receiverName + "-" +
                receiverPostalCode + (insurance ? "With " : "Without ") + 
                "insurance." + "\nStatus : " + (status == 'R' ? "Received" :
                (status == 'D' ? "Delivered" : "Assigned"))+ "\n"; 
    }
}
