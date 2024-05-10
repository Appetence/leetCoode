package org.example.designPattner.commend.cmd;

import org.example.designPattner.commend.receive.Receive;

public class BaseCommend extends Commend {


  
  public BaseCommend(Receive receive) {
    super(receive);
  }

  @Override
  public void action() {
    System.out.println("base commend");
  }

}
