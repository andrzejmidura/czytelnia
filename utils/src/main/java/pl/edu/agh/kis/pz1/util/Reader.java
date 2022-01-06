package pl.edu.agh.kis.pz1.util;

public class Reader extends Thread{

    @Override
    public void run() {
        while(true) {
            try {
                this.res.readLock();

                System.out.println("        " + this.getName() + " reads...                 In room: " + (5-this.res.readersSemaphore.availablePermits()) + " readers, " + (1-this.res.writersSemaphore.availablePermits()) + " writers.");

                sleep(1000);

                this.res.readUnlock();

                sleep(100);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public Reader(int i, Resources res) {
        this.res = res;
        this.setName("Reader" + i);
    }

    protected Resources res;
}
