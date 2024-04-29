package org.example.designPattner.visatorPattern.visitor;

import org.example.designPattner.visatorPattern.employee.IEmployee;

public interface IVisitor {
  /**
   * common method
   * 
 */
  void visit(IEmployee employee);

}
