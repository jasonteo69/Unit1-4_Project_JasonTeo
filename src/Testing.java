import java.util.concurrent.TimeUnit;
public class Testing {
    public static void main(String[] args) {
        try {
            for (int i = 1; i < 4; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i + " seconds");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
