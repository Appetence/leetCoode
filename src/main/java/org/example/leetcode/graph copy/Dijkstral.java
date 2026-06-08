package com.xiaodai.fund.mgmt.reconciliation.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Dijkstral {

    /**
     * 最小生成路径
     * min distance
     * @param args
     */

    public static void main(String[] args) {

    }

    /**
     * Dijkstra 算法：返回从 head 出发到各节点的最短距离
     * 只对不在 selectSet 中的节点进行松弛操作
     */
    public static Map<Node, Integer> getDistanceMap(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectSet = new HashSet<>();
        Node minNode = getMinDistanceNodeByDistanceMap(selectSet, distanceMap);
        while (Objects.nonNull(minNode)) {
            Integer minValue = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                // 只对尚未确定最短距离的节点尝试松source ~/.bash_profile弛
                if (!selectSet.contains(toNode)) {
                    int newDist = minValue + edge.weight;
                    if (distanceMap.containsKey(toNode)) {
                        distanceMap.put(toNode, Math.min(distanceMap.get(toNode), newDist));
                    } else {
                        distanceMap.put(toNode, newDist);
                    }
                }
            }
    
            selectSet.add(minNode);
            minNode = getMinDistanceNodeByDistanceMap(selectSet, distanceMap);
        }
        return distanceMap;
    }

    public static Node getMinDistanceNodeByDistanceMap(HashSet<Node> selectSet, HashMap<Node, Integer> distanceMap) {
        Integer min = Integer.MAX_VALUE;
        Node minNode = null;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node key = entry.getKey();
            Integer value = entry.getValue();
            if (!selectSet.contains(key) && value < min) {
                minNode = key;
                min = value;
            }
        }
        return minNode;
    }
}
