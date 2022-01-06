package pl.edu.agh.kis.pz1;

import org.junit.Test;
import pl.edu.agh.kis.pz1.util.Resources;
import pl.edu.agh.kis.pz1.util.Writer;

import static junit.framework.TestCase.assertNotNull;

public class WriterTest {

    /**
     * Test for the construction of Writer
     *
     */
    @Test
    public void shouldCreateWriterObject(){
        Resources res = new Resources();
        Writer writer = new Writer(1, res);
        assertNotNull("Writer object created.", writer);
    }
}