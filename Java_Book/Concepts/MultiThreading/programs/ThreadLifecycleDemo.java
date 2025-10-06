


public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();

        // Thread is created but not started yet → NEW
        System.out.println("State after creation: " + t.getState()); // NEW

        t.start(); // now thread is RUNNABLE (scheduler decides when it runs)

        Thread.sleep(100); // allow thread to finish
        System.out.println("State after completion: " + t.getState()); // TERMINATED
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}
