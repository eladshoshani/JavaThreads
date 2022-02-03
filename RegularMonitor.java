package Q4_2020B76;

public class RegularMonitor extends Monitor{

    public synchronized void allowProcess(int numIter) {
        while (this.numIter != numIter) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void finishedProcess() {
        count++; // process finished
        if (count == numOfThreads) { // all threads finished
            count = 0;
            numIter++;
            notifyAll();
        }
    }

}
