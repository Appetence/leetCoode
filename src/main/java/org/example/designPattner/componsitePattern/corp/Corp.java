package org.example.designPattner.componsitePattern.corp;

import java.util.List;

/**
 * 透明模式
 */
public abstract class Corp {

  private List<Corp> corpList;
  private String name;

  public void doSomething() {
    System.out.println(this.name + " do action");
    action();
    if (corpList != null) {
      corpList.forEach(item -> item.doSomething());
    }
  }

  protected abstract void action();

  public Corp(String name) {
    this.name = name;
  }

  public List<Corp> getCorpList() {
    return corpList;
  }

  public void setCorpList(List<Corp> corpList) {
    this.corpList = corpList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
