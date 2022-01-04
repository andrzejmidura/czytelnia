package pl.edu.agh.kis.pz1.util;

import java.util.concurrent.Semaphore;

public class Resources {

    /**
     * Get read lock
     */
    public void readLock() throws InterruptedException {
        readersSemaphore.acquire();
        if(readersInRoom == 0) {                // the first Reader acquires writersSemaphore to prevent writers to enter room
            writersSemaphore.acquire();
        }
        readersInRoom++;
        readersSemaphore.release();
    }

    /**
     * Release read lock
     */
    public void readUnlock() throws InterruptedException {
        readersSemaphore.acquire();
        readersInRoom--;
        if(readersInRoom == 0){                 // if no readers left in room
            writersSemaphore.release();
        }
        readersSemaphore.release();
    }

    /**
     * Get write lock
     */
    public void writeLock() throws InterruptedException {
        writersSemaphore.acquire();
    }

    /**
     * Release write lock
     */
    public void writeUnlock(){
        writersSemaphore.release();
    }

    private static int readersInRoom = 0;
    private static final int MAX_READERS = 5;
    private static final int MAX_WRITERS = 1;
    private final Semaphore readersSemaphore = new Semaphore(MAX_READERS, true);
    private final Semaphore writersSemaphore = new Semaphore(MAX_WRITERS, true);
}
