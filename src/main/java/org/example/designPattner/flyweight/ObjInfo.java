package org.example.designPattner.flyweight;

public class ObjInfo {
  private String name;

  public ObjInfo(String name) {
    this.name = name;
  }

  public void action() {
    System.out.println("========");
    System.out.println(this.name);
    System.out.println("========");
  }
}
