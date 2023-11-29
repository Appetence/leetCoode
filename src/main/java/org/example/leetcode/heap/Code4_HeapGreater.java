package org.example.leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义堆 ，
 * 
 */
public class Code4_HeapGreater {
  public static void main(String[] args) {

    int[] arr = { 7, 3, 4, 5, 6, 1, 2 };
    ArrayList<Entry<Integer>> arrayList = new ArrayList<Entry<Integer>>();
    ;
    for (int value : arr) {
      Entry<Integer> entry = new Entry<Integer>(value);
      arrayList.add(entry);
    }
    HeapCreaterQuere<Integer> quere = new HeapCreaterQuere<Integer>(arrayList);
    // 构建堆
    for (int idx = 0; idx < arr.length; idx++) {
      quere.heapInsert(idx);
    }
    // 排序
    int length = arr.length;
    while (length > 0) {
      quere.heapify(0, --length);
    }

    for (Entry<Integer> item : arrayList) {
      System.out.print(item.getData() + ",");
    }
  }

}

/**
 * 自定义 堆，实现 O(N) 获取指定节点
 */
class HeapCreaterQuere<T> {

  // index
  private Map<Entry<Integer>, Integer> map = new HashMap<Entry<Integer>, Integer>();

  private int heapSize;

  private Comparator<Entry<Integer>> comparator = new OrderComparator<Entry<Integer>>();;
  // 堆
  private ArrayList<Entry<Integer>> heap;

  public HeapCreaterQuere(ArrayList<Entry<Integer>> heap) {
    this.heap = heap;
    this.heapSize = heap.size();
  }

  public boolean add(Integer data) {
    Entry<Integer> entry = new Entry<Integer>(data);
    if (map.containsKey(entry)) {
      // 已存在的对象
      Integer index = map.get(entry);
      // TODO
    } else {
      heap.add(entry);
      map.put(entry, heapSize);
      heapInsert(heapSize++);
    }
    return true;
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

  public void heapify(int index, int heapSize) {
    int left = 2 * index + 1;
    while (heapSize > left) {
      int min = ((heapSize > left + 1) && (comparator.compare(heap.get(left), heap.get(left + 1)) < 0)) ? left + 1
          : left;
      // 判读最小的节点是哪个
      min = (comparator.compare(heap.get(min), heap.get(index)) < 0) ? index : min;
      if (min == index) {
        break;
      }
      swap(min, index);
      index = min;
      left = 2 * left + 1;
    }
  }

  private boolean resigin(T t1, T t2) {
    return false;
  }

  public T peek() {

    return null;
  }

  public T poll() {
    return null;
  }

  public T remove(T data) {
    return null;
  }

  public int size() {
    return -1;
  }
}

class OrderComparator<T> implements Comparator<Entry<Integer>> {

  @Override
  public int compare(Entry<Integer> o1, Entry<Integer> o2) {
    return o1.getData() - o2.getData();
  }

}

class Entry<T> {
  private T data;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Entry(T data) {
    this.data = data;
  }

}
