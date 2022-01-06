package pl.edu.agh.kis.pz1.util;

public class Writer extends Thread{

    @Override
    public void run() {
        while (true) {
            try {
                this.res.writeLock();

                System.out.println("        " + this.getName() + " writes and reads...      In room: " + (5-this.res.readersSemaphore.availablePermits()) + " readers, " + (1-this.res.writersSemaphore.availablePermits()) + " writers.");

                sleep(1000);

                this.res.writeUnlock();

                sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public Writer(int i, Resources res) {
        this.setName("Writer" + i);
        this.res = res;
    }

    protected Resources res;
}
