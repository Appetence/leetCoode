package org.example.designPattner.proxyPattern.action;

public class GRoleAction implements GActionInterface {

  @Override
  public void normalMethod(String name) {
    System.out.println("this is normal method " + name);
  }

  @Override
  public void specificalMethod(String name) {
    System.out.println("this is specification method " + name);
  }

}
