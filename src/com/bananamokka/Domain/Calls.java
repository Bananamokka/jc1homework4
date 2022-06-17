package com.bananamokka.Domain;

public class Calls {
    public static void Calls(int clients) throws InterruptedException {
        for (int i = 1; i <= clients; i++) {
            new Thread(new Client(i)).start();
            Thread.sleep(1000);
        }
    }
}
