/**exercise 3
*@author: Andrew, Tran
**/
public class BinaryTree<E> {

    protected Node<E> root;

    public BinaryTree() {

    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        } else {
            return null;
        }
    }

    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isLeaf() {
        return root != null && root.left == null && root.right == null;
    }

    protected void inOrderTraversal(ProcessData<E> visitOperation) {
        inOrderTraversal(root, visitOperation);
    }

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
