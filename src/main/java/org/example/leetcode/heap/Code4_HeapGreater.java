package org.example.leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.swing.text.html.Option;

/**
 * 自定义堆
 * 
 */
public class Code4_HeapGreater {
  public static void main(String[] args) {
    int arr[] = { 1, 7, 3, 4, 5, 6, 2 };
    HeapCreaterQuere<Entry<Integer>> quere = new HeapCreaterQuere<Entry<Integer>>();
    for (int idx = 0; idx < arr.length; idx++) {
      quere.push(arr[idx]);
    }
    each(quere);
    System.out.println(quere.pop());
    each(quere);
    System.out.println(quere.remove(5));
    each(quere);
  }

  private static void each(HeapCreaterQuere<Entry<Integer>> quere) {
    if (!quere.isEmpty()) {
      System.out.println(quere.each());
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

  private Comparator<Entry<Integer>> comparator = new OrderComparator<Entry<Integer>>();
  // 堆
  private ArrayList<Entry<Integer>> heap;

  public HeapCreaterQuere() {
    this.heap = new ArrayList<>();
    this.heapSize = 0;
  }
  public HeapCreaterQuere(Comparator<Entry<Integer>> comparator) {
    this.heap = new ArrayList<>();
    this.heapSize = 0;
    this.comparator= comparator;
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

  public Integer push(Integer data) {
    Entry<Integer> entry = new Entry<Integer>(data);
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
