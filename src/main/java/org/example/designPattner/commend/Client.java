package org.example.designPattner.commend;

import org.example.designPattner.commend.cmd.BaseCommend;
import org.example.designPattner.commend.cmd.ExecCommend;
import org.example.designPattner.commend.invoker.Invoker;
import org.example.designPattner.commend.receive.ConcreReceivr;
import org.example.designPattner.commend.receive.Receive;

/**
 * 调用者与接收者解耦合
 */
public class Client {
  public static void main(String[] args) {
    Invoker invoker = new Invoker();
    Receive receive = new ConcreReceivr();
    ExecCommend execCommend = new ExecCommend(receive);
    BaseCommend baseCommend = new BaseCommend(receive);
    invoker.setCommend(baseCommend);
    invoker.action();
    invoker.setCommend(execCommend);
    invoker.action();
  }
}
