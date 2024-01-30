import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class test {



        public static void main(String[] args) {
            Scanner Option = new Scanner(System.in);
            ArrayList <String> petList = new ArrayList<String>();

            int choice = 0;
            while (choice <= 5) {
                System.out.println("WELCOME TO 'FAMILYSH CHI BASHE?' OUR LITTLE P.H.!\n please select your choice(Do us a favour and just enter 5):");
                System.out.println("1. Check in my pet");
                System.out.println("2. My pet's state");
                System.out.println("3. Check out my pet");
                System.out.println("4. Show me the list");
                System.out.println("5. *Quit*");

                System.out.print("Enter your choice: ");
                choice = Option.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the name of your pet: ");
                        String petName = scanner.next();
                        petList.add(petName);
                        System.out.println(petName + " checked in successfully!");
                        break;
                    case 2:
                        if (petList.isEmpty()) {
                            System.out.println("No pets are checked in.");
                        } else {
                            System.out.println("Pets currently checked in:");
                            for (String pet : petList) {
                                System.out.println(pet);
                            }
                        }
                        break;
                    case 3:
                        if (petList.isEmpty()) {
                            System.out.println("No pets are checked in.");
                        } else {
                            System.out.print("Enter the name of the pet to check out: ");
                            String petToCheckOut = scanner.next();
                            if (petList.contains(petToCheckOut)) {
                                petList.remove(petToCheckOut);
                                System.out.println(petToCheckOut + " checked out successfully!");
                            } else {
                                System.out.println(petToCheckOut + " is not checked in.");
                            }
                        }
                        break;
                    case 4:
                        if (petList.isEmpty()) {
                            System.out.println("No pets are checked in.");
                        } else {
                            System.out.println("Pets currently checked in:");
                            for (String pet : petList) {
                                System.out.println(pet);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

                System.out.println();
            }

            scanner.close();
        }
    }



