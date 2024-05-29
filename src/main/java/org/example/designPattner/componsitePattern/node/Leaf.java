package org.example.designPattner.componsitePattern.node;

import org.example.designPattner.componsitePattern.component.Component;

public class Leaf implements Component {

  @Override
  public void doSamething() {
    System.out.println("leaf do samething");
  }

}
