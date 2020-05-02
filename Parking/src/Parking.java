import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {
    private static final boolean[] PLACES = new boolean[10];
    private static final Semaphore SEMAPHORE = new Semaphore(10, true);


    public static boolean[] getPLACES() {
        return PLACES;
    }

    public static Semaphore getSEMAPHORE() {
        return SEMAPHORE;
    }

    public static void main(String[] args) {
        int counter = 0;
        while (counter++ < 20){
            new Thread(new Car(counter)).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}