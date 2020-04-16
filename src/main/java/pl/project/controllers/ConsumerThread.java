package pl.project.controllers;

import java.time.Duration;
import java.util.Queue;
import java.util.Random;

public class ConsumerThread extends Thread{
    private Queue<String> queue;
    private int bufferCapacity;
    private boolean translationInProgress = false;

    public ConsumerThread(Queue<String> queue, int bufferCapacity){
        this.queue = queue;
        this.bufferCapacity = bufferCapacity;
    }

    public void run(){
        while (true) {
            String item;
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Czekam");
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                item = queue.poll();
            }
            System.out.println("Consumer got item: " + item);
        }
    }
}
