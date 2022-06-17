package com.bananamokka;

import com.bananamokka.Domain.Calls;

import java.util.concurrent.Semaphore;

public class Main {
    public static final boolean[] FREE_OPERATORS = new boolean[4];

    public static final Semaphore SEMAPHORE = new Semaphore(4, true);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Колл-центр начал работу");

        Calls.Calls(20);

        System.out.println("Колл-центр закончил работу");

    }
}
