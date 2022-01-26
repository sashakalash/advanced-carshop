import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static CarShop carShop;
    public static CarStore carStore;
    public static ReentrantLock lock;


    public static void main(String[] args) {
        lock = new ReentrantLock();
        carStore = new CarStore();
        carShop = new CarShop(carStore, lock);

        Thread customer1 = new Thread(new Customer(carShop, lock));
        customer1.setName("Покупатель 1");
        Thread customer2 = new Thread(new Customer(carShop, lock));
        customer2.setName("Покупатель 2");
        Thread customer3 = new Thread(new Customer(carShop, lock));
        customer3.setName("Покупатель 3");

        customer1.start();
        customer2.start();
        customer3.start();

        while (carShop.soldCars != 2) {
            continue;

        }
        customer1.interrupt();
        customer2.interrupt();
        customer3.interrupt();
    }
}