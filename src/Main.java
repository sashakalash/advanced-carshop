public class Main {
    public static CarShop carShop;
    public static CarStore carStore;

    public static void main(String[] args) {
        carStore = new CarStore();
        carShop = new CarShop(carStore);

        Thread customer1 = new Thread(null, new Customer(carShop, "Покупатель 1"));
        Thread customer2 = new Thread(null, new Customer(carShop, "Покупатель 2"));
        Thread customer3 = new Thread(null, new Customer(carShop, "Покупатель 3"));
        customer1.start();
        customer2.start();
        customer3.start();
        while (carShop.soldCars != 2) {
            Thread.onSpinWait();
        }

        customer1.interrupt();
        customer2.interrupt();
        customer3.interrupt();
    }
}