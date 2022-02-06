package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private int numberOfEmployee;

    public Programmer(String name, String surname, String education, int birthday, String areaOfEmployment, int numberOfEmployee) {
        super(name, surname, education, birthday, areaOfEmployment);
        this.numberOfEmployee = numberOfEmployee;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
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
