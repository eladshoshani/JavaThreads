package Q4_2020B76;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksMonitor extends Monitor{
    protected Lock lock;
    protected Condition condition;

    public LocksMonitor() {
        // אתחול המנעולים
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void allowProcess(int numIter) {
        lock.lock(); // start the 'synchronized'

        try {
            while (this.numIter != numIter) {
                condition.await(); // wait for a condition
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock(); // stop the 'synchronized'
        }
    }

    public void finishedProcess() {
        lock.lock();
        count++; // process finished

        if (count == numOfThreads) { // all threads finished
            count = 0;
            numIter++;
            condition.signalAll();
        }

        lock.unlock();
    }


}
