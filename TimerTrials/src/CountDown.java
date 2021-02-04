import java.io.IOException;
import java.util.Scanner;

public class CountDown {

    public static void main(String[] args) throws IOException {

        CountDownTask task = new CountDownTask(10);
        Thread thread = new Thread(task);
        thread.start();

        Scanner input = new Scanner(System.in);

        if (input.next().equalsIgnoreCase("p")) {
            try{
            thread.interrupt();
            System.out.println(task.secs+" seconds before completion");
            System.out.println("press any key to resume it");
            input.next();
                try {
                    while (task.secs > 0) {
                        System.out.println(task.secs);
                        Thread.sleep(1000);
                        task.secs--;
                    }
                } catch (Exception e) {
                    System.out.println("Wash process interrupted");
                }

//            System.in.read();
//            task = new CountDownTask(remainingsecs);
//            thread = new Thread(task);
//            thread.start();
//            thread.notify();
        } catch(Exception ex){
            //System.out.println("Wash process interrupted");
        }
    }

    }

    static class CountDownTask implements Runnable {
        int secs = 10;

        public CountDownTask(int x) {
            secs = x;
        }

        @Override
        public void run() {
            try {
                while (secs > 0) {
                    System.out.println(secs);
                    Thread.sleep(1000);
                    secs--;
                }
            } catch (Exception e) {
                System.out.println("Wash process interrupted");
            }
        }

    }
}
