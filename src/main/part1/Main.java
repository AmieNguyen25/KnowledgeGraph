import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        CircularList<Integer> list = new CircularList<>();
        try {
        	list.get();
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException caught: " + e.getMessage());
        }

        // Testing add method
        list.add(1);
        System.out.println(list.get());
        list.add(2);
        System.out.println(list.get());
        list.add(3);
        System.out.println(list.get());
        list.add(4);
        System.out.println(list.get());
        list.add(5);
        System.out.println(list.get());

        // Testing get method
        System.out.println("Current element: " + list.get());

        // Testing size method
        System.out.println("Size of list: " + list.size());

        // Testing Iterator
        Iterator<Integer> iterator = list.iterator();
        System.out.println("Iterating through the list:");
        int iteratorVisited = 0; // Initialize iteratorVisited
        while (iterator.hasNext() && iteratorVisited < list.size()) {
            System.out.print(iterator.next() + " ");
            iteratorVisited++;
        }
        System.out.println();

        // Testing remove method
        System.out.println("Removing element returned by next(): " + iterator.next());
        iterator.remove();
        System.out.println("New size of list: " + list.size());

        // Testing Iterator after removal
        System.out.println("Iterating through the list after removal:");
        iterator = list.iterator();
        iteratorVisited = 0; // Reset iteratorVisited
        while (iterator.hasNext() && iteratorVisited < list.size()) {
            System.out.print(iterator.next() + " ");
            iteratorVisited++;
        }
        System.out.println();

        // Testing IllegalStateException in Iterator's remove method
        System.out.println("Trying to remove again without calling next:");
        iterator.remove();
        try {
        	iterator.remove();
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException caught: " + e.getMessage());
        }
        System.out.println();

        // Testing NoSuchElementException in Iterator's next method
        CircularList<Integer> list2 = new CircularList<>();
        iterator = list2.iterator();
        try {
            iterator.next();
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException caught: " + e.getMessage());
        }
    }
}
