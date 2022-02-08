package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book("Hunter", 568);
        Book bookTwo = new Book("Red Devil", 666);
        Book bookThree = new Book("Hell", 421);
        Book bookFour = new Book("Clean code", 217);

        Book[] arrayOfBook = new Book[4];
        arrayOfBook[0] = bookOne;
        arrayOfBook[1] = bookTwo;
        arrayOfBook[2] = bookThree;
        arrayOfBook[3] = bookFour;

        for (Book book : arrayOfBook) {
            System.out.println("Book name: \"" + book.getName() + "\", pages: " + book.getPages());
        }
        System.out.println();
        Book temp = arrayOfBook[0];
        arrayOfBook[0] = arrayOfBook[3];
        arrayOfBook[3] = temp;

        for (Book book : arrayOfBook) {
            System.out.println("Book name: \"" + book.getName() + "\", pages: " + book.getPages());

        }
        System.out.println();
        for (Book book : arrayOfBook) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("Book name: \"" + book.getName() + "\", pages: " + book.getPages());
            }
        }

    }
}


