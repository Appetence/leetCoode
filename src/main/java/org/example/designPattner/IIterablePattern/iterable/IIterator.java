package org.example.designPattner.IIterablePattern.iterable;

public interface IIterator {

  boolean hasNext();

  Object next();

  boolean remove(Object obj);
}
