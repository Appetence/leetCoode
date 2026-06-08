package com.xiaodai.fund.mgmt.reconciliation.greedy;

import javax.annotation.Priority;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个金条,分割成指定份,最小分割代价
 * <p>
 * 切割过程反过来看 切割的代价转为合并的代价
 */
public class HalfOne {

    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int item : arr) {
            queue.add(item);
        }
        int sum = 0;
        while (queue.size() > 1) {
            int cur = queue.poll() + queue.poll();
            sum = sum + cur;
            queue.add(cur);
        }
        return sum;
    }

    /**
     * 给定初始 Capital
     * 最多只修k个项目
     * 项目成本:cost
     * 项目收益:profit
     *
     * @return
     */
    public static int findMaximizedCapital(int k, int capital, int[] costArr, int[] profitArr) {

        PriorityQueue<Node> costHeap = new PriorityQueue<>(new CostComparator());
        PriorityQueue<Node> profitHeap = new PriorityQueue<>(new ProfitComparator());

        for (int i = 0; i < costArr.length; i++) {
            costHeap.add(new Node(costArr[i], profitArr[i]));
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            if (!costHeap.isEmpty() && costHeap.peek().getCost() <= capital) {
                profitHeap.add(costHeap.poll());
            }

            if (profitHeap.isEmpty()) {
                return sum;
            }
            sum += profitHeap.poll().getProfit();
        }
        return sum;
    }
}

class Node {
    private int cost;
    private int profit;

    public Node(int cost, int profit) {
        this.cost = cost;
        this.profit = profit;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}

class ProfitComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o2.getProfit() - o1.getProfit();
    }
}

class CostComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o1.getCost() - o2.getCost();
    }
}