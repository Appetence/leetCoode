package org.example.designPattner.meditorPattern.colleague;

import org.example.designPattner.meditorPattern.meditor.AbsModitor;

public abstract class AbsColleague {

  protected String name;
  protected AbsModitor moditor;

  public AbsColleague(String name, AbsModitor moditor) {
    this.name = name;
    this.moditor = moditor;
    this.moditor.addColleague(this);
  }

  public void receive(String msg) {
    System.out.println(this.name + " receive msg:  " + msg);
  }

  /**
   * 各colleague 之间交互只通过中介者
   * 
   * @param msg
   * @param moditor
   */
  public void send(String msg) {
    this.moditor.send(msg, this);
  };
}
