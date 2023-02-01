
public class Main {

    private static Object water = new Object();
    private static Object food = new Object();

    public static void main(String[] args) {
        Dog1 dog1 = new Dog1();
        Dog2 dog2 = new Dog2();
        dog1.start();
        dog2.start();
    }

    private static class Dog1 extends Thread {
        @Override
        public void run() {
            synchronized (water) {
                System.out.println("The first dog went to the water ...");
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.out.println("The first dog waits until the food is free ...");
                synchronized (food) {
                    System.out.println("The first dog ate and drank");
                }
            }
        }
    }

    private static class Dog2 extends Thread {
        @Override
        public void run() {
            synchronized (food) {
                System.out.println("The second dog went to the food ...");
                try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.out.println("The second dog waits until the water is free ...");
                synchronized (water) {
                    System.out.println("The second dog ate and drank");
                }

            }
        }
    }
}
