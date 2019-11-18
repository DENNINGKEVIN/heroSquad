package models;

import org.junit.After;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

public class HeroTest {

    @After
    public void tearDown() {
        Hero.clearAll(); //clear out all the posts before each test.
    }
    @Test
    public void testHero_instanciatesCorrectly_true() throws Exception {
        Hero testHero = new Hero( "hammer", 30,"eating","garlic");
        assertEquals(true, testHero instanceof Hero);
    }

    @Test
    public void testHero_getsName_true() throws Exception {
        Hero testHero = new Hero( "hammer", 30,"eating","garlic");
        assertEquals("hammer",testHero.getName());
    }

    @Test
    public void testHero_getsAge_true() throws Exception {
        Hero testHero = new Hero( "hammer", 30,"eating","garlic");
        assertEquals(30,testHero.getAge());
    }
    @Test
    public void testHero_getsSpecialPower_true() throws Exception {
        Hero testHero = new Hero( "hammer", 30,"eating","garlic");
        assertEquals("eating",testHero.getSpecialPower());
    }
    @Test
    public void testHero_getsWeakness_true() throws Exception {
        Hero testHero = new Hero( "hammer", 30,"eating","garlic");
        assertEquals("garlic",testHero.getWeakness());
    }
    @Test
    public void testHero_getsAll_true() throws Exception {
        Hero testHero = new Hero( "hammer", 30,"eating","garlic");
        Hero testHero1 = new Hero( "hammer", 30,"eating","garlic");
        assertEquals(2,Hero.getAll().size());
    }
    @Test
    public void testHero_getsHeroById_true() throws Exception {
        Hero testHero = new Hero( "hammer", 30,"eating","garlic");
        Hero testHero1 = new Hero( "hammerika", 33,"eating banana","garlic bread");
        assertEquals(33,Hero.getHeroById(2).getAge());
    }
    @Test
    public void testHero_updateHeroById_true(){
        Hero testHero=new Hero("drug",30,"meth","DEA");
        String newName =testHero.updateHeroById("Heisenberg",30,"meth chemist","DEA");
        assertEquals(false,newName.equals(testHero));
    }






}
