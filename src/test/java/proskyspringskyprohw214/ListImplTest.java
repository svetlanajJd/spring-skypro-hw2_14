package proskyspringskyprohw214;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(MockitoExtension.class)
public class ListImplTest {

    private final ListImpl arr = new ListImpl(new String[]{"5", "1"});

    private final ListImpl out = new ListImpl(new String[]{"5", "1"});

    @Test
    public void addItem() {
        String[] expected = new String[]{"0", "1"};
        out.add("0");
        out.add("1");
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addIndex() {
        String[] expected = new String[]{"5", "1"};
        out.add(0, "5");
        out.add(1, "1");
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setIndex() {
        String[] expected = new String[]{"5", "1"};
        out.set(0, "5");
        out.set(1, "1");
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeItem() {
        String[] expected = new String[]{"1"};
        out.remove("5");
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeIndex() {
        String[] expected = new String[]{"1"};
        out.remove(0);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void containsItem() {
        boolean expected = true;
        boolean actual = out.contains("5");
        assertEquals(expected, actual);
    }

    @Test
    public void searchIndexOf() {
        int expected = 0;
        int actual = out.indexOf("5");
        assertEquals(expected, actual);
    }

    @Test
    public void searchLastIndexOf() {
        int expected = 0;
        int actual = out.indexOf("5");
        assertEquals(expected, actual);
    }

    @Test
    public void getIndex() {
        String expected = "5";
        String actual = out.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getSize() {
        String[] array = new String[2];
        int expected = array.length;
        int actual = out.size();
        assertEquals(expected, actual);
    }

    @Test
    public void equals() {
        String[] array = new String[]{"5", "1"};
        boolean expected = Arrays.equals(arr.toArray(), array);
        boolean actual = out.equals(array);
        assertEquals(expected, actual);
    }

    @Test
    public void empty() {
        boolean expected = false;
        boolean actual = out.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void arrayNew() {
        String[] expected = new String[]{"5", "1"};
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getListIndexExceptionAddItem() {
        Assertions.assertThrows(ListIndexException.class, () -> out.add(null));
    }

    @Test
    public void getListIndexExceptionAddIndex() {
        Assertions.assertThrows(ListIndexException.class, () -> out.add(3,"2"));
    }

    @Test
    public void getListIndexExceptionSet() {
        Assertions.assertThrows(ListIndexException.class, () -> out.set(5,"1"));
    }

    @Test
    public void getListIndexExceptionRemove() {
        Assertions.assertThrows(ListIndexException.class, () -> out.remove(5));
    }

}
