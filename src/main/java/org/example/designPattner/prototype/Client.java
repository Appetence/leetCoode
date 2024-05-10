package org.example.designPattner.prototype;

import java.util.ArrayList;

public class Client {
  public static void main(String[] args) throws CloneNotSupportedException {
    ArrayList<Object> arrayList = new ArrayList<>();
    ActionObj actionObj = new ActionObj();
    actionObj.setList(new ArrayList<>());
    actionObj.setPopulate("name1");
    ActionObj obj = (ActionObj) actionObj.clone();
    System.out.println(obj == actionObj);
    obj.setPopulate("name2");
    System.out.println(obj);
    System.out.println(actionObj);
  }
}
