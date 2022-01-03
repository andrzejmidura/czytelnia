package pl.edu.agh.kis.pz1.util;

public class Reader extends Thread{

    public Reader() {}

    @Override
    public void run() {
        while(true) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.res.enter(this);
            res.readData(this);
        }
    }

    public Reader(int i, Resources res) {
        this.res = res;
        this.setName("Reader" + i);
    }

    protected Resources res;
}
