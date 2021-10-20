package adbistju.system.task1;


public class Main {
    public static void main(String[] args) {
        new Thread(new PingPong.WaitNotifyClass("Ping","Pong")).start();
        new Thread(new PingPong.WaitNotifyClass("Pong","Ping")).start();

    }
}