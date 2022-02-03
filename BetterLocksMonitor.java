package Q4_2020B76;

import java.util.concurrent.locks.Condition;

public class BetterLocksMonitor extends LocksMonitor {
    private Condition idCondition;
    private int highestID;

    public BetterLocksMonitor() {
        super();
        idCondition = lock.newCondition();
        highestID = 1;
    }

    public void allowProcessID(int id) {
        lock.lock();
        try {
            while (highestID != id) {
                idCondition.await();
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public void finishedProcess() {
        lock.lock();
        count++; // process finished
        highestID++;

        if (count == numOfThreads) { // all threads finished
            count = 0;
            numIter++;
            condition.signalAll();
        }

        if (highestID == numOfThreads + 1) {
            highestID = 1;
        }

        idCondition.signalAll();

        lock.unlock();
    }


}
