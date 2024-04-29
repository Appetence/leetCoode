package org.example.designPattner.statePattern.action;

import org.example.designPattner.statePattern.Context;

public class StateAction01 extends AbstractState {
  /**
   * abstract method
   * filter
   * 
   */
  @Override
  public void handle() {
    System.out.println("state action 01");
    this.context.setState(Context.STATE2);
    this.context.handle();
    System.out.println("state action 01");
  }

}
