package pl.edu.agh.kis.pz1.util;

import java.util.concurrent.Semaphore;

public class Resources {

    /**
     * Get read lock
     */
    public void readLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " wants to enter the room.");

        if(!theFirstReaderAppeared) {                // the first Reader acquires auxiliarySemaphore to prevent writers to enter room
            theFirstReaderAppeared = true;
            auxiliarySemaphore.acquire();
            readersInRoom++;
            readersSemaphore.acquire();
        } else {
            while(readersInRoom==0) {
                Thread.sleep(1000);
            }
            readersSemaphore.acquire();
            readersInRoom++;
        }

    }


    /**
     * Release read lock
     */
    public void readUnlock() throws InterruptedException {
        readersInRoom--;
        if(readersInRoom == 0){                 // if no readers left in room
            readersSemaphore.release();
            System.out.println(Thread.currentThread().getName() + " left.");
            theFirstReaderAppeared = false;
            auxiliarySemaphore.release();
        } else {
            readersSemaphore.release();
            System.out.println(Thread.currentThread().getName() + " left.");
        }
    }

    /**
     * Get write lock
     */
    public void writeLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " wants to enter the room.");
        auxiliarySemaphore.acquire();
        writersSemaphore.acquire();
        writersInRoom++;
    }

    /**
     * Release write lock
     */
    public void writeUnlock(){
        writersSemaphore.release();
        System.out.println(Thread.currentThread().getName() + " left.");
        writersInRoom--;
        auxiliarySemaphore.release();
    }

    public int readersInRoom = 0;
    public int writersInRoom = 0;
    public volatile boolean theFirstReaderAppeared = false;
    private static final int MAX_READERS = 5;
    private static final int MAX_WRITERS = 1;
    public final Semaphore readersSemaphore = new Semaphore(MAX_READERS, true);
    public final Semaphore writersSemaphore = new Semaphore(MAX_WRITERS, true);
    public final Semaphore auxiliarySemaphore = new Semaphore(1, true);
}
