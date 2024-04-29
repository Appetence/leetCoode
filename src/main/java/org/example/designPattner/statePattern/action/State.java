package org.example.designPattner.statePattern.action;

import org.example.designPattner.statePattern.Context;

public interface State {

  void handle();
  
  void setContext(Context context);
}
