package org.example.designPattner.IIterablePattern.iterable;

import java.util.List;

public class CustomIterable implements IIterator {

  private List list;

  private int cursor;
  private int size;

  public CustomIterable(List list) {
    this.list = list;
    this.size = list.size();
  }

  @Override
  public boolean hasNext() {
    if (cursor >= size) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public Object next() {
    Object result = null;
    if (hasNext()) {
      result = this.list.get(this.cursor++);
    }
    return result;
  }

  @Override
  public boolean remove(Object obj) {
    return this.list.remove(obj);
  }

}
