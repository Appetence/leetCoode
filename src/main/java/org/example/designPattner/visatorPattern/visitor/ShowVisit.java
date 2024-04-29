package org.example.designPattner.visatorPattern.visitor;

import org.example.designPattner.visatorPattern.employee.IEmployee;

public class ShowVisit implements IVisitor {

  @Override
  public void visit(IEmployee employee) {
    // visitor handle special logic
    String nickName = employee.getNickName();
    System.out.println("this nick name is " + nickName);
  }

}
