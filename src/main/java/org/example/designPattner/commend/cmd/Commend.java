package org.example.designPattner.commend.cmd;

import org.example.designPattner.commend.receive.Receive;

public abstract class Commend {

  private Receive receive;

  public Commend(Receive receive) {
    this.receive = receive;
  }

  public void exec() {
    action();
    receive.doSamething();
  }

  abstract void action();
}
