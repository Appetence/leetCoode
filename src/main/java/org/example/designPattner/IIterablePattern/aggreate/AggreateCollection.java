package org.example.designPattner.IIterablePattern.aggreate;

import java.util.ArrayList;
import java.util.List;

import org.example.designPattner.IIterablePattern.iterable.CustomIterable;
import org.example.designPattner.IIterablePattern.iterable.IIterator;

public class AggreateCollection implements Aggreate {
  private List list = new ArrayList<>();

  @Override
  public boolean add(Object obj) {
    return list.add(obj);
  }

  @Override
  public boolean remove(Object obj) {
    return list.remove(obj);
  }

  @Override
  public IIterator iterable() {
    return new CustomIterable(this.list);
  }

}
