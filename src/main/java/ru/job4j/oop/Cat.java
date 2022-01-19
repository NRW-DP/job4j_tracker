package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meal) {
        this.food = meal;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat kitty = new Cat();
        kitty.giveNick("Леопольд");
        kitty.eat("Рыбка");
        kitty.show();
    }
}