package org.example.designPattner.expersionPattern.var;

import java.util.HashMap;

import org.example.designPattner.expersionPattern.base.Expersion;

public class VarExpersion implements Expersion {

  private String key;

  public VarExpersion(String key) {
    this.key = key;
  }

  @Override
  public int interpreter(HashMap<String, Integer> map) {
    return map.get(key);
  }

}
