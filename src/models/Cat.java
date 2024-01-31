package models;

import com.google.gson.Gson;

public class Cat extends Pet {

    public Cat() {
        super();
    }

    public Cat(String name, int age, float weight, String diet, String medication, boolean vaccinated,
            String sympthoms) {
        super(name, age, weight, diet, medication, vaccinated, sympthoms);
    }

    public Cat(String data){
        fromJson(data);
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
        Cat res = gson.fromJson(data, getClass());
        setName(res.getName());
        setAge(res.getAge());
        setWeight(res.getWeigh());
        setDiet(res.getDiet());
        setMedication(res.getMedication());
        setSympthoms(res.getSympthoms());
        setVaccinated(res.getVaccinated());
    }
}
