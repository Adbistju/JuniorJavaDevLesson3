package adbistju.system.task1;

public class PingPong {
    static String c = "Ping";
    static Object mon = new Object();
    static String[] color = {"\u001B[30m", "\u001B[33m", "\u001B[36m","\u001B[35m","\u001B[32m","\u001B[31m","\u001B[34m", "\u001B[0m"};

    static class WaitNotifyClass implements Runnable {
        private String currentLetter;
        private String nextLetter;

        public WaitNotifyClass(String currentLetter, String nextLetter) {
            this.currentLetter = currentLetter;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            while (true){
                synchronized (mon) {
                    try {
                        while (c != currentLetter){
                            mon.wait();
                        }

                        System.out.print(color[getThreadColor()]+" | "+currentLetter+"\u001B[0m");
                        c = nextLetter;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //нагрузка
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private int getThreadColor(){
            int col = 0;
            col = (int) ((int) Thread.currentThread().getId()-color.length*(Thread.currentThread().getId()/color.length));
            return col;
        }
    }
}