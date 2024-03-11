/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopproj;

/**
 *
 * @author johnn
 */
public class Envelope extends DeliveryItem {

    private String size;

    public Envelope(String senderName, int senderPostalCode, String receiverName, int receiverPostalCode, String size) {
        super(senderName, senderPostalCode, receiverName, receiverPostalCode);
        setSize(size);
    }

    public Envelope(String senderName, String receiverName, int receiverPostalCode, String Size) {
        super(senderName, receiverName, receiverPostalCode);
        setSize(Size);
    }

    private void setCost() {
        cost = 2;
        switch (size) {
            case "A2":
                cost += 2;
                break;
            case "A6":
                cost += 1.6;
                break;
            case "A7":
                cost += 1.5;
                break;
            case "A9":
                cost += 1.2;
                break;
            case "4 square":
                cost += 1.8;
                break;
            case "5 square":
                cost += 1.6;
                break;
        }
        if(getInsurance())
            cost += 2;
    }

    public double getCost() {
        return cost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if ("A2".equals(size) || "A6".equals(size) || 
                "A7".equals(size) || "A9".equals(size)
                || "4 square".equals(size) || 
                "5 square".equals(size)) {
            this.size = size;
        } else {
            this.size = "A2";
        }

        setCost();
    }

    @Override
    public String toString() {
        return "Envelope: " + getSerialNumber() + "-" + getDate() + "\nSize : " 
                + size + super.toString() + "\nCost: " + getCost() ;
    }

}
