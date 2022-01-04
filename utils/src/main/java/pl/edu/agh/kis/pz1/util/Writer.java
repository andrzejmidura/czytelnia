package pl.edu.agh.kis.pz1.util;

public class Writer extends Reader{

    @Override
    public void run() {
        while (true) {
            try {
                this.res.writeLock();
            } catch (InterruptedException ignored) {}
            System.out.println("        " + this.getName() + " writes and reads...      In room: " + (5-this.res.readersSemaphore.availablePermits()) + " readers, " + (1-this.res.writersSemaphore.availablePermits()) + " writers.");

            try {
                sleep(1000);
            } catch (InterruptedException ignored) {}

            this.res.writeUnlock();

            try {
                sleep(10000);
            } catch (InterruptedException ignored) {}
        }
    }

    public Writer() {}

    public Writer(int i, Resources res) {
        super();
        this.dataToWrite = "Data written by Writer" + i + ".";
        super.setName("Writer" + i);
        super.res = res;
    }

    private String dataToWrite;
}
