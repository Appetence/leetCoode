package org.example.designPattner.statePattern;

import org.example.designPattner.statePattern.action.StateAction01;
import org.example.designPattner.statePattern.action.StateAction02;

public class Client {
  public static void main(String[] args) {


    Context context = new Context();
    // 从某个状态开始
    context.setState(new StateAction01());
    context.handle();
  }
}
