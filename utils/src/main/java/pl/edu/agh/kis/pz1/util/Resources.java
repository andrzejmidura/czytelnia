package pl.edu.agh.kis.pz1.util;

import java.util.concurrent.Semaphore;


/**
 * Resources class represents resources that Reader and Writer objects operates on
 * */
public class Resources {

    /**
     * Locks the Resources for Readers
     * or waits until no Writers left in the room
     */
    public void readLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " wants to enter the room.");

        if(!theFirstReaderAppeared) {                // the first Reader acquires auxiliarySemaphore to prevent Writers from entering the room
            theFirstReaderAppeared = true;
            auxiliarySemaphore.acquire();
            readersInRoom++;
            readersSemaphore.acquire();
        } else {
            while(readersInRoom==0) {
                Thread.yield();
            }
            readersSemaphore.acquire();
            readersInRoom++;
        }

    }


    /**
     * Release read lock
     */
    public void readUnlock() {
        readersInRoom--;
        if(readersInRoom == 0){                 // if no readers left in room
            readersSemaphore.release();
            System.out.println(Thread.currentThread().getName() + LEFT_MESSAGE);
            theFirstReaderAppeared = false;
            auxiliarySemaphore.release();
        } else {
            readersSemaphore.release();
            System.out.println(Thread.currentThread().getName() + LEFT_MESSAGE);
        }
    }

    /**
     * Get write lock
     */
    public void writeLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " wants to enter the room.");
        auxiliarySemaphore.acquire();           // Writer acquires auxiliarySemaphore to prevent Readers from entering the room
        writersSemaphore.acquire();
    }

    /**
     * Locks the Resources for Writers
     * or waits until no Readers left in the room
     */
    public void writeUnlock(){
        writersSemaphore.release();
        System.out.println(Thread.currentThread().getName() + LEFT_MESSAGE);
        auxiliarySemaphore.release();
    }

    private int readersInRoom = 0;
    private volatile boolean theFirstReaderAppeared = false;
    private static final int MAX_READERS = 5;
    private static final int MAX_WRITERS = 1;
    public final Semaphore readersSemaphore = new Semaphore(MAX_READERS, true);
    public final Semaphore writersSemaphore = new Semaphore(MAX_WRITERS, true);
    public final Semaphore auxiliarySemaphore = new Semaphore(1, true);
    private static final String LEFT_MESSAGE = " left.";
}
