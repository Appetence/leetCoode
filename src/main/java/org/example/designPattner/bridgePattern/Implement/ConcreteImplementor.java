package org.example.designPattner.bridgePattern.Implement;

public class ConcreteImplementor implements IImplement {

  @Override
  public void doSamething() {
    System.out.println("concrete do samething");
  }

  @Override
  public void doAnything() {
    System.out.println("concrete do anything");
  }

}
