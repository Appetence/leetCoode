package org.example.designPattner.expersionPattern.symbol;

import org.example.designPattner.expersionPattern.base.Expersion;

public abstract class AbstractSymbolExpersion implements Expersion {

  protected Expersion left;
  protected Expersion right;

  public AbstractSymbolExpersion(Expersion left, Expersion right) {
    this.left = left;
    this.right = right;
  }

}
