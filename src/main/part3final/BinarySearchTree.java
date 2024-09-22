/**exercise 3
*@author: Tran
**/
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public E find(E target) {

        return find(root, target);

    }

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

    public boolean contains(E target) {

        return contains(root, target);

    }

    public boolean add(E target) {

        if (root == null) {

            root = new Node<E>(target);

            return true;

        }

        return add(root, target);

    }
    
    public void printOrderedData() {

        inOrderTraversal(new ProcessData<E>() {

            @Override

            public void process(E data) {

                System.out.print(data); //Edited

            }

        });

    }
    
    public void printPairsByRelation(String target) {
    	final boolean[] pairFound = {false}; //Use array because can modify value
    	//Create visualize object
        Graph graph = new SingleGraph("Knowledge Graph");
        System.setProperty("org.graphstream.ui", "swing");
		graph.setAttribute("ui.stylesheet",
	            "edge { text-alignment: along; text-size: 14; }" +
	            "node { fill-color: green; text-size: 16; text-style: bold; }");
		graph.setAutoCreate(true);
        graph.setStrict(false);
        
        inOrderTraversal(new ProcessData<E>() {
        	
            @Override

            public void process(E data) {
            	if (data instanceof Edge) {
            		Edge edgeData = (Edge) data;
            		boolean found = edgeData.EntityPairsLookUp(target, graph);
            		if(!pairFound[0])
            			pairFound[0] = found;
                }
            }
        });
        
        if(!pairFound[0])
        	System.out.println("There aren't any entity pair that incidents with [" + target + "]");
        else
        	graph.display();
    }

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
