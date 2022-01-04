package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.*;

public class  Main {
    public static void main( String[] args ) {
        Resources res = new Resources();

        // calling writers
        for (int i=0; i<3; i++) {
            Writer w = new Writer(i, res);
            w.start();
        }

        // calling readers
        for (int j=0; j<10; j++) {
            Reader r = new Reader(j, res);
            r.start();
        }
    }
}
