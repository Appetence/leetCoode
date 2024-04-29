package org.example.designPattner.statePattern;

import org.example.designPattner.statePattern.action.State;
import org.example.designPattner.statePattern.action.StateAction01;
import org.example.designPattner.statePattern.action.StateAction02;

public class Context {
  // group state
  public static final State STATE1 = new StateAction01();
  public static final State STATE2 = new StateAction02();
  /**
   * 
   */
  private State state;

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
    this.state.setContext(this);
  }

  public void handle() {
    this.state.handle();
  }

}
