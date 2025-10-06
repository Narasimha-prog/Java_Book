public class TwoSyncMethodsDemo {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        Thread t1 = new Thread(() -> {obj.method1(); obj.method2();}, "Thread-1");
        Thread t2 = new Thread(() -> obj.method2(), "Thread-2");
        Thread t3 = new Thread(() -> obj.method3(), "Thread-3");
        Thread t4 = new Thread(()-> obj.method4(),"Thread-4");
   System.out.println("Thread-1: "+t1.getState()+" Thread-2: "+t2.getState()+" Thread-3: "+t3.getState()+" Thread-4: "+t4.getState() );
        t1.start();try{
       Thread.sleep(1000);}catch(Exception e){e.printStackTrace();}
        t2.start();
      try{
      Thread.sleep(1000);} catch(Exception e){e.printStackTrace();}
        t3.start();
        t4.start();
 System.out.println("Thread-1: "+t1.getState()+" Thread-2: "+t2.getState()+" Thread-3: "+t3.getState()+" Thread-4: "+t4.getState() );
   
    try{
     t1.join();
     t2.join();
     t3.join();
     t4.join();
  }catch(Exception e){}
System.out.println("Thread-1: "+t1.getState()+" Thread-2: "+t2.getState()+" Thread-3: "+t3.getState()+" Thread-4: "+t4.getState() );
    }
}

class SharedResource {
    
    synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " entered method1 "+Thread.currentThread().getState());
        try {
            Thread.sleep(20000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " leaving method1 "+Thread.currentThread().getState());
    }

    synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " entered method2  "+Thread.currentThread().getState());
        try {
            Thread.sleep(20000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " leaving method2  "+Thread.currentThread().getState());
    }
   void method3(){
      System.out.println(Thread.currentThread().getName()+" Entering syncronized block method3  "+Thread.currentThread().getState());
   synchronized(this){
try{
    Thread.sleep(2000);
}catch(InterruptedException e){e.printStackTrace();}    System.out.println(Thread.currentThread().getName()+" Inside the block..."+Thread.currentThread().getState());
}

}
   void method4(){
   System.out.println(Thread.currentThread().getName()+" Non Syncronized method4  "+Thread.currentThread().getState());
}
}
