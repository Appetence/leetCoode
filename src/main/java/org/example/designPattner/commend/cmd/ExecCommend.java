package org.example.designPattner.commend.cmd;

import org.example.designPattner.commend.receive.Receive;

public class ExecCommend extends Commend {

  public ExecCommend(Receive receive) {
    super(receive);
  }

  @Override
  public void action() {
    System.out.println("exec commend");
  }

}
