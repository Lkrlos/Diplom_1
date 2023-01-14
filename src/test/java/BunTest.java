import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Батон", 100);
    }

    @Test
    public void testGetName() {
        assertEquals("Батон", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(100, bun.getPrice(), 0);
    }
}
