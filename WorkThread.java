package Q4_2020B76;

public class WorkThread extends Thread {
    private int[] data;
    private int id;
    private int result;
    private Monitor monitor;

    public WorkThread(int[] data, int id, Monitor monitor) {
        this.data = data;
        this.id = id;
        this.monitor = monitor;
        this.monitor.addThread();
    }

    public int process(int[] data) {
        return id;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            monitor.allowProcess(i);
            ((BetterLocksMonitor) monitor).allowProcessID(id); // show the processes based on id
            result = process(data);
//            System.out.println(result);
            System.out.println("id=" + id + " iterNum=" + i);
            monitor.finishedProcess();
        }

    }


}
