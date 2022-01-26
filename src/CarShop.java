import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CarShop {
    private final int CAR_SELLING_TIME = 1000;
    private final int CAR_MANUFACTORING_TIME = 1000;
    private final Car NEW_CAR = new Car("Toyota");
    public int soldCars = 0;
    public CarStore carStore;
    public ReentrantLock lock;

    public CarShop(CarStore carStore, ReentrantLock lock) {
        this.carStore = carStore;
        this.lock = lock;
    }

    public void receiveCar(Condition storeEmptyCondition) {
        lock.lock();
        try {
            System.out.println("Продавец ожидает поставку");
            Thread.sleep(CAR_MANUFACTORING_TIME);
            System.out.println("Производитель Toyota выпустил 1 авто");
            carStore.store.add(NEW_CAR);
            storeEmptyCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Car sellCar(Condition storeEmptyCondition) throws InterruptedException {
        lock.lock();
        try {
            while (carStore.store.size() == 0 && lock.tryLock()) {
                Thread.sleep(CAR_SELLING_TIME);
                System.out.println("Продавец: Машин нет в наличии в вашей комплектации");
                receiveCar(storeEmptyCondition);
                storeEmptyCondition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        Thread.sleep(CAR_SELLING_TIME);
        System.out.println("Продавец: На складе появился автомобиль");
        Car newCar = carStore.store.get(0);
        carStore.store.remove(0);
        soldCars++;
        return newCar;
    }
}