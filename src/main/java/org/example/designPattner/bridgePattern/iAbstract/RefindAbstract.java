package org.example.designPattner.bridgePattern.iAbstract;

import org.example.designPattner.bridgePattern.Implement.IImplement;

public class RefindAbstract extends IAbstract {

  public RefindAbstract(IImplement imp) {
    super(imp);
  }

  @Override
  public void request() {
    this.getImp().doAnything();
  }

}
