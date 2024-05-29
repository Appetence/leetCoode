package org.example.designPattner.componsitePattern.corp;

public class ManagerCorp extends Corp {

  public ManagerCorp(String name) {
    super(name);
  }

  @Override
  protected void action() {
    System.out.println("manager action is manager");
  }

}
