/**exercise 1
*@author: Tran
**/
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.NoSuchElementException;

public class CircularListTest {
  @Test
  public void testAdd() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    assertEquals("4 1 2 3", printCircularList(list));
  }

  @Test
  public void testSize() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    assertEquals(4, list.size());
  }

  @Test
  public void testGet1() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    assertEquals(1, (int) list.get());
  }

  @Test
  public void testGet2() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    list.add(2);
    assertEquals(2, (int) list.get());
  }

  @Test
  public void testHasNextFalse() {
    CircularList<Integer> list = new CircularList<>();
    Iterator<Integer> iterator = list.iterator();
    assertFalse(iterator.hasNext()); // hasNext() is false for empty list
  }

  @Test
  public void testHasNextTrue() {
    CircularList<Integer> list = new CircularList<>();
    Iterator<Integer> iterator = list.iterator();
    list.add(1);
    assertTrue(iterator.hasNext());
  }

  @Test
  public void testNext1() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    Iterator<Integer> iterator = list.iterator();
    assertEquals(1, (int) iterator.next());
  }

  @Test
  public void testNext2() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    Iterator<Integer> iterator = list.iterator();
    assertEquals(4, (int) iterator.next());
  }

  @Test
  public void testNext3() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    Iterator<Integer> iterator = list.iterator();
    iterator.next();
    assertEquals(1, (int) iterator.next());
  }

  @Test
  public void testRemove1() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    assertEquals("4 1 2 3", printCircularList(list));
    Iterator<Integer> iterator = list.iterator();
    iterator.next();
    iterator.remove();
    assertEquals("1 2 3", printCircularList(list));
  }

  @Test
  public void testRemove2() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    Iterator<Integer> iterator = list.iterator();
    iterator.next();
    iterator.remove();
    assertEquals(null, printCircularList(list));
  }

  @Test(expected = IllegalStateException.class)
  public void testGetIllegalStateException() {
    CircularList<Integer> list = new CircularList<>();
    list.get(); // Would throw IllegalStateException
  }

  @Test(expected = NoSuchElementException.class)
  public void testNextNoSuchElementException() {
    CircularList<Integer> list = new CircularList<>();
    Iterator<Integer> iterator = list.iterator();
    iterator.next(); // Would throw NoSuchElementException
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveIllegalStateException1() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    Iterator<Integer> iterator = list.iterator();
    iterator.remove(); // Would throw IllegalStateException
  }

  @Test(expected = IllegalStateException.class)
  public void testRemoveIllegalStateException2() {
    CircularList<Integer> list = new CircularList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    Iterator<Integer> iterator = list.iterator();
    iterator.next();
    iterator.remove();
    iterator.remove(); // Would throw IllegalStateException
  }

  @Test(expected = NoSuchElementException.class)
  public void testRemoveNoSuchElement() {
    CircularList<Integer> list = new CircularList<>();
    Iterator<Integer> iterator = list.iterator();
    iterator.next(); // Would throw NoSuchElementException
    iterator.remove();
  }

  public static String printCircularList(CircularList<Integer> aList) {
    if (aList.size() == 0) {
      return null;
    }
    StringBuilder str = new StringBuilder();
    CircularList<Integer> cloneList = aList;

    Iterator<Integer> iterator = cloneList.iterator();
    int count = 0;
    while (iterator.hasNext() && count < cloneList.size()) {
      str.append(iterator.next() + " ");
      count++;
    }

    return str.toString().substring(0, str.length() - 1);
  }
}
