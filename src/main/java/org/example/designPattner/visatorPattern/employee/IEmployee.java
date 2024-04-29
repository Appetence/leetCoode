package org.example.designPattner.visatorPattern.employee;

import org.example.designPattner.visatorPattern.visitor.IVisitor;

public interface IEmployee {

  void doSamething(IVisitor visitor);

  String getNickName();

  void setNickName(String nickName);
}
