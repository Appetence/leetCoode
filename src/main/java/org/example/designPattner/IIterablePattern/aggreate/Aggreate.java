package org.example.designPattner.IIterablePattern.aggreate;

import org.example.designPattner.IIterablePattern.iterable.IIterator;

public interface Aggreate {

  public abstract boolean add(Object obj);

  public abstract boolean remove(Object obj);

  public abstract IIterator iterable();
}
