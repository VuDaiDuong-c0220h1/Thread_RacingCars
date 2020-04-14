import java.util.Random;

public class Car implements Runnable {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();

        while (runDistance < Constant.DISTANCE) {
            try {
                //Speed bất kỳ trong khoảng số nguyên từ 0 đến 19
                int speed = (new Random()).nextInt(20);
                runDistance += speed;
                //Hiển thị hình ảnh
                String log = "|";
                for (int i = 0; i < Constant.DISTANCE; i += Constant.MOVESTEP) {
                    if (runDistance >= i + Constant.MOVESTEP) {
                        log += "=";
                    } else if (runDistance >= i && runDistance < i + Constant.MOVESTEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car " + this.name + ": " + log + " "
                        + Math.min(Constant.DISTANCE, runDistance) + "Km");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car " + this.name + " broken..");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car " + this.name + " finish in " + (endTime - startTime) / 1000 + "s");
    }
}
