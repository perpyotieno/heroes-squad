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
    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{
        Hero.clearAllPosts();
        Hero myHero = setupNewHero();
        assertEquals(1, myHero.getId());
    }
    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero myHero = setupNewHero();
        assertEquals(1, Hero.findById(myHero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Hero myHero = setupNewHero();
       Hero otherPost = new Hero("Marvin",20,"Invisibility", "shy");
        assertEquals(2, Hero.findById(otherPost.getId()).getId());
    }
    @Test
    public void updateChangesHeroContent() throws Exception {
        Hero myHero = setupNewHero();
        String formerName = myHero.getName();
        int formerAge = myHero.getAge();
        String formerSpecialPowers= myHero.getSpecialPowers();
        String formerWeakness= myHero.getWeakness();

        LocalDateTime formerDate = myHero.getCreatedAt();
        int formerId = myHero.getId();

        myHero.update("Mercy", 35, "night vision", "faithless");

        assertEquals(formerId, myHero.getId());
        assertEquals(formerDate, myHero.getCreatedAt());
        assertNotEquals(formerName, myHero.getName());
        assertNotEquals(formerAge, myHero.getAge());
        assertNotEquals(formerSpecialPowers, myHero.getSpecialPowers());
        assertNotEquals(formerWeakness, myHero.getWeakness());
    }

    @Test
    public void deleteDeletesASpecificHero() throws Exception {
        Hero myHero = setupNewHero();
        Hero otherHero = new Hero("Mercy", 35, "night vision", "faithless");
        myHero.deleteHero();
        assertEquals(1, Hero.getAll().size());
        assertEquals(Hero.getAll().get(0).getId(), 2);
    }@Test
    public void deleteAllHerosDeletesAllHeros() throws Exception {
        Hero myHero = setupNewHero();
        Hero otherHero = setupNewHero();

        Hero.clearAllPosts();
        assertEquals(0, Hero.getAll().size());
    }
}