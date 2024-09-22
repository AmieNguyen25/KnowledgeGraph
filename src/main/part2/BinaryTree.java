/**exercise 2
*@author: Andrew
**/
public class BinaryTree<E> {

    protected Node<E> root;

    /**Constructs an empty binary tree
     * 
     */
    public BinaryTree() {
    	root = null;
    }

    /**Constructs a binary tree with the given data at the root and the two given subtrees
     * @param data
     * @param leftTree
     * @param rightTree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
    }

    /**Constructs a binary tree with the given node as the root
     * @param root
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**Returns the left subtree
     * @return
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    /**Returns the right subtree
     * @return
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /**Returns the data in the root
     * @return
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**Check if the tree is empty
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**Returns true if this tree is a leaf, false otherwise
     * @return
     */
    public boolean isLeaf() {
        return root != null && root.left == null && root.right == null;
    }
   
    /**Starter method inOrderTraversal
     * @param visitOperation to process data of each visited node
     */
    protected void inOrderTraversal(ProcessData<E> visitOperation) {
        inOrderTraversal(root, visitOperation);
    }

    /**Recursive inOrderTraversal method
     * @param node the local root of the subtree
     * @param visitOperation to process data of each visited node
     */
    private void inOrderTraversal(Node<E> node, ProcessData<E> visitOperation) {
        if (node == null) {
            return;
        }
        if (node.left != null && visitOperation instanceof PrePostProcess) {
            ((PrePostProcess<E>) visitOperation).pre();
        }
        inOrderTraversal(node.left, visitOperation);
        visitOperation.process(node.data);
        inOrderTraversal(node.right, visitOperation);
        if (node.right != null && visitOperation instanceof PrePostProcess) {
            ((PrePostProcess<E>) visitOperation).post();
        }
    }

    protected interface ProcessData<E> {

        void process(E data);
    }

    protected interface PrePostProcess<E> extends ProcessData<E> {

        void pre();

        void post();
    }

    protected static class Node<E> {

        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {

            this.data = data;

        }

        @Override
        public String toString() {

            return data.toString();

        }

    }

}
