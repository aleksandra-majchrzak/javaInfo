import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.*;

/**
 * Created by Mohru on 03.01.2017.
 */
public class MainClass3 {

    public static void main(String[] args) {

        File f = new File("fileName");

        try (FileWriter w = new FileWriter(f)) {

            //throw new IOException();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Locale.setDefault(new Locale("en", "US"));
        //Locale.setDefault(new Locale("de", "DE"));
        ResourceBundle b = ResourceBundle.getBundle("Strings");
        System.out.println(b.getString("username"));


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello");
            }
        }).start();


        Callable<Integer> c = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return 1;
            }
        };


        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future = service.submit(c);

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
