package org.example.designPattner.expersionPattern.symbol;

import java.util.HashMap;
import java.util.Stack;

import org.example.designPattner.expersionPattern.base.Expersion;
import org.example.designPattner.expersionPattern.var.VarExpersion;

public class Calcultor {
  private Expersion expersion;

  public Calcultor(String str) {

    Stack<Expersion> stack = new Stack<>();
    char[] charArray = str.toCharArray();
    Expersion left;
    Expersion right;
    for (int i = 0; i < charArray.length; i++) {
      switch (charArray[i]) {
        case '+':
          left = stack.pop();
          // 下一个元素
          right = new VarExpersion(String.valueOf(charArray[++i]));
          //
          stack.push(new AddSymbolExpersion(left, right));
          break;
        default:
          // 保存key
          stack.push(new VarExpersion(String.valueOf(charArray[i])));
          break;
      }
    }
    this.expersion = stack.pop();
  }

  public int run(HashMap<String, Integer> map) {
    return this.expersion.interpreter(map);
  }
}
