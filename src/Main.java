public class Main {
    public static CarShop carShop;
    public static CarStore carStore;

    public static void main(String[] args) {
        carStore = new CarStore();
        carShop = new CarShop(carStore);

//        Thread customer1 = new Thread(null, new Customer(carShop, "Покупатель 1"));
//        Thread customer2 = new Thread(null, new Customer(carShop, "Покупатель 2"));
//        Thread customer3 = new Thread(null, new Customer(carShop, "Покупатель 3"));
//        customer1.start();
//        customer2.start();
//        customer3.start();
<<<<<<< HEAD
        new Thread(null, carShop::sellCar, "Покупатель 1").start();

        new Thread(null, carShop::sellCar, "Покупатель 2").start();

        new Thread(null, carShop::sellCar, "Покупатель 3").start();

        new Thread(null, carShop::receiveCar, "Производитель Toyota").start();

//        while (carShop.soldCars != 2) {
//        Thread.onSpinWait();
=======
        new Thread(null, carShop::sellCar,  "Покупатель 1").start();

        new Thread(null, carShop::sellCar,  "Покупатель 2").start();

        new Thread(null, carShop::sellCar,  "Покупатель 3").start();

        new Thread(null, carShop::receiveCar,  "Производитель Toyota").start();

//        while (carShop.soldCars != 2) {
//            continue;
>>>>>>> 0b9e40c07edf6bf36a5941ffc75315dc2d7618c9
//        }
//        customer1.interrupt();
//        customer2.interrupt();
//        customer3.interrupt();
    }
}