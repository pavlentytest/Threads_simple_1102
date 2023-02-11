public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
        Процесса -
        Поток -
         */
       /* MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();

        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();

        new Thread(() -> {
            // логика потока
        }).start();
        */


        // [+][-][+][-]......


        MyThread thread1 = new MyThread("+");
        MyThread thread2 = new MyThread("-");
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread2.flag = false;
        thread2.join(); // ждет завершение потока
        test("1st thread is stopped!");
    }
    public static final Object KEY = new Object();
    public static void test(String message) {
       // synchronized (KEY) {
            try {
                System.out.print("[");
                Thread.sleep(500);
                System.out.print(message);
                Thread.sleep(500);
                System.out.print("]");
             //   KEY.notify(); // возобновл. работу потока из режима ожид.
             //   KEY.wait(); // поток в режим. ожидания
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
       // }

    }

}
class MyThread extends Thread {
    private String mess;
    public boolean flag = true;
    MyThread(String m) {
        this.mess = m;
    }

    @Override
    public void run() {
       while(true) {
           Main.test(this.mess);
       }
    }
}

