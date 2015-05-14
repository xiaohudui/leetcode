package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
	/**
	 * 改进思路：只用一个map就可以记录是否已经访问过，两个相同的queue可以保存在一个map中的对应位置
	 */
	public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		map.put(node, res);
		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.poll();
			for (UndirectedGraphNode oldNeighbor : n.neighbors) {
				if (map.containsKey(oldNeighbor)) {
					map.get(n).neighbors.add(map.get(oldNeighbor));
				} else {
					UndirectedGraphNode newNeighbor = new UndirectedGraphNode(oldNeighbor.label);
					map.get(n).neighbors.add(newNeighbor);
					map.put(oldNeighbor, newNeighbor);
					queue.offer(oldNeighbor);
				}
			}
		}
		return res;
	}
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		set.add(node.label);
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		map.put(node.label, res);
		Queue<UndirectedGraphNode> copyQueue = new LinkedList<UndirectedGraphNode>();
		copyQueue.offer(res);
		List<UndirectedGraphNode> list;
		UndirectedGraphNode neighbor;
		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.poll();
			UndirectedGraphNode copy = copyQueue.poll();
			set.add(n.label);
			list = new ArrayList<UndirectedGraphNode>();
			for (UndirectedGraphNode p : n.neighbors) {
				if (set.contains(p.label)) {
					neighbor = map.get(p.label);
				} else {
					neighbor = new UndirectedGraphNode(p.label);
					map.put(p.label, neighbor);
					copyQueue.offer(neighbor);
				}
				list.add(neighbor);
				if (!set.contains(p.label)) {
					queue.offer(p);
					set.add(p.label);
				}
			}
			copy.neighbors = list;
		}
		return res;
	}
}
