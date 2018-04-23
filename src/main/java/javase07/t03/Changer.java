package javase07.t03;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Changer extends Thread {
    private CollectionsResources resource;
    private boolean run;
    private static AtomicInteger count = new AtomicInteger(0);
    private Random rand = new Random();

    public Changer(String name, CollectionsResources resource) {
        super(name);
        count.incrementAndGet();
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while (run) {
                if (count.decrementAndGet() == 0) {
                    setIntegersIntoResource();
                } else {
                    action = rand.nextInt(1000);
                    if (action % 2 == 0) {
                        getIntegersFromResource();
                    } else {
                        setIntegersIntoResource();
                    }
                }
                count.incrementAndGet();
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName()
                    + " хочет извлечь число.");
            number = resource.getElement();
            while (number == null) {
                System.out.println("Поток " + getName()
                        + " ждет пока очередь заполнится.");
                resource.wait();
                System.out
                        .println("Поток " + getName() + " возобновил работу.");
                number = resource.getElement();
            }
            System.out
                    .println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число "
                    + number);
            resource.notify();
        }
    }

}