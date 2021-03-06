import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Callable and Future
class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {

                Random random = new Random();
                int duration = random.nextInt(4000);
                if (duration > 2000)
                    throw new IOException("Sleeping for a long time: " + duration);
                System.out.println("Starting ...");
                try {
                    Thread.sleep(duration);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Finished.");

                return duration;
            }

        });

        executor.shutdown();

        try {
            System.out.println("Result is " + future.get());
        } catch (ExecutionException e) {

            IOException io = (IOException) e.getCause();
            System.out.println(io.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}