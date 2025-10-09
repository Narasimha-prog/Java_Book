public class NotifyAllExample{

public static void main(String[] a){



final Object lock = new Object();

Thread tA = new Thread(() -> {
    synchronized (lock) {
        try {
            System.out.println("Thread-A waiting...");
            lock.wait();
            System.out.println("Thread-A resumed!");
        } catch (InterruptedException e) {}
    }
});

Thread tB = new Thread(() -> {
    synchronized (lock) {
        try {
            System.out.println("Thread-B waiting...");
            lock.wait();
            System.out.println("Thread-B resumed!");
        } catch (InterruptedException e) {}
    }
});

Thread tC = new Thread(() -> {
    try {
        Thread.sleep(1000); // let others wait
    } catch (InterruptedException e) {}
    synchronized (lock) {
        // Try notify() or notifyAll()
        System.out.println("Thread-C notifying...");
        // lock.notify();     // Only one thread wakes up
        lock.notifyAll();     // All waiting threads wake up
    }
});

tA.start();
tB.start();
tC.start();
}


}
