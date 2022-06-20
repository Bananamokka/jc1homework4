package com.bananamokka;

import com.bananamokka.Domain.CallCenter;
import com.bananamokka.Domain.Calls;

import java.util.concurrent.Semaphore;

public class Main {
    public static final boolean[] FREE_OPERATORS = new boolean[4];

    public static final Semaphore SEMAPHORE = new Semaphore(4, true);

    public static void main(String[] args) throws InterruptedException {

        CallCenter callCenterThread = new CallCenter();
        callCenterThread.start();

        Calls.Calls(20);

    }
}
