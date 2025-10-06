public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread is going to WAITING state...");
                    lock.wait();  // moves to WAITING state
                    System.out.println("Thread is resumed...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        Thread.sleep(500);
        System.out.println("State of t1: " + t1.getState()); // WAITING

        synchronized (lock) {
            lock.notify(); // wakes t1, moves it back to RUNNABLE
        }
    }
}
