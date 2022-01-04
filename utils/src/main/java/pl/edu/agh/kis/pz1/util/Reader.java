package pl.edu.agh.kis.pz1.util;

public class Reader extends Thread{

    public Reader() {}

    @Override
    public void run() {
        while(true) {
            try {
//                System.out.println(this.getName() + " wants to read.");
                this.res.readLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("        " + this.getName() + " reads...      In room: " + (5-this.res.readersSemaphore.availablePermits()) + " readers, " + (1-this.res.writersSemaphore.availablePermits()) + " writers.");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
//                System.out.println(this.getName() + " leaves.");
                this.res.readUnlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Reader(int i, Resources res) {
        this.res = res;
        this.setName("Reader" + i);
    }

    protected Resources res;
}
