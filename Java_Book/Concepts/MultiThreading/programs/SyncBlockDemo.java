public class SyncBlockDemo {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        Thread t1 = new Thread(() -> obj.method(), "Thread-1");
        Thread t2 = new Thread(() -> obj.method(), "Thread-2");

        t1.start();
        t2.start();
    }
}

class SharedResource {
    void method() {
        System.out.println(Thread.currentThread().getName() + " before sync block");

        synchronized(this) {
             System.out.println(Thread.currentThread().getName() + " inside synchronized block");
            try { Thread.sleep(200000); } catch (InterruptedException e) {}
        }

        System.out.println(Thread.currentThread().getName() + " after sync block");
    }
}


