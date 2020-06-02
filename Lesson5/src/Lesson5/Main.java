package Lesson5;

public class Main {
    static final int size = 10_000_000;
    static final int h = size / 2;

    public static void main(String[] args) {
        straight();
        split();
    }

    private static float[] generate() {
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        return arr;
    }

    private static void calc(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void straight() {
        float[] arr = generate();

        long a = System.currentTimeMillis();
        calc(arr);
        System.out.println(System.currentTimeMillis() - a);
    }
    
    private static void split() {
        float[] arr = generate();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                calc(a1);
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                calc(a2);
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }
}
