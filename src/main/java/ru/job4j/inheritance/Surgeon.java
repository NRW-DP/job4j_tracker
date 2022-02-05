package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String operation;

    public Surgeon() {
    }

    public Surgeon(String name, String surname, String education, int birthday, String recipe, String operation) {
        super(name, surname, education, birthday, recipe);
        this.operation = operation;
    }

    public Surgeon(String operation) {
        super();
        this.operation = operation;
    }

    public String getOperation() {
    return operation;
    }

    public String getName() {
        return super.getName();
    }

    public String getSurname() {
        return super.getSurname();
    }

    public String getEducation() {
        return super.getEducation();
    }

    public int getBirthday() {
        return super.getBirthday();
    }
}
