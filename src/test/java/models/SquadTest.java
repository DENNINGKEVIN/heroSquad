package models;

import org.junit.After;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SquadTest {
    @After
    public void tearDown() {
        Squad.clearAll(); //clear out all the posts before each test.
    }
    @Test
    public void testSquad_instanciatesCorrectly_true() throws Exception {
        Squad testSquad = new Squad("bandits","banditry",10);
        assertEquals(true, testSquad instanceof Squad);
    }
    @Test
    public void testSquad_getsName_true() throws Exception {
        Squad testSquad = new Squad("bandits","banditry",10);
        assertEquals("bandits", testSquad.getName());
    }
    @Test
    public void testSquad_getsCause_true() throws Exception {
        Squad testSquad = new Squad("bandits","banditry",10);
        assertEquals("banditry", testSquad.getCause());
    }
    @Test
    public void testSquad_getsMaxSize_true() throws Exception {
        Squad testSquad = new Squad("bandits","banditry",10);
        assertEquals(10, testSquad.getMaxSize());
    }
    @Test
    public void testSquad_getsAllSquads_true() throws Exception {
        Squad testSquad = new Squad("bandits","banditry",10);
        Squad testSquad1 = new Squad("ninjas","ninjitsu",4);
        assertEquals(2, Squad.getAllSquads().size());
    }
    @Test
    public void testSquad_getsSquadById_true() throws Exception {
        Squad testSquad = new Squad("bandits","banditry",10);
        Squad testSquad1 = new Squad("ninjas","ninjitsu",4);
        assertEquals("ninjas", Squad.getSquadById(2).getName());
    }
//    @Test
//    public void testSquad_UpdateSquadById_true() throws Exception {
//        Squad testSquad = new Squad("bandits","banditry",10);
//        Squad testSquad1 = testSquad.update("banditFighters","fight bandits",10);
//        assertEquals("banditFighters", testSquad.getName());
//    }




}
