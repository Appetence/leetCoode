package org.example.designPattner.IIterablePattern;

import org.example.designPattner.IIterablePattern.aggreate.AggreateCollection;
import org.example.designPattner.IIterablePattern.iterable.IIterator;

public class Client {
  public static void main(String[] args) {
    AggreateCollection list = new AggreateCollection();
    list.add("124");
    list.add("123");
    list.add("121");
    IIterator iterable = list.iterable();
    while (iterable.hasNext()) {
      System.out.println(iterable.next());
    }
  }

}
