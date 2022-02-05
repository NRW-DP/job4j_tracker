package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String areaOfEmployment;

    public Engineer() {
    }

    public Engineer(String name, String surname, String education, int birthday, String areaOfEmployment) {
        super(name, surname, education, birthday);
        this.areaOfEmployment = areaOfEmployment;
    }

    public Engineer(String areaOfEmployment) {
        super();
        this.areaOfEmployment = areaOfEmployment;
    }

    public String getAreaOfEmployment() {
        return areaOfEmployment;
    }
}
