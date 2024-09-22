  /**exercise 3
  *@author: Tran
  **/
  import org.graphstream.graph.*;
  import org.graphstream.graph.implementations.*;
  
  public class Edge implements Comparable<Edge> {
  	private class RelationNode<E> {
  		private String relationName;
  		private String entityTwo;
  		private RelationNode<E> next;
  		
  		public RelationNode(String relationName, String entityTwo) {
  			this.relationName = relationName;
  			this.entityTwo = entityTwo;
  			this.next = null;
  		}
  	}
  
      private String entityOne;
      private RelationNode<String> head;
  
      public Edge(String entityOne) {
          super();
          this.entityOne = entityOne;
          this.head = null;
      }
  
      public void addS(String relationName, String entityTwo) { // add relations to the beginning of the linked list
      	boolean duplicate = false;
      	RelationNode<String> newNode = new RelationNode<>(relationName, entityTwo);
      	//Check if newNode is identical to anyNode in List so we will not add duplicate data
      	RelationNode<String> temp = head;
      	while(temp != null) {
      		if(newNode.relationName.equals(temp.relationName) && newNode.entityTwo.equals(temp.entityTwo)) { // Check if data is duplicated
      			duplicate = true;
      			break;
      		}
      		temp = temp.next;
      	}
      	if(!duplicate) { // If data is not duplicate, perform addFirst
      		newNode.next = head;
          	head = newNode;
      	}
      }
      
      public void printLinkedEdge() {
      	Graph graph = new SingleGraph("Knowledge Graph");
  		System.setProperty("org.graphstream.ui", "swing");
  		graph.setAttribute("ui.stylesheet",
  	            "edge { text-alignment: along; text-size: 14; }" +
  	            "node { fill-color: green; text-size: 16; text-style: bold; }");
  		graph.setAutoCreate(true);
          graph.setStrict(false);
          graph.display();
          
          RelationNode<String> temp = head;
      	while(temp != null) {
      		org.graphstream.graph.Edge edgeTemp = graph.addEdge(entityOne + " " + temp.entityTwo, entityOne, temp.entityTwo, true);
      		edgeTemp.setAttribute("ui.label", temp.relationName);
      		temp = temp.next;
      	}
          
           
          for (Node node : graph) {
              node.setAttribute("ui.label", node.getId());
          }
      }
      
      public boolean EntityPairsLookUp(String relationName, Graph graph) {
      	boolean found = false;
      	RelationNode<String> temp = head;
      	while(temp != null) {
      		if(temp.relationName.equals(relationName)) {
      			graph.addEdge(entityOne + " " + temp.entityTwo, entityOne, temp.entityTwo, true);
      			found = true;
      		}
      		temp = temp.next;
      	}
      	for (Node node : graph) {
              node.setAttribute("ui.label", node.getId());
          }
      	
      	return found;
      }
      
      public void EntityTwoLookUp(String relationName) {
      	Graph graph = new SingleGraph("Knowledge Graph");
  		System.setProperty("org.graphstream.ui", "swing");
  		graph.setAttribute("ui.stylesheet",
  	            "edge { text-alignment: along; text-size: 14; }" +
  	            "node { fill-color: green; text-size: 16; text-style: bold; }");
  		graph.setAutoCreate(true);
          graph.setStrict(false);
          
      	boolean found = false;
      	RelationNode<String> temp = head;
      	while(temp != null) {
      		if(temp.relationName.equals(relationName)) {
      			org.graphstream.graph.Edge edgeTemp = graph.addEdge(entityOne + " " + temp.entityTwo, entityOne, temp.entityTwo, true);
          		edgeTemp.setAttribute("ui.label", temp.relationName);
      			found = true;
      		}
      		temp = temp.next;
      	}
      	for (Node node : graph) {
              node.setAttribute("ui.label", node.getId());
          }
      	
      	if(found == false)
      		System.out.println("Cannot find entity2 from entity1:[" + entityOne + "], relation:[" + relationName + "]");
      	else
      		graph.display();
      }
      
      public String toString() {
      	String result = entityOne + ": ";
      	RelationNode<String> temp = head;
      	while(temp != null) {
      		result += temp.relationName + " " + temp.entityTwo + ", ";
      		temp = temp.next;
      	}
      	
      	return result.substring(0, result.length() - 2) + "\n"; // Remove the remaining ", " so - 2
      }
  
      @Override
  
      public int compareTo(Edge o) {
  
          return this.entityOne.compareTo(o.entityOne);
  
      }
  
  }
  