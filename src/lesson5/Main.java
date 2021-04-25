package lesson5;

public class Main {
    static final int SIZE = 10;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        calculateInOneThread();
        calculateInTwoThreads();
    }

    private static void calculateInOneThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        fillArrayWithNewValues(arr, 0);
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void calculateInTwoThreads() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread t1 = new Thread(() -> fillArrayWithNewValues(a1, 0));
        Thread t2 = new Thread(() -> fillArrayWithNewValues(a2, HALF));
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void fillArrayWithNewValues(float[] arr, int shift) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (shift + i) / 5) * Math.cos(0.2f + (shift + i) / 5) * Math.cos(0.4f + (shift + i) / 2));
        }
    }
}
