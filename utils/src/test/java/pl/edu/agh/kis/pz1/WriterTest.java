package pl.edu.agh.kis.pz1;

import org.junit.Test;
import pl.edu.agh.kis.pz1.util.Writer;

import static junit.framework.TestCase.assertNotNull;

public class WriterTest {

    /**
     * Test for the construction of Writer
     *
     */
    @Test
    public void shouldCreateWriterObject(){
        Writer writer = new Writer();
        assertNotNull("Writer object created.", writer);
    }
}