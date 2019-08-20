
public class App {
    // private volatile int count = 0; //20000 OK!
    private int count = 0;

    // with synchronized you got multiple threads accessing shared data
    // and by the way you don't need to declare is volatile
    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        App app = new App();
        app.doWork();

    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count = " + count);

    }
}