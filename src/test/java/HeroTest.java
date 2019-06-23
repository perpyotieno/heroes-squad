import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void newHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero= new Hero("perpy", 30, "shapeshifting", "envy");
        assertEquals(true, hero instanceof Hero);
    }

    @After
    public void tearDown() throws Exception {
    }
}