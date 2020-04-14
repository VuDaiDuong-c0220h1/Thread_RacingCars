public class Main {
    public static void main(String[] args) {

        Car carA = new Car("Red");
        Car carB = new Car("Blue");
        Car carC = new Car("Green");

        Thread threadA = new Thread(carA);
        Thread threadB = new Thread(carB);
        Thread threadC = new Thread(carC);

        System.out.println("Distance: 100Km");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
