package pl.edu.agh.kis.pz1.util;

public class Reader extends Thread{

    public Reader() {}

    @Override
    public void run() {
        while(true) {
            try {
                this.res.readLock();
            } catch (InterruptedException ignored) {
            }

            System.out.println("        " + this.getName() + " reads...                 In room: " + (5-this.res.readersSemaphore.availablePermits()) + " readers, " + (1-this.res.writersSemaphore.availablePermits()) + " writers.");

            try {
                sleep(1000);
            } catch (InterruptedException ignored) {
            }
            try {
                this.res.readUnlock();
            } catch (InterruptedException ignored) {
            }

            try {
                sleep(10000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public Reader(int i, Resources res) {
        this.res = res;
        this.setName("Reader" + i);
    }

    protected Resources res;
}
