package org.example.designPattner.visatorPattern.employee;

import org.example.designPattner.visatorPattern.visitor.IVisitor;

public abstract class AbstractEmployee implements IEmployee {
  /**
   * 昵称
   */
  private String nickName;

  @Override
  public void doSamething(IVisitor visitor) {
    visitor.visit(this);
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

}
