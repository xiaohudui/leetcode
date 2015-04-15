package medium;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {
	public static void main(String[] args) {
		UndirectedGraphNode node1=new UndirectedGraphNode(1);
		UndirectedGraphNode node2=new UndirectedGraphNode(2);
		UndirectedGraphNode node3=new UndirectedGraphNode(3);
		List<UndirectedGraphNode> list1=new ArrayList<UndirectedGraphNode>();
		list1.add(node2);
		list1.add(node3);
		node1.neighbors=list1;
		List<UndirectedGraphNode> list2=new ArrayList<UndirectedGraphNode>();
		list2.add(node3);
		node2.neighbors=list2;
		System.out.println(new CloneGraph().cloneGraph(node1));
	}
	
}
