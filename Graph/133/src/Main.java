import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }


    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode root = null;
        if(node == null) {
            return null;
        }
//        HashMap<UndirectedGraphNode, Boolean> flag = new HashMap<UndirectedGraphNode, Boolean>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
//        flag.put(node, true);
        boolean isFirst = true;
        while(!queue.isEmpty()) {
            UndirectedGraphNode crt = queue.poll();
            UndirectedGraphNode newNode;
            if (map.get(crt) == null) {
                newNode = new UndirectedGraphNode(node.label);
                map.put(crt, newNode);
            } else {
                newNode = map.get(crt);
            }
            if(isFirst) {
                root = newNode;
                isFirst = false;
            }
            for(UndirectedGraphNode next : crt.neighbors) {
                if (next != null) {
                    if (map.get(next) == null) {
                        queue.offer(next);
//                        flag.put(next, true);
                    }
                    UndirectedGraphNode newNext;
                    if(map.get(next) == null) {
                        newNext = new UndirectedGraphNode(next.label);
                        map.put(next, newNext);
                    } else {
                        newNext = map.get(next);
                    }
                    newNode.neighbors.add(newNext);
                }
            }
        }
        return root;
    }
}
