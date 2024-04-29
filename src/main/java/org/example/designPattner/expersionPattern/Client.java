package org.example.designPattner.expersionPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.example.designPattner.expersionPattern.symbol.Calcultor;

public class Client {
  public static void main(String[] args) throws IOException {
    // 表达式
    String expStr = getExpStr();
    // 基础数据
    HashMap<String, Integer> map = getValue(expStr);
    Calcultor calcultor = new Calcultor(expStr);
    int result = calcultor.run(map);
    System.out.println(result);
  }

  private static String getExpStr() throws IOException {
    System.out.println(" please input expersion ：");
    return (new BufferedReader(new InputStreamReader(System.in))).readLine();
  }

  private static HashMap<String, Integer> getValue(String str) throws IOException {
    HashMap<String, Integer> map = new HashMap<>();
    for (char ch : str.toCharArray()) {
      if (ch != '+') {
        if (!map.containsKey(String.valueOf(ch))) {
          // 读取
          String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
          map.put(String.valueOf(ch), Integer.valueOf(in));
        }
      }
    }
    return map;
  }
}
