package pl.project;

import pl.project.controllers.ConsumerThread;
import pl.project.controllers.ProducerThread;

import java.util.Queue;

public class TranslatorCore {
    private int itemCount = 5;
    private ProducerThread producerThread;
    private ConsumerThread consumerThread;

    public TranslatorCore(Queue<String> queue) {
        this.producerThread = new ProducerThread(queue, itemCount);
        this.consumerThread = new ConsumerThread(queue, itemCount);
    }

    public void start(){
        producerThread.start();
        consumerThread.start();
    }
}
