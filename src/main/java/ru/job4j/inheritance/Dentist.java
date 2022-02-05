package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String tooth;

    public Dentist() {
    }

    public Dentist(String name, String surname, String education, int birthday, String recipe, String tooth) {
        super(name, surname, education, birthday, recipe);
        this.tooth = tooth;
    }

    public Dentist(String tooth) {
        super();
        this.tooth = tooth;
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
