package pl.edu.agh.kis.pz1;

import org.junit.Test;
import pl.edu.agh.kis.pz1.util.Reader;

import static junit.framework.TestCase.assertNotNull;

public class ReaderTest {

    /**
     * Test for the construction of Reader
     *
     */
    @Test
    public void shouldCreateReaderObject(){
        Reader reader = new Reader();
        assertNotNull("Reader object created.", reader);
    }
}
