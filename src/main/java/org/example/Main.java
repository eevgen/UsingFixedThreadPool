package org.example;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService exs = Executors.newFixedThreadPool(5);

        exs.submit(new MyThread());
        exs.submit(new MyThread());
        exs.submit(new MyThread());
        exs.submit(new MyThread());
        exs.submit(new MyThread());

        exs.shutdown();
    }

    static class MyThread implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("Name: " + Thread.currentThread().getName());
                Thread.sleep((new Random().nextInt(1, 5)) * 1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}