package models;

import com.google.gson.Gson;

public class Owner {
    private String name;
    private int ID;
    private Object[] pets = new Object[10];
    private String[] petsType = new String[10];
    private int petCount = 0;

    public Owner() {
        name = "unknown";
        ID = 0;
    }

    public Owner(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setPetCount(int petCount) {
        this.petCount = petCount;
    }

    public void refreshPets() {
        pets = new Pet[10];
    }

    public void addPet(Object pet, String type) {
        pets[petCount] = pet;
        petsType[petCount] = type;
        petCount++;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getPetCount() {
        return petCount;
    }

    public Object[] getPets() {
        return pets;
    }
    public String[] getPetsType() {
        return petsType;
    }

    public void removePet(int index) {
        Object[] newPets = new Object[pets.length];
        String[] newPetsType = new String[petsType.length];
        for ( int i = 0, k = 0; i < pets.length; i++){
            if(i == index){
                continue;
            }
            newPetsType[k] = petsType[i];
            newPets[k++] = pets[i];

        }
        petsType = newPetsType;
        pets = newPets;
        petCount--;
    }

    public String toJson() {
        Gson gson = new Gson();
        String res = gson.toJson(this);
        return res;
    }

    public void fromJson(String data) {
        Gson gson = new Gson();
        Owner res = gson.fromJson(data, getClass());
        setName(res.getName());
        setID(res.getID());
        refreshPets();
        setPetCount(0);
        for (int i = 0; i <= res.getPetCount(); i++) {
            addPet(res.getPets()[i], getPetsType()[i]);
        }
    }
}
