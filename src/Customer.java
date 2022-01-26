import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Customer implements Runnable {
    private final int CAR_WAITING_TIME = 1000;
    public CarShop shop;
    private Car buyedCar;
    public Condition storeEmptyCondition;
    public ReentrantLock lock;

    public Customer(CarShop shop, ReentrantLock lock) {
        this.shop = shop;
        this.lock = lock;
        this.storeEmptyCondition = lock.newCondition();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(CAR_WAITING_TIME);
            System.out.printf("%s зашел в автосалон\n", getName());
            buyedCar = shop.sellCar(storeEmptyCondition);
            System.out.printf("%s уехал на новеньком авто\n", getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getName() {
        return Thread.currentThread().getName();
    }
}