package data_base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import models.*;

public class DataBase {
    public static AllOwners owners = new AllOwners(readDataBase());

    public static void refresh() {
        owners = new AllOwners(readDataBase());
    }

    public static String readDataBase() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dataBase.json"));
            String something = reader.readLine();
            String result = "";
            while (something != null) {
                result = result + something + "\n";
                something = reader.readLine();
            }
            reader.close();
            if (result == null || result == "") {
                AllOwners newAllOwners = new AllOwners();
                writeToDataBase(newAllOwners.toJson());
                return newAllOwners.toJson();
            }
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("file doesn't exist or unexpected error!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't read the file :(");
            e.printStackTrace();
        }
        return null;

    }

    public static void writeToDataBase(String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dataBase.json"));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("file doesn't exist or unexpected error!");
            e.printStackTrace();
        }
    }

    public static boolean searchByID(int ID) {
        refresh();
        for (Owner owner : owners.getAllOwners()) {
            if (owner == null) {
                return false;
            }
            if (owner.getID() == ID) {
                return true;
            }
        }
        return false;
    }

    public static void addPet(int ID, Object pet, String petType) {
        refresh();
        for (Owner owner : owners.getAllOwners()) {
            if (owner.getID() == ID) {
                owner.addPet(pet, petType);
                writeToDataBase(owners.toJson());
                return;
            }
        }
        System.out.print("Owner doesn't exist.");
    }

    public static void removePet(int ID, int indexOfPet) {
        refresh();
        for (Owner owner : owners.getAllOwners()) {
            if (owner.getID() == ID) {
                owner.removePet(indexOfPet);
                writeToDataBase(owners.toJson());
                return;
            }
        }
        System.out.print("Owner doesn't exist.");
    }

    public static Pet getPet(int ID, int indexOfPet) {
        refresh();
        for (Owner owner : owners.getAllOwners()) {
            if (owner.getID() == ID) {
                Object pet = owner.getPets()[indexOfPet];
                writeToDataBase(owners.toJson());
                switch (owner.getPetsType()[indexOfPet]) {
                    case "Cat":
                        return new Cat(convertStringToJSON(pet.toString()));
                    case "Dog":
                        return new Dog(convertStringToJSON(pet.toString()));
                    case "Bird":
                        return new Bird(convertStringToJSON(pet.toString()));
                    default:
                        break;
                }
            }
        }
        return null;
    }

    public static void editPet(int ID, Object pet, int indexOfPet) {
        refresh();
        for (Owner owner : owners.getAllOwners()) {
            if (owner.getID() == ID) {
                owner.getPets()[indexOfPet] = pet;
                writeToDataBase(owners.toJson());
                return;
            }
        }
    }

    public static void addOwner(Owner owner) {
        refresh();
        owners.addOwner(owner);
        writeToDataBase(owners.toJson());
    }

    public static String[] allPets() {
        refresh();
        String[] allPets = new String[100];
        int i = 0;
        for (Owner owner : owners.getAllOwners()) {
            if (owner == null) {
                break;
            }
            for (int j = 0; j < owner.getPetCount(); j++) {
                if (owner.getPets()[j] == null) {
                    break;
                }
                Object pet = owner.getPets()[j];
                switch (owner.getPetsType()[j]) {
                    case "Cat":
                        allPets[i] = new Cat(convertStringToJSON(pet.toString())).getName();
                        i++;
                        continue;
                    case "Dog":
                        allPets[i] = new Dog(convertStringToJSON(pet.toString())).getName();
                        i++;
                        continue;
                    case "Bird":
                        allPets[i] = new Bird(convertStringToJSON(pet.toString())).getName();
                        i++;
                        continue;
                    default:
                        break;
                }
            }
        }
        return allPets;
    }

    public static String convertStringToJSON(String jsonString) {
        String res = "";
        char opening = 123;
        char ending = 125;
        jsonString = jsonString.substring(1, jsonString.length() - 1);
        for (String keyValuePair : jsonString.split(",")) {
            String[] keyAndValue = keyValuePair.split("=");
            String key = keyAndValue[0];
            String value;
            if (keyAndValue.length == 1) {
                value = "";
            } else {
                value = keyAndValue[1];
            }
            // jsonMap.put(key, value);
            if (key.startsWith(" ")) {
                key = key.substring(1);
            }
            if (key.equals("name") || key.equals("diet") || key.equals("medication")) {
                res = res + "\"" + key + "\":" + "\"" + value + "\",";
            } else if (key.equals("sympthoms")) {
                res = res + "\"" + key + "\":" + "\"" + value + "\"";

            } else {
                res = res + "\"" + key + "\":" + value + ",";

            }
        }
        res = opening + res + ending;
        return res;
    }

    public static String[] ownersPetsName(int ID) {
        refresh();
        String[] res = new String[10];
        for (Owner owner : owners.getAllOwners()) {
            if (owner == null) {
                break;
            }
            if (owner.getID() == ID) {
                for (int i = 0; i < owner.getPetCount(); i++) {
                    Object pet = owner.getPets()[i];
                    // System.out.println(pet.toString());
                    // System.out.println(convertStringToJSON(pet.toString()));
                    switch (owner.getPetsType()[i]) {
                        case "Cat":
                            res[i] = new Cat(convertStringToJSON(pet.toString())).getName();
                            // continue;
                        case "Dog":
                            res[i] = new Dog(convertStringToJSON(pet.toString())).getName();
                            // continue;
                        case "Bird":
                            res[i] = new Bird(convertStringToJSON(pet.toString())).getName();
                            // continue;
                        default:
                            break;
                    }
                }
            }
        }
        return res;
    }
}
