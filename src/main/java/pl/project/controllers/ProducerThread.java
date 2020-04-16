package pl.project.controllers;

import java.time.Duration;
import java.util.Queue;
import java.util.Random;

public class ProducerThread extends Thread {
    private Queue<String> queue;
    private static final Random generator = new Random();
    private int bufferCapacity;

    public ProducerThread(Queue<String> queue, int bufferCapacity){
        this.queue = queue;
        this.bufferCapacity = bufferCapacity;
    }

    @Override
    public void run(){
//        for (int i = 0; i < bufferCapacity ; i++) {
//            try {
//                Thread.sleep(Duration.ofSeconds(generator.nextInt(5)).toMillis());
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            queue.add("itemeke : - D");
//        }
        int i = 0;
        synchronized (queue) {
            System.out.println("Produkuję item " + i);
            queue.add("Item no. " + i);
            queue.notify();
        }
    }
}
