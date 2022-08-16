package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {

    private final static String FOOTBALL_TEAM_NAME = "Levski";
    private final static int FOOTBALL_TEAM_VACANT_POSITIONS = 2;
    private final static int FOOTBALL_TEAM_FOOTBALLERS_COUNT = 2;
    private final static String FIRST_FOOTBALLER_NAME = "Pesho";
    private final static String SECOND_FOOTBALLER_NAME = "Gosho";
    private final static String FOOTBALLER_FOR_REMOVE_AND_SALE = "Gosho";
    private final static String FOOTBALLER_FOOTBALL_TEAM_STATISTICS = "The footballer Pesho, Gosho is in the team Levski.";
    private final static String NULL_FOOTBALLER_FOR_REMOVE_AND_SALE = "Tim";

    private Footballer firstFootballer;
    private Footballer secondFootballer;
    private FootballTeam team;

    @Before
    public void setUp() {
        team = new FootballTeam(FOOTBALL_TEAM_NAME, FOOTBALL_TEAM_VACANT_POSITIONS);
        firstFootballer = new Footballer(FIRST_FOOTBALLER_NAME);
        secondFootballer = new Footballer(SECOND_FOOTBALLER_NAME);

        team.addFootballer(firstFootballer);
        team.addFootballer(secondFootballer);
        team.removeFootballer("Gosho");
        team.addFootballer(secondFootballer);
    }

    @Test(expected = NullPointerException.class)
    public void createFootballTeamWhitNullName(){

        FootballTeam testTeam = new FootballTeam(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFootballTeamWhitNegativeVacantPositions(){

        FootballTeam testTeam = new FootballTeam("Test FootballTeam", -5);
    }

    @Test
    public void getFootballerCountInFootballTeam() {

        Assert.assertEquals(FOOTBALL_TEAM_FOOTBALLERS_COUNT, team.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addFootballerInFullFootballTeam() {

        team.addFootballer(firstFootballer);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeFootballerWhitNameThatNotPresent() {

        team.removeFootballer(NULL_FOOTBALLER_FOR_REMOVE_AND_SALE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void saleFootballerWhitNameThatNotPresent() {

        team.footballerForSale(NULL_FOOTBALLER_FOR_REMOVE_AND_SALE);
    }

    @Test
    public void saleExistingFootballer() {
        Footballer testFootballer = team.footballerForSale(FOOTBALLER_FOR_REMOVE_AND_SALE);

        Assert.assertEquals(secondFootballer, testFootballer);
        Assert.assertFalse(testFootballer.isActive());
    }

    @Test
    public void getFootballTeamStatistics() {
        String actual = team.getStatistics();

        Assert.assertEquals(FOOTBALLER_FOOTBALL_TEAM_STATISTICS, actual);
    }

    @Test
    public void getFootballTeamName() {
        String actual = team.getName();

        Assert.assertEquals(FOOTBALL_TEAM_NAME, actual);
    }

    @Test
    public void getFootballTeamVacantPositions() {

        Assert.assertEquals(FOOTBALL_TEAM_VACANT_POSITIONS, team.getVacantPositions());
    }
}
//    @Test
//    public void testShouldCreateFarmSuccess() {
//        FootballTeam team1 = new FootballTeam("Levski", 10);
//        assertEquals("Levski", team1.getName());
//        assertEquals(10, team1.getVacantPositions());
//        assertEquals(0, team1.getCount());
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testCreateShouldThrowExceptionBecauseNameIsNull(){
//
//        new FootballTeam(null, 12);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testCreateShouldThrowExceptionBecauseNameIsWhiteSpace(){
//
//        new FootballTeam("  ", 12);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testCreateShouldThrowExceptionBecauseNameIsEmpty(){
//        new
//                FootballTeam("", 12);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testCreateShouldThrowExceptionBecauseCapacityIsNegative(){
//        new
//                FootballTeam("Ludogorets", -15);
//    }
//
//    @Test
//    public void testShouldReturnCorrectCount() {
//        FootballTeam team1 = new FootballTeam("Levski", 3);
//        Footballer pesho = new Footballer("Pesho");
//        team1.addFootballer(pesho);
//        assertEquals(1, team1.getCount());
//        Footballer gosho = new Footballer("Gosho");
//        team1.addFootballer(pesho);
//        assertEquals(2, team1.getCount());
//    }
//
//    @Test
//    public void testShouldReturnCorrectCapacity() {
//        FootballTeam team1 = new FootballTeam("Levski", 3);
//        assertEquals(3, team1.getVacantPositions());
//    }
//
//    @Test
//    public void testShouldAddAnimalWhenNotFullCapacity() {
//        FootballTeam team1 = new FootballTeam("Levski", 3);
//        Footballer pesho = new Footballer("Pesho");
//        Footballer gosho = new Footballer("Gosho");
//        Footballer tosho = new Footballer("Tosho");
//        assertEquals(3, team1.getVacantPositions());
//    }
//
//    @Test
//    public void testAddShouldAddSuccess(){
//        FootballTeam team1 = new FootballTeam("Levski", 3);
//        Footballer pesho = new Footballer("Pesho");
//        Footballer gosho = new Footballer("Gosho");
//
//        team1.addFootballer(pesho);
//        assertEquals(1, team1.getCount());
//        team1.addFootballer(gosho);
//        assertEquals(2, team1.getCount());
//    }
//
//   @Test
//    public void testRemoveShouldRemove() {
//       FootballTeam team1 = new FootballTeam("Levski", 3);
//       Footballer pesho = new Footballer("Pesho");
//       Footballer gosho = new Footballer("Gosho");
//       team1.addFootballer(pesho);
//       assertTrue(team1.removeFootballer("Pesho"));
//
//   }
//
//    @Test
//    public void testRemoveShouldRemove(){
//        testFarm.add(horse);
//        assertTrue(testFarm.remove(horse.getType()));
//        assertEquals(0, testFarm.getCount());
//    }
//    //remove -> remove and return true
//    @Test
//    public void testRemoveShouldNotRemove(){
//        testFarm.add(horse);
//        assertFalse(testFarm.remove(cow.getType()));
//        assertEquals(1, testFarm.getCount());
//    }