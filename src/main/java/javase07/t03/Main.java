package javase07.t03;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CollectionsResources res = new CollectionsResources();
        Changer t1 = new Changer("1", res);
        Changer t2 = new Changer("2", res);
        Changer t3 = new Changer("3", res);
        Changer t4 = new Changer("4", res);
        Changer t5 = new Changer("5", res);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.sleep(100);

        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();
        t5.stopThread();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("main");
    }

}