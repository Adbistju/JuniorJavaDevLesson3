package adbistju.system.task2;

import java.util.Scanner;

public class Main {

    public static Scorer scorer = new Scorer();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true){
                    scanner.nextLine();
                    System.out.println("\u001B[34m"+ scorer.getItter()+"\u001B[0m");
            }
        });
        thread.start();
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        executorService.submit(obj);
//        executorService.shutdown();
////        while (true){
//        for (int i = 0; i < 2; i++) {
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                new Thread(scorer).start();
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
    }
}
