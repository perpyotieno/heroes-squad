import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero= new Hero("perpy", 30, "shapeshifting", "envy");
        assertEquals(true, hero instanceof Hero);
    }
    public Hero setupNewHero(){
        return new Hero ("perpy", 30, "shapeshifting", "envy");
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception{
        Hero myHero= setupNewHero();
        assertEquals("perpy", myHero.getName() );
    }

    @Test
    public void HeroInstantiatesWithAge_true() throws Exception{
        Hero myHero= setupNewHero();
        assertEquals(30, myHero.getAge());
    }
    @Test
    public void HeroInstantiatesWithSpecialPowers_true() throws Exception{
        Hero myHero= setupNewHero();
        assertEquals("shapeshifting", myHero.getSpecialPowers() );
    }
    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception{
        Hero myHero= setupNewHero();
        assertEquals("envy", myHero.getWeakness() );
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllPosts();
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Hero myHero= setupNewHero();
        Hero otherHero = new Hero ("den", 20, "telepathy", "fear");
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Hero myHero= setupNewHero();
        Hero otherHero = new Hero ("den", 20, "telepathy", "fear");
        assertTrue(Hero.getAll().contains(myHero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Hero myHero = setupNewHero();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreatedAt().getDayOfWeek());
    }
}