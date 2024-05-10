package org.example.designPattner.commend.invoker;

import org.example.designPattner.commend.cmd.Commend;

public class Invoker {
  private Commend commend;

  public void setCommend(Commend cmd) {
    this.commend = cmd;
  }

  public void action() {
    this.commend.exec();
  }
}
