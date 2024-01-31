package user_interface;

import java.util.Scanner;

import data_base.*;
import models.*;

public class Interface {
    public static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        int choice = 0;
        System.out.println(
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" + //
                        "░  ░░░░  ░░        ░░  ░░░░░░░░░      ░░░░      ░░░  ░░░░  ░░        ░\n" + //
                        "▒  ▒  ▒  ▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒   ▒▒   ▒▒  ▒▒▒▒▒▒▒\n" + //
                        "▓        ▓▓      ▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓  ▓▓        ▓▓      ▓▓▓\n" + //
                        "█   ██   ██  ████████  ████████  ████  ██  ████  ██  █  █  ██  ███████\n" + //
                        "█  ████  ██        ██        ███      ████      ███  ████  ██        █\n" + //
                        "██████████████████████████████████████████████████████████████████████\n" + //
                        "");

        while (choice < 5) {

            System.out.println(
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" + //
                            "\n     please select your choice(Do us a favour and just enter 5):\n" + //
                            "\n" + //
                            "                      1. Check in my pet\n" + //
                            "\n" + //
                            "                      2. My pet's state\n" + //
                            "\n" + //
                            "                      3. Check out my pet\n" + //
                            "\n" + //
                            "                      4. Show me the list\n" + //
                            "\n" + //
                            "                      5. *Quit*\n\n" + //
                            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    option1();
                    continue;
                case 2:
                    option2();
                    continue;
                case 3:
                    option3();
                    continue;
                case 4:
                    option4();
                    continue;
                case 5:
                    System.out.println("GoodBye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }
        }
        scanner.close();

    }

    public static void option1() {
        System.out.print(" Please enter your 4-digit ID:\n" + //
                "(If you don't have one, it's okay we got you.\n" + //
                "Just enter the ID you want us to identify You with.): \n");

        int ID = scanner.nextInt();
        // We just have to initialize it.. not important
        Pet pet = new Cat();

        if (!DataBase.searchByID(ID)) {
            System.out.println("Please Enter your name:");
            String ownersName = scanner.next();
            DataBase.addOwner(new Owner(ownersName, ID));
        }

        System.out.println("What sound does your pet make?\n" + //
                "1. Meow     2. Woof      3. Tweet");
        int petType;
        while (true) {
            petType = scanner.nextInt();
            if (petType > 3 || petType < 1) {
                System.out.println("Invalid choice. Please try again.");
            } else {
                break;
            }
        }

        System.out.println("What should we call our new guest?");
        String petsname = scanner.next();

        System.out.println("And their age? ( in month please.)");
        int petsAge = scanner.nextInt();

        System.out.println("What makes them sneeze and wheeze?\n" + //
                "0. Nothing     1. Antibiotics     2. NASIDs      3. Corticosteroids");
        int num;
        while (true) {
            num = scanner.nextInt();
            if (num > 3 || num < 0) {
                System.out.println("Invalid choice. Please try again.");
            } else {
                break;
            }
        }

        String[] allergies = { "Nothing", "Antibiotics", "NASIDs", "Corticosteroids" };

        String sym = allergies[num];

        switch (petType) {
            case 1:
                pet = new Cat(petsname, petsAge, (float) 0.0, "", "", false, sym);

                break;
            case 2:
                System.out.println("What kind of pupper do you have?");
                String breed = scanner.next();
                pet = new Dog(petsname, petsAge, breed, (float) 0.0, "", "", false, sym);

                break;
            case 3:
                pet = new Bird(petsname, petsAge, (float) 0.0, "", "", false, sym);

                break;
            default:
                System.out.println("Invalid choice. Please try again.");

                break;
        }

        System.out.println("\n<< CHECKED IN SUCCESSFULLY! >>\n");
        String[] petTypes = { "Cat", "Dog", "Bird" };
        DataBase.addPet(ID, pet, petTypes[petType - 1]);
    }

    public static void option2() {
        System.out.println("Enter Your ID:");
        int ID = scanner.nextInt();
        String[] petNames = DataBase.ownersPetsName(ID);

        if (petNames[0] == null) {
            System.out.println("you don't have any pet here!");
            return;
        } else {
            System.out.println("choose your pet:");
        }
        for (int i = 0; i < petNames.length; i++) {
            if (petNames[i] == null) {
                break;
            }
            System.out.print("    " + i + ". " + petNames[i]);
        }
        System.out.println();
        int index = scanner.nextInt();
        Vet.printPetState(ID, index);
        return;
    }

    public static void option3() {
        System.out.println("Enter Your ID:");
        int ID = scanner.nextInt();
        String[] petNames = DataBase.ownersPetsName(ID);

        if (petNames[0] == null) {
            System.out.println("you don't have any pet here!");
            return;
        } else {
            System.out.println("choose your pet:");
        }
        for (int i = 0; i < petNames.length; i++) {
            if (petNames[i] == null) {
                break;
            }
            System.out.print("    " + i + ". " + petNames[i]);
        }
        System.out.println();
        int index = scanner.nextInt();
        System.out.println("cost by dollar:");

        // get the cost from vet:
        System.out.println(Vet.getCost(ID, index));

        DataBase.removePet(ID, index);

        System.out.println("\n<< CHECKED OUT! >>\n");

    }

    public static void option4() {

        System.out.println("all of checked in pets");

        String[] allPets = DataBase.allPets();
        System.out.println();
        for (String pet : allPets) {
            if (pet == null) {
                System.out.println();
                return;
            }
            System.out.println("    " + pet);
        }

    }

}