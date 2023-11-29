package org.example.leetcode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一组线段，获取区间重复次数最多的线段
 */
public class Code3_AreaLineRepeatMax {
  public static void main(String[] args) {
    List<Line> baseData = baseData();

    int repeatMax = areaLineRepeatMax(baseData);
    System.out.println(repeatMax);
  }

  private static int areaLineRepeatMax(List<Line> baseData) {
    if (baseData == null) {
      return 0;
    }
    if (baseData.size() < 2) {
      return 1;
    }

    // 将线段按开始大小，从小到大排序
    baseData.sort((o1, o2) -> o1.start - o2.start);
    // 默认小根堆
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int max = 0;
    // 构建小根堆，每个线段依次入堆，统计重复次数（统计 结束值包含在当前开始值区间范围内的数据）
    for (Line line : baseData) {
      // 队列中第一个节点小于等于 当前线段开始位置
      while (!queue.isEmpty() && queue.peek() <= line.start) {
        // 结束位置位于开始位置之前，所以将小于的线段移除，以判断后续入队的线段中，最大重复次数
        queue.poll();
      }
      queue.add(line.end);
      int size = queue.size();
      max = Math.max(size, max);
    }
    // 获取最大值
    return max;
  }

  private static List<Line> baseData() {
    List<Line> list = new ArrayList<>();
    list.add(new Line(1, 3));// 3
    list.add(new Line(2, 6));// 3
    list.add(new Line(4, 9));// 3
    list.add(new Line(1, 5));// 5
    list.add(new Line(2, 3));// 3
    return list;
  }
}

class Line {
  public int end;
  public int start;

  public Line(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
