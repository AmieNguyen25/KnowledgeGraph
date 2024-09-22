/**exercise 1
*@author: Alexis, Tran
**/
import java.util.NoSuchElementException;

public class CircularList<E> implements Iterable<E> {

  Node<E> current;
  int size;

  public CircularList() {
    current = null;
    size = 0;
  }

  public void add(E item) {
    Node<E> newNode = new Node<>(item);
    if (current == null) {
      current = newNode;
      current.next = current; // Pointing to itself for circularity
    } else {
      newNode.next = current.next;
      current.next = newNode;
      current = newNode;
    }
    size++;
  }

  public E get() {
    if (current == null)
      throw new IllegalStateException();
    return current.data;
  }

  public int size() {
    return size;
  }

  public Iterator<E> iterator() {
    return new CircIterator();
  }

  private static class Node<E> {
    private E data;
    private Node<E> next;

    /**
     * Creates a new node with a null next field
     * 
     * @param dataItem The data stored
     */
    private Node(E dataItem) {

      data = dataItem;
      next = null;
    }
  }

  private class CircIterator implements Iterator<E> {
    Node<E> next;
    Node<E> previous;
    boolean nextCalled;

    public CircIterator() {
      next = current;
      previous = null;
      nextCalled = false;
    }

    public boolean hasNext() {
      if (current != null)
        return true;
      return false;
    }

    public E next() {
      if (current == null) {
        throw new NoSuchElementException();
      }
      previous = next;
      next = next.next;
      nextCalled = true;

      return previous.data;
    }

    public void remove() {
      if (nextCalled != true) {
        throw new IllegalStateException();
      }
      // Case one element in list
      if (size == 1) {
        current = null;
      } else {
        // Locate the position of previous2
        Node<E> previous2;
        Node<E> temp = previous;
        while (true) { // Loop through the linked list to find reference to previous2
          temp = temp.next;
          if (temp.next == previous) {
            previous2 = temp;
            break;
          }
        }

        previous2.next = next;
        if (current == previous) {
          current = next;
        }
      }

      size--;
      nextCalled = false;
    }
  }

}
