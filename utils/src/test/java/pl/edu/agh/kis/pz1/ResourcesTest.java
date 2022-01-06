package pl.edu.agh.kis.pz1;

import org.junit.Test;
import pl.edu.agh.kis.pz1.util.Reader;
import pl.edu.agh.kis.pz1.util.Resources;

import static junit.framework.TestCase.*;

public class ResourcesTest {
    /**
     * Test for the construction of Resources
     *
     */
    @Test
    public void shouldCreateResourcesObject(){
        Resources resources = new Resources();
        assertNotNull("Resources object created.", resources);
    }

    @Test
    public void doesReaderAcquireAuxiliarySemaphore() {
        Resources resources = new Resources();
        try {
            resources.readLock();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        assertEquals("AuxillarySemaphore is acuired by Reader", 0, resources.auxiliarySemaphore.availablePermits());
    }

}
