package Q4_2020B76;

// parent Monitor
public abstract class Monitor {
    protected int count;
    protected int numIter;
    protected int numOfThreads;

    public Monitor() {
        numOfThreads = 0;
        numIter = 0;
        count = 0;
    }

    public void addThread() {
        numOfThreads++;
    }

    public abstract void allowProcess(int numIter);

    public abstract void finishedProcess();

}
