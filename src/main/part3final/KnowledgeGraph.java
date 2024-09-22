/**exercise 3
*@author: Tran
**/
import java.io.IOException;

public class KnowledgeGraph {

    private BinarySearchTree<Edge> graph = new BinarySearchTree<>();

    public KnowledgeGraph(String filename) throws IOException {
    	
        super();
        ReadXL xlsxReader = new ReadXL();
        xlsxReader.readBooksFromExcelFile(this, filename);
    }

    public void addRecord(String entityOne, String relationName, String entityTwo) { // String w instead of Word w
    	//Check if there is no blank data
    	// create Edge objects
    	//Search if entityOne is in the tree
    		//If in, get reference to entityOne in tree
    		//Add the relationName and entityTwo to the reference node
    	//Else
    		//Add the relationName and entityTwo to the new Edge objects list
    		//Add Edge to the Tree node
    	if(entityOne != null && relationName != null && entityTwo != null) {
        	Edge entity = new Edge(entityOne);
            if (graph.contains(entity)) {
            	Edge ed = graph.find(entity);
            	ed.addS(relationName, entityTwo);
            } else {
            	entity.addS(relationName, entityTwo);
            	graph.add(entity);
            }
    	}
    }

    public void printAllData() {
    	graph.printOrderedData();
    }
    
    public void searchAssociateWithEntity(String entityOne) {
    	Edge entity = new Edge(entityOne);
    	if(graph.contains(entity)) {
    		Edge ed = graph.find(entity);
    		ed.printLinkedEdge();
    	}
    	else {
    		System.out.println(entityOne + " does not exist!");
    	}
    	System.out.println();
    }
    
    public void searchRelationPairsWith(String relationName) {
    	graph.printPairsByRelation(relationName);
    	System.out.println();
    }
    
    
    public void searchEntityTwo(String entityOne, String relationName) {
    	Edge entity = new Edge(entityOne);
    	if(graph.contains(entity)) {
    		Edge ed = graph.find(entity);
    		ed.EntityTwoLookUp(relationName);
    	}
    	else {
    		System.out.println("entity1 [" + entityOne + "] does not exist!");
    	}
    	System.out.println();
    }
}
