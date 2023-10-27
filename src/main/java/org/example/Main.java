package org.example;

interface Меблі {
    void відкрити();

    void закрити();
}

abstract class Шафа implements Меблі {
    private boolean відкрита;

    public Шафа() {
        відкрита = false;
    }

    @Override
    public void відкрити() {
        відкрита = true;
        System.out.println("Шафу відкрито.");
    }

    @Override
    public void закрити() {
        відкрита = false;
        System.out.println("Шафу закрито.");
    }

    public boolean чиВідкрита() {
        return відкрита;
    }
}

class КнижковийШафа extends Шафа {
    private int кількістьКниг;

    public КнижковийШафа(int кількістьКниг) {
        this.кількістьКниг = кількістьКниг;
    }

    public int отриматиКількістьКниг() {
        return кількістьКниг;
    }

    public void додатиКниги(int кількістьДодатковихКниг) {
        кількістьКниг += кількістьДодатковихКниг;
        System.out.println("Додано " + кількістьДодатковихКниг + " книг.");
    }

    @Override
    public void відкрити() {
        if (!чиВідкрита()) {
            super.відкрити();
            System.out.println("В книжковій шафі " + кількістьКниг + " книг.");
        } else {
            System.out.println("Книжкова шафа вже відкрита.");
        }
    }

    @Override
    public void закрити() {
        if (чиВідкрита()) {
            super.закрити();
        } else {
            System.out.println("Книжкова шафа вже закрита.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        КнижковийШафа книжковаШафа = new КнижковийШафа(10);
        книжковаШафа.відкрити();
        книжковаШафа.додатиКниги(5);
        книжковаШафа.закрити();
    }
}
