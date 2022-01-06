package pl.edu.agh.kis.pz1;

import org.junit.Test;
import pl.edu.agh.kis.pz1.util.Reader;
import pl.edu.agh.kis.pz1.util.Resources;

import static junit.framework.TestCase.assertNotNull;

public class ReaderTest {

    /**
     * Test for the construction of Reader
     *
     */
    @Test
    public void shouldCreateReaderObject(){
        Resources res = new Resources();
        Reader reader = new Reader(1, res);
        assertNotNull("Reader object created.", reader);
    }
}
