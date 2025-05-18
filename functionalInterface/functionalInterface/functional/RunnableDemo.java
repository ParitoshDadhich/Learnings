package functionalInterface.functional;

class ThreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("Run method called - Traditional way");
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadDemo());
        thread1.start();

        Runnable runnable = () -> System.out.println("Run method called - using lambda expression");
        Thread thread2 = new Thread(runnable);
        thread2.start();

    }
}
