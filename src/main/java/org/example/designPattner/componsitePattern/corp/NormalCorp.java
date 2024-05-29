package org.example.designPattner.componsitePattern.corp;

public class NormalCorp extends Corp {

  public NormalCorp(String name) {
    super(name);
  }

  @Override
  protected void action() {
    System.out.println("normal action is normal");
  }

}
