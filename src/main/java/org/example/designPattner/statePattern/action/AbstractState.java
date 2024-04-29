package org.example.designPattner.statePattern.action;

import org.example.designPattner.statePattern.Context;

public abstract class AbstractState implements State {

  protected Context context;


  public void setContext(Context context) {
    this.context = context;
  };

}
