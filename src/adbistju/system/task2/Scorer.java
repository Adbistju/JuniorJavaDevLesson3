package adbistju.system.task2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Scorer implements Runnable {
    private static int itter = 0;
//    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public synchronized void run(){
        for (int i = 0; i < 1; i++) {
            start();
            System.out.println("\u001B[31m"+itter+"\u001B[0m");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread Id"+Thread.currentThread().getId());
    }


    public /*synchronized*/ int getItter(){
        return itter;
    }

    public synchronized void start(){
//        lock.readLock().lock();
        itter++;
//        lock.readLock().unlock();
    }
}
