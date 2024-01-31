package models;

import com.google.gson.Gson;

public class Dog extends Pet {
    String breed;

    public Dog() {
        super();
        breed = "something";
    }

    public Dog(String name, int age, String breed, float weight, String diet, String medication, boolean vaccinated,
            String sympthoms) {
        super(name, age, weight, sympthoms, sympthoms, vaccinated, sympthoms);
        this.breed = breed;
    }
    public Dog(String data){
        fromJson(data);
    }


    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return toJson();
    }

    public String toJson() {
        Gson gson = new Gson();
        String res = gson.toJson(this);
        return res;
    }

    public void fromJson(String data) {
        Gson gson = new Gson();
        Dog res = gson.fromJson(data, getClass());
        setName(res.getName());
        setAge(res.getAge());
        setWeight(res.getWeigh());
        setDiet(res.getDiet());
        setMedication(res.getMedication());
        setSympthoms(res.getSympthoms());
        setVaccinated(res.getVaccinated());
        setBreed(res.getBreed());
    }
}
