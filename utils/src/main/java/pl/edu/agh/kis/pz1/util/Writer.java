package pl.edu.agh.kis.pz1.util;

public class Writer extends Reader{

    @Override
    public void run() {
        while (true) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.res.enter(this);
            this.res.overwriteData(this, this.dataToWrite);
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
