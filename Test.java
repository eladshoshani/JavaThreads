package Q4_2020B76;

public class Test {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4};
        Monitor monitor = new BetterLocksMonitor();
        for (int i = 0; i < 3; i++)
            (new WorkThread(data, i + 1, monitor)).start();
        System.out.println("**main**");

    }
}

