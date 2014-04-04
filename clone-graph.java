public class Solution {
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> map;

    private void search(UndirectedGraphNode node) {
        if (map.containsKey(node)) {
            return;
        }

        map.put(node, new UndirectedGraphNode(node.label));

        for (UndirectedGraphNode neighbor : node.neighbors) {
            search(neighbor);
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        search(node);

        for (UndirectedGraphNode existingNode : map.keySet()) {
            ArrayList<UndirectedGraphNode> clonedNeighbors = new ArrayList<UndirectedGraphNode>();
            for (UndirectedGraphNode neighbor : existingNode.neighbors) {
                clonedNeighbors.add(map.get(neighbor));
            }
            map.get(existingNode).neighbors = clonedNeighbors;
        }

        return map.get(node);
    }
}