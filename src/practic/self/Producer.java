package practic.self;

import java.util.Queue;

public class Producer implements Runnable {
    private final Queue<Double> sharedQueue;

    private final int SIZE;

    public Producer(Queue<Double> sharedQueue, int SIZE) {
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Produced: " + produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private double produce() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.size() == SIZE) sharedQueue.wait();

            double newValue = Math.random();
            sharedQueue.add(newValue);

            sharedQueue.notifyAll();

            return newValue;
        }
    }
}
