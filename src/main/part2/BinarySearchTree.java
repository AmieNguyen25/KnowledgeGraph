/**exercise 2
*@author: Andrew, Tran
**/
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    /**Starter method find
     * @param target the object need to be found
     * @return return reference of target in binary tree, otherwise null
     */
    public E find(E target) {

        return find(root, target);

    }

    /** Recursive method find
     * @param subtreeRoot the root of the current subtree
     * @param target the object need to be found
     * @return return reference of target in binary tree, otherwise null
     */
    private E find(Node<E> subtreeRoot, E target) {

        if (subtreeRoot == null) {
            return null;
        }

        if (target.compareTo(subtreeRoot.data) == 0) {
            return subtreeRoot.data;
        } else if (target.compareTo(subtreeRoot.data) < 0) {
            return find(subtreeRoot.left, target);
        } else {
            return find(subtreeRoot.right, target);
        }
    }

    /**Starter method contain
     * @param target the object need to be found
     * @return true if found, false otherwise
     */
    public boolean contains(E target) {

        return contains(root, target);

    }

    /**Starter method add
     * @param target the object need to be added
     * @return true if add success, false if data is already in the tree
     */
    public boolean add(E target) {

        if (root == null) {

            root = new Node<E>(target);

            return true;

        }

        return add(root, target);

    }

    /**Print inordered data
     * 
     */
    public void printOrderedData() {

        inOrderTraversal(new ProcessData<E>() {

            /**Determine what to do with data, in this case is print out
             *
             */
            @Override

            public void process(E data) {

                System.out.print(data); 

            }

        });

    }

    /**Recursive method contains
     * @param subtreeRoot the root of the current subtree
     * @param target the object need to be found
     * @return true if found, false otherwise
     */
    private boolean contains(Node<E> subtreeRoot, E target) {

        if (subtreeRoot == null) {
            return false;
        }

        if (target.compareTo(subtreeRoot.data) == 0) {
            return true;
        } else if (target.compareTo(subtreeRoot.data) < 0) {
            return contains(subtreeRoot.left, target);
        } else {
            return contains(subtreeRoot.right, target);
        }

    }

    /**Recursive method add
     * @param subtreeRoot the root of the current subtree
     * @param target the object need to be added
     * @return true if add success, false if data is already in the tree
     */
    private boolean add(Node<E> subtreeRoot, E target) {

        if (target.compareTo(subtreeRoot.data) == 0) {
            return false;
        } else if (target.compareTo(subtreeRoot.data) < 0) {

            if (subtreeRoot.left == null) {

                subtreeRoot.left = new Node<E>(target);

                return true;

            }

            return add(subtreeRoot.left, target);

        } else {

            if (subtreeRoot.right == null) {

                subtreeRoot.right = new Node<E>(target);

                return true;

            }

            return add(subtreeRoot.right, target);

        }

    }

}
