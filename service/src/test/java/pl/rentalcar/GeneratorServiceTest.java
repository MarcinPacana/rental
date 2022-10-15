package pl.rentalcar;

import junit.framework.TestCase;
import org.junit.Test;

public class GeneratorServiceTest extends TestCase {


    @Test
    public void testGenerateMD5() {
        String s = "hasloDoZahaszowania";
        String hash = GeneratorService.generateMD5(s);
        assertTrue(!s.equals(hash));
    }
}