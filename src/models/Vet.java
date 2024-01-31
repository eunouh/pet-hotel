package models;

import data_base.DataBase;

import java.util.ArrayList;
import java.util.Random;

public class Vet {
    public static void printPetState(int ID, int index) {
        Pet pet = DataBase.getPet(ID, index);

        if (pet.getMedication().equals(""))
            getMedication(ID, index);
        if (pet.getDiet().equals(""))
            getDiet(ID, index);
        getVaccinated(ID, index);

        pet = DataBase.getPet(ID, index);
        System.out.print("\nyour pet has" + ((pet.getVaccinated()) ? (" ") : (" not ")) + "been vaccinated\n" + //
                "Vitamins intended for their food: " + pet.getDiet() + "\n" + //
                "Medicines used for them: " + pet.getMedication() + "\n");

    }

    public static void getMedication(int ID, int index) {
        Pet pet = DataBase.getPet(ID, index);
        String[] alg = { "Nothing", "Antibiotics", "NASIDs", "Corticosteroids" };
        String[] med = { "Nothing", "Antihistamines", "Dexamethasone", "Cyclosporine" };
        for (int i = 0; i < 4; i++) {
            if (pet.sympthoms.equals(alg[i])) {
                pet.setMedication(med[i]);
            }
        }
        DataBase.editPet(ID, pet, index);
    }

    public static void getVaccinated(int ID, int index) {
        Pet pet = DataBase.getPet(ID, index);
        pet.setVaccinated(true);
        DataBase.editPet(ID, pet, index);
    }

    public static void getDiet(int ID, int index) {
        Pet pet = DataBase.getPet(ID, index);
        ArrayList<String> vitamins = new ArrayList<>();
        vitamins.add("Vitamin E");
        vitamins.add("Vitamin A");
        vitamins.add("Calcium");
        vitamins.add("Fish Oil");
        vitamins.add("Magnesium");
        Random randomvit = new Random();
        int numOptions = randomvit.nextInt(2) + 1;
        String med = "";
        for (int i = 0; i <= numOptions; i++) {
            int in = randomvit.nextInt(vitamins.size());
            med = med + vitamins.get(in) + " | ";
            vitamins.remove(in);
        }
        pet.setDiet(med);
        DataBase.editPet(ID, pet, index);
    }

    public static int getCost(int ID, int index) {
        Pet pet = DataBase.getPet(ID, index);
        String med = pet.getDiet();
        String[] meds = med.split("&");
        int cost = meds.length + 17;
        return cost;
    }
}