package com.bananamokka.Domain;

import com.bananamokka.Main;

public class Client implements Runnable {
    private final int clientNumber;

    public Client(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        System.out.printf("Клиент №%d позвонил в колл-центр.\n", clientNumber);
        try {

            Main.SEMAPHORE.acquire();

            int queueNumber = 0;

            synchronized (Main.FREE_OPERATORS) {
                for (int i = 1; i < 5; i++)
                    if (!Main.FREE_OPERATORS[i-1]) {
                        Main.FREE_OPERATORS[i-1] = true;
                        queueNumber = i-1;
                        System.out.printf("Клиент №%d разговаривает с оператором %d.\n", clientNumber, i);
                        break;
                    }
            }

            Thread.sleep(5000);

            synchronized (Main.FREE_OPERATORS) {
                Main.FREE_OPERATORS[queueNumber] = false;
            }

            Main.SEMAPHORE.release();
            System.out.printf("Клиент №%d закончил разговор с оператором.\n", clientNumber);
        } catch (InterruptedException ignored) {
        }
    }
}

