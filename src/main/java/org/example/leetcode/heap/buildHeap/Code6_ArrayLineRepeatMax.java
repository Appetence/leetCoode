package org.example.leetcode.heap.buildHeap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Code6_ArrayLineRepeatMax {

  /**
   * 线段重合问题 给定一组线段，求重合度最高的那组
   * 
   * 重合线段相交位置大于1算相交（3-8 1-3 不算相交 3-4 相交）
   * 
   * 任何一个重合区域左边界必是某个线段左边界
   */

  public static void main(String[] args) {

    // List<LineInfo> result = buildDatas();
    List<LineInfo> result = baseData();
    System.out.println(maxRepeatLine(result));
  }

  private static int maxRepeatLine(List<LineInfo> result) {
    if (result == null) {
      return 0;
    }
    if (result.size() < 2) {
      return 1;
    }

    // 按开始位置进行排序
    result.sort(Comparator.comparingLong(LineInfo::getBegin));

    // 构建一个小根堆
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int max = 0;
    for (LineInfo item : result) {
      // 过滤小根堆中小于等于当前节点开始位置的数据
      while (!heap.isEmpty() && heap.peek() <= item.getBegin()) {
        heap.poll();
      }
      // 当前节点元素追加到堆中
      heap.add(item.getEnd());

      int size = heap.size();
      max = Math.max(max, size);
    }
    return max;
  }

  private static List<LineInfo> baseData() {
    List<LineInfo> list = new ArrayList<>();
    list.add(new LineInfo(1, 3));// 3
    list.add(new LineInfo(2, 6));// 3
    list.add(new LineInfo(4, 9));// 3
    list.add(new LineInfo(1, 5));// 5
    list.add(new LineInfo(2, 3));// 3
    return list;
  }

  private static List<LineInfo> buildDatas() {
    List<LineInfo> result = new LinkedList<LineInfo>();
    result.add(buildLine(1, 2));
    result.add(buildLine(1, 3));
    result.add(buildLine(2, 5));
    result.add(buildLine(3, 5));
    result.add(buildLine(4, 5));
    result.add(buildLine(6, 8));
    return result;
  }

  private static LineInfo buildLine(int begin, int end) {
    LineInfo lineInfo = new LineInfo(begin, end);
    return lineInfo;
  }

}

class LineInfo {

  private int begin;

  private int end;

  public int getBegin() {
    return begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public LineInfo(int begin, int end) {
    this.begin = begin;
    this.end = end;
  }

  public LineInfo() {
  }

}