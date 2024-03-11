/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopproj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author johnn
 */
public class OOPProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Driver> driverList = new ArrayList<>();
        ArrayList<DeliveryItem> itemList = new ArrayList<>();

        int choice = 0;

        do {

            displayMenu();

            System.out.println("Please enter your choice: ");

            do {
                choice = input.nextInt();
                if (!(choice < 13 && choice > 0)) {
                    System.out.println("Wrong input please enter a number "
                            + "between 1 and 13");
                }
            } while (!(choice < 13 && choice > 0));

            System.out.println();

            switch (choice) {
                case 1:

                    input.nextLine();
                    System.out.println("Please Enter the driver's name: ");
                    String name = input.nextLine();
                    System.out.println("Enter the car number: ");
                    String carNum = input.nextLine();
                    System.out.println("Enter the Max volume and weight");
                    double maxW = input.nextDouble();
                    double maxV = input.nextDouble();
                    System.out.println("Enter the Active zone range");
                    int num1 = input.nextInt();
                    int num2 = input.nextInt();

                    if (num1 > num2) {
                        int num = num1;
                        num1 = num2;
                        num2 = num;
                    }

                    driverList.add(new Driver(name, carNum,
                            maxW, maxV,
                            new int[]{num1, num2}));

                    System.out.println("Successfully added the driver\n");

                    break;

                case 2:

                    DeliveryItem item = null;

                    System.out.println("Enter the name of the item's sender and"
                            + " postal code");
                    String sname = input.nextLine();
                    input.nextLine();
                    int scode = input.nextInt();
                    System.out.println("Enter the receiver's name and "
                            + "postal code");
                    String rname = input.nextLine();
                    input.nextLine();
                    int rcode = input.nextInt();

                    char type = ' ';
                    System.out.println("Enter the item type:\n"
                            + "[E] for envelope\n"
                            + "[P] for package");
                    do {
                        type = input.next().charAt(0);
                        if (type != 'E' && type != 'P'
                                && type != 'e' && type != 'p') {
                            System.out.println("Please enter a valid input");
                        }

                    } while (type != 'E' && type != 'P'
                            && type != 'e' && type != 'p');

                    if (type == 'e' || type == 'E') {

                        System.out.println("Enter the envelope paper size "
                                + "(A2, A6, A7, A9, 4 square, 5 square): ");

                        String size = " ";

                        do {
                            input.nextLine();
                            size = input.nextLine();

                        } while (!("A2".equals(size)
                                || "A6".equals(size)
                                || "A7".equals(size)
                                || "A9".equals(size)
                                || "4 square".equals(size)
                                || "5 square".equals(size)));

                        item = new Envelope(sname, scode,
                                rname, rcode, size);

                    } else if (type == 'P' || type == 'p') {
                        System.out.println("Enter the dimensions of "
                                + "your package height, width, length and "
                                + "weight");

                        double height = 0, width = 0,
                                length = 0, weight = 0;

                        do {
                            input.nextLine();
                            height = input.nextDouble();
                            width = input.nextDouble();
                            length = input.nextDouble();
                            weight = input.nextDouble();
                        } while (height < 0 || width < 0 || length < 0
                                || weight < 0);

                        item = new Package(sname, scode,
                                rname, rcode, height,
                                width, length, weight);

                    }

                    itemList.add(item);
                    System.out.println("Item added successfuly.\n");
                    break;

            }

        } while (choice != 12);

    }

    static void displayMenu() {
        System.out.println("1. Add new driver.\n"
                + "2. Receive new item.\n"
                + "3. Display all items (received - assigned – delivered)\n"
                + "4. Display all received items.\n"
                + "5. Display all assigned items.\n"
                + "6. Display all delivered items.\n"
                + "7. Display all driver.\n"
                + "8. Assign item to a driver\n"
                + "9. Set item to received\n"
                + "10.Check a driver load\n"
                + "11.Display total cost\n"
                + "12. Exit.\n");
    }

}
