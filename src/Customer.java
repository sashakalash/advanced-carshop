class Customer implements Runnable {
    private final int CAR_WAITING_TIME = 1000;
    public CarShop shop;
    private Car buyedCar;

    public Customer(CarShop shop, String name) {
        this.shop = shop;
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(CAR_WAITING_TIME);
            System.out.printf("%s зашел в автосалон\n", getName());
            shop.sellCar();
            System.out.printf("%s уехал на новеньком авто\n", getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getName() {
        return Thread.currentThread().getName();
    }

    private void setName(String name) {
        Thread.currentThread().setName(name);
    }
}