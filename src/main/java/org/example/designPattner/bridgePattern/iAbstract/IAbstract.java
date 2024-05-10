package org.example.designPattner.bridgePattern.iAbstract;

import org.example.designPattner.bridgePattern.Implement.IImplement;

public abstract class IAbstract {
  private IImplement imp;

  public IAbstract(IImplement imp) {
    this.imp = imp;
  }

  public void request() {
    this.imp.doSamething();
  }

  protected IImplement getImp() {
    return imp;
  }

}
