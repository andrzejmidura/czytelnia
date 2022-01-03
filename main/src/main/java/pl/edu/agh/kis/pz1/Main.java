package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.*;

/**
 * Przykładowy kod do zajęć laboratoryjnych 2, 3, 4 z przedmiotu: Programowanie zaawansowane 1
 * @author Paweł Skrzyński
 */
public class  Main {
    public static void main( String[] args ) {
//        System.out.println( "Szablon projektu z metodą main i zależnościami wbudowanymi w wykonywalny jar" );
//        //wywołanie metody generującej hash SHA-512
//        System.out.println("HASH 512 dla słowa test: " + TextUtils.sha512Hash("test"));
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
