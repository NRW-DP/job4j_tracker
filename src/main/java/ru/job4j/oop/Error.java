package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error constructor1 = new Error();
        constructor1.printInfo();
        System.out.println();
        Error constructor2 = new Error(true, 12, "Привет");
        constructor2.printInfo();
        System.out.println();
        Error constructor3 = new Error(false, 6, "Пока");
        constructor3.printInfo();
    }
}
