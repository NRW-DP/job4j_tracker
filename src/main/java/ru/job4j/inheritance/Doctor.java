package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String recipe;

    public Doctor(String name, String surname, String education, int birthday, String recipe) {
        super(name, surname, education, birthday);
        this.recipe = recipe;
    }

    public String getRecipe() {
        return recipe;
    }

    public Diagnostics heal(Pacient pacient) {
        Diagnostics body = new Diagnostics();
        return body;
    }
}
