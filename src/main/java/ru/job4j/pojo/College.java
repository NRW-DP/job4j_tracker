package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan");
        student.setTeam("CS-Kiev");
        student.setStartDate(new Date());
        System.out.println("Имя студента: " + student.getName());
        System.out.println("Факультет: " + student.getTeam());
        System.out.println("Дата начала обучения: " + student.getStartDate());
    }
}
