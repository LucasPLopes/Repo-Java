import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker{
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();
    
    public void stageOne(){
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();   
        }
        list1.add(random.nextInt(100));
    }
    public void stageTwo(){
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();   
        }
        list2.add(random.nextInt(100));

    }
    public void process(){
        int max = 1000;
        for (int i = 0; i < max; i++) {
            stageOne();
            stageTwo();
        }
    }
    public void main(){
        System.out.println("Starting...");
        
        long start = System.currentTimeMillis();
        
       Thread t1 =  new Thread( new Runnable(){
        
            @Override
            public void run() {
                    process();     
            }
        });
        Thread t2 =  new Thread( new Runnable(){
        
            @Override
            public void run() {
                    process();     
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        long end  = System.currentTimeMillis();

        System.out.println("Time take: "+(end - start));
        System.out.println("List1.size(): "+ list1.size());
        System.out.println("List2.size(): "+ list2.size());

    }
}