package farmville;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmvilleTests {

    private Animal horse;
    private Animal cow;
    private Farm testFarm;

    @Before
    public void setUp() {
        horse = new Animal("horse", 1);
        cow = new Animal("cow", 10);
        testFarm = new Farm("BGFarm", 3);
    }

    @Test
    public void testShouldCreateFarmSuccess() {
        Farm farm = new Farm("BGFarm", 3);
        assertEquals("BGFarm", farm.getName());
        assertEquals(3, farm.getCapacity());
        assertEquals(0, farm.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExceptionBecauseNameIsNull(){
        new Farm(null, 15);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExceptionBecauseNameIsWhiteSpace(){
        new Farm("  ", 15);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExceptionBecauseNameIsEmpty(){
        new Farm("", 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowExceptionBecauseCapacityIsNegative(){
        new Farm("SoftUni", -15);
    }

    @Test
    public void testShouldReturnCorrectCount() {
        Farm farm = new Farm("BGFarm", 3);
        farm.add(new Animal("Horse", 100.00));
        assertEquals(1, farm.getCount());
        farm.add(new Animal("Cow", 25.00));
        assertEquals(2, farm.getCount());
    }

    @Test
    public void testShouldReturnCorrectCapacity() {
        Farm farm = new Farm("BGFarm", 3);
        assertEquals(3, farm.getCapacity());
    }

    @Test
    public void testShouldAddAnimalWhenNotFullCapacity() {
        Farm farm = new Farm("BGFarm", 3);
        farm.add(new Animal("Horse", 100.00));
        farm.add(new Animal("Cow", 25.00));
        farm.add(new Animal("Sheep", 75.00));
        assertEquals(3, farm.getCapacity());
    }

    @Test
    public void testAddShouldAddSuccess(){
        testFarm.add(horse);
        assertEquals(1, testFarm.getCount());
        testFarm.add(cow);
        assertEquals(2, testFarm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowBecauseOfNoCapacity(){
        Farm farm = new Farm("SoftUni", 1);
        farm.add(horse);
        farm.add(cow);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowBecauseOfDuplicateAnimal(){
        testFarm.add(horse);
        testFarm.add(horse);
    }

    //remove -> don't remove and return false
    @Test
    public void testRemoveShouldRemove(){
        testFarm.add(horse);
        assertTrue(testFarm.remove(horse.getType()));
        assertEquals(0, testFarm.getCount());
    }
    //remove -> remove and return true
    @Test
    public void testRemoveShouldNotRemove(){
        testFarm.add(horse);
        assertFalse(testFarm.remove(cow.getType()));
        assertEquals(1, testFarm.getCount());
    }

}