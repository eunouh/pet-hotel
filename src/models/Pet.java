package models;

public abstract class Pet {

    // attrbutes:
    protected String name;
    protected int age;
    // in month
    protected float weight;
    // in kilo
    protected String diet;

    // medications:
    protected String medication;
    protected boolean vaccinated;
    protected String sympthoms;

    public Pet() {
        name = "Unknown";
        age = 0;
        weight = (float) 0.0;
        diet = "Unknown";
        medication = "Unknown";
        vaccinated = false;
        sympthoms = "Unknown";
    }

    public Pet(String name, int age, float weight, String diet, String medication, boolean vaccinated,
            String sympthoms) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.diet = diet;
        this.medication = medication;
        this.vaccinated = vaccinated;
        this.sympthoms = sympthoms;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public float getWeigh() {
        return weight;
    }

    public void setWeight(float newWeight) {
        this.weight = newWeight;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String newDiet) {
        this.diet = newDiet;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String newMedication) {
        this.medication = newMedication;
    }

    public boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean newVaccinated) {
        this.vaccinated = newVaccinated;
    }

    public String getSympthoms() {
        return sympthoms;
    }

    public void setSympthoms(String newSympthoms) {
        this.sympthoms = newSympthoms;
    }

}