package pl.edu.agh.kis.pz1.util;

public class Writer extends Reader{

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(this.getName() + " wants to write and read.");
                this.res.writeLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("        " + this.getName() + " writes and reads...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " leaves.");
            this.res.writeUnlock();

            try {
                sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Writer(int i, Resources res) {
        super();
        this.dataToWrite = "Data written by Writer" + i + ".";
        super.setName("Writer" + i);
        super.res = res;
    }

    private String dataToWrite;
}
