package practic.self;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<Double> sharedQueue;

    public Consumer(Queue<Double> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private Double consume() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.isEmpty()) sharedQueue.wait();

            sharedQueue.notifyAll();

            return sharedQueue.poll();
        }
    }

}
