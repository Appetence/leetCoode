package org.example.designPattner.expersionPattern.symbol;

import java.util.HashMap;

import org.example.designPattner.expersionPattern.base.Expersion;

public class DivisionSymbolExpersion extends AbstractSymbolExpersion {

  public DivisionSymbolExpersion(Expersion left, Expersion right) {
    super(left, right);
  }

  @Override
  public int interpreter(HashMap<String, Integer> map) {
    return this.left.interpreter(map) / this.right.interpreter(map);
  }

}
