package org.example.designPattner.visatorPattern;

import org.example.designPattner.visatorPattern.employee.IEmployee;
import org.example.designPattner.visatorPattern.employee.Manager;
import org.example.designPattner.visatorPattern.employee.NormalEmployee;
import org.example.designPattner.visatorPattern.visitor.IVisitor;
import org.example.designPattner.visatorPattern.visitor.ShowVisit;

public class Client {
  public static void main(String[] args) {
    IVisitor iVisitor = new ShowVisit();
    IEmployee managerEmployee = new Manager();
    IEmployee normalEmployee = new NormalEmployee();

    normalEmployee.doSamething(iVisitor);
    managerEmployee.doSamething(iVisitor);
  }
}
