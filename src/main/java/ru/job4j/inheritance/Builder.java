package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int numberOfDaileTask;

    public Builder(String name, String surname, String education, int birthday, String areaOfEmployment, int numberOfDaileTask) {
        super(name, surname, education, birthday, areaOfEmployment);
        this.numberOfDaileTask = numberOfDaileTask;
    }

    public int getNumberOfDaileTask() {
        return numberOfDaileTask;
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
