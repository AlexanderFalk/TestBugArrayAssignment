import com.test.MyArrayListWithBugs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestCases {

    MyArrayListWithBugs array = new MyArrayListWithBugs();

    @Test
    public void classInstantiationTesting() {
       Assertions.assertNotEquals(null, array);
    }

    @Test
    public void sizeOfArrayWithoutElementsTesting() {
        System.out.println("Testing size before any adding");
        Assertions.assertEquals(0, array.size());
    }

    @Test
    public void sizeOfArrayWithElementsTesting() {
        System.out.println("Adding elements to an empty array and checking");
        //Adding two elements
        array.add(2);
        array.add(3);
        Assertions.assertEquals(2, array.size());
    }

    @Test
    public void addToArrayTesting() {
        System.out.println("Size of array before: " + array.size());
        Assertions.assertEquals(0, array.size());
        //Adding elements
        array.add("Object 1");
        array.add("Object 3");
        array.add(55);
        System.out.println("Size of array after: " + array.size());
        Assertions.assertEquals(3, array.size());

        array.add(2);
        System.out.println("Size of array after after: " + array.size());
        Assertions.assertEquals(4, array.size());
    }

    @Test
    public void getItemFromArrayTesting() {
        System.out.println("Get item from array");
        //Adding elements
        array.add("Object 1");
        array.add("Object 3");
        array.add(55);

        // Getting the second item inserted into the array
        Assertions.assertEquals("Object 3", array.get(1));
    }

    @Test
    public void getItemFromArrayThrowIndexOutOfBoundsTesting() {
        System.out.println("Get item from array, but throw exception due to out of bounds array");
        //Adding elements
        array.add("Object 1");
        array.add("Object 3");
        array.add(55);

        //Throw index out of bounds, since the array is only 3 size long
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(5);
        });
    }

    @Test
    public void getItemFromArrayAtIndexZeroTesting() {
        System.out.println("Get item from array at index 0");
        //Adding elements
        array.add("Object 1");
        array.add("Object 3");
        array.add(55);
        //Throw index out of bounds, since the array is only 3 size long
        Assertions.assertEquals("Object 1", array.get(0));
    }

    @Test
    public void addItemAtIndexTesting() {
        System.out.println("Add item at index");
        //Adding elements
        array.add("Object 1");
        array.add("Object 3");
        array.add(55);
        System.out.println("Size of array: " + array.size());
        // Getting the second item inserted into the array
        Assertions.assertEquals("Object 3", array.get(1));
        Assertions.assertEquals(3, array.size());
        //Adding at same position as above; checking for object and size changes
        array.add(1, "index");
        Assertions.assertEquals("index", array.get(1));
    }

    @Test
    public void removeItemAtIndexTesting() {
        System.out.println("Remove item at index");
        //Adding elements
        array.add("Object 1");
        array.add("Object 3");
        array.add(55);
        Assertions.assertEquals(3, array.size());
        array.remove(1);
        System.out.println("Size of array after removal: " + array.size());
        // Checking if the second is now moved a position down & if the size decreased
        Assertions.assertEquals(55, array.get(1));
        Assertions.assertEquals(2, array.size());
    }

    @Test
    public void removeItemAtIndexOutOfBoundsTesting() {
        System.out.println("Remove item at index, which is not there");
        //Adding elements
        array.add("Object 1");
        array.add("Object 3");
        array.add(55);
        // Checking for index out of bounds
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.remove(5);
        });
    }
}
