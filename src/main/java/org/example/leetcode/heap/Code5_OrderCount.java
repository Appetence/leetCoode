package org.example.leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 不同时间点，客户购买了商品,获取购买数最多的用户
 * 
 * 统计购买数量最多的用户
 */
public class Code5_OrderCount {

  // 获奖区
  private static HeapCreaterQuere<Entry<Integer>> giftArea = new HeapCreaterQuere<Entry<Integer>>(
      new WaitOrderComparator(), 3);
  // 候选区
  private static HeapCreaterQuere<Entry<Integer>> waitArea = new HeapCreaterQuere<Entry<Integer>>(
      new WaitOrderComparator(), 5);

  public static void main(String[] args) {
    // 用户
    int[] people = { 1, 2, 3, 4, 5, 6, 2, 3, 2, 1, 1 };
    // 行为
    int[] action = { 1, 2, -1, 4, 5, 6, 2, -3, 2, 1, 1 };

    /**
     * 定义两个堆，一个大根堆（候选区），一个小根堆（得奖区）
     * 
     * 用户发生购买行为
     * 得奖区没满，直接进入的将区
     * 得奖区满了，进入候选区
     * 候选区最大是否大于 得奖区最小，
     * 大于 将得奖区最小 移出 候选区最大进入得奖区
     * 小于
     * 
     */
    buyGift(people, action);

  }

  private static void buyGift(int[] people, int[] action) {
    for (int idx = 0; idx < people.length; idx++) {

    }
  }

  /**
   * 自定义 堆，实现 O(N) 获取指定节点
   */
  class HeapCreaterQuere<T> {

    // index
    private Map<Entry<Integer>, Integer> map = new HashMap<Entry<Integer>, Integer>();

    private int heapSize;

    private Comparator<Entry<Integer>> comparator;
    // 堆
    private ArrayList<Entry<Integer>> heap;

    public HeapCreaterQuere(Comparator<Entry<Integer>> comparator, int heapSize) {
      this.heap = new ArrayList<>();
      this.heapSize = heapSize;
      this.comparator = comparator;
    }

    public boolean isEmpty() {
      return heapSize == 0;
    }

    public String each() {
      String result = "";
      for (Entry<Integer> heap : heap) {
        result = result + heap.getData().intValue() + " ";
      }
      return result;
    }

    public Integer push(Integer data, Integer time) {
      Entry<Integer> entry = new Entry<Integer>(data, time);
      if (map.containsKey(entry)) {
        // 已存在的对象
        return map.get(entry);
        // TODO
      } else {
        heap.add(entry);
        map.put(entry, heapSize);
        int size = heapSize++;
        heapInsert(size);// 大根堆
        // 保证每次新增都能走到heapIfy

        return data;
      }
    }

    public void heapInsert(int index) {

      int parebtIndex = (index - 1) / 2;

      while (comparator.compare(heap.get(parebtIndex), heap.get(index)) < 0) {
        swap(parebtIndex, index);
        index = parebtIndex;
        parebtIndex = (index - 1) / 2;
      }

    }

    public void swap(int oleIdx, int newIdx) {
      Entry<Integer> entryOld = heap.get(oleIdx);
      Entry<Integer> entryNew = heap.get(newIdx);
      heap.set(oleIdx, entryNew);
      heap.set(newIdx, entryOld);
      map.put(entryNew, oleIdx);
      map.put(entryOld, newIdx);
    }

    // 大根堆
    public void heapify(int index) {
      int left = 2 * index + 1;
      while (heapSize > left) {
        int max = ((heapSize > left + 1) && (comparator.compare(heap.get(left), heap.get(left + 1)) < 0)) ? left + 1
            : left;
        // 判读最大的节点是哪个
        max = (comparator.compare(heap.get(max), heap.get(index)) < 0) ? index : max;
        if (max == index) {
          break;
        }
        swap(max, index);
        index = max;
        left = 2 * left + 1;
      }
    }

    private boolean resign(Integer t1, Integer t2) {

      return false;
    }

    public Entry<Integer> peek() {
      return heap.get(0);
    }

    /**
     * 取出头结点
     * 
     * @return
     */
    public Entry<Integer> pop() {
      Entry<Integer> entry = heap.get(0);
      swap(0, heapSize - 1);
      map.remove(entry);
      heap.remove(--heapSize);
      heapify(0);
      return entry;
    }

    public Entry<Integer> remove(Integer data) {

      Optional<Entry<Integer>> option = map.entrySet().stream().filter(item -> item.getKey().getData().equals(data))
          .map(item -> item.getKey()).findFirst();
      if (option.isPresent()) {
        Entry entry = option.get();
        map.remove(entry);
        heap.remove(entry);
        return entry;
      } else {
        return null;
      }
    }

    public int size() {
      return heapSize;
    }
  }

}

class Entry<T> {
  private T data;
  private int time;

  public Entry(T data, int time) {
    this.data = data;
    this.time = time;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }
}

/**
 * 获奖去比较器
 */
class GiftOrderComparator implements Comparator<Entry<Integer>> {

  @Override
  public int compare(Entry<Integer> o1, Entry<Integer> o2) {
    return o1.getData().equals(o2.getData()) ? o1.getTime() - o2.getTime() : o1.getData() - o2.getData();
  }

}

/**
 * 候选区比较器
 */
class WaitOrderComparator implements Comparator<Entry<Integer>> {

  @Override
  public int compare(Entry<Integer> o1, Entry<Integer> o2) {
    return o1.getData().equals(o2.getData()) ? o2.getTime() - o1.getTime() : o2.getData() - o1.getData();
  }

}
