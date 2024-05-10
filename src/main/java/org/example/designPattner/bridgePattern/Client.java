package org.example.designPattner.bridgePattern;

import org.example.designPattner.bridgePattern.Implement.ConcreteImplementor;
import org.example.designPattner.bridgePattern.Implement.IImplement;
import org.example.designPattner.bridgePattern.iAbstract.IAbstract;
import org.example.designPattner.bridgePattern.iAbstract.RefindAbstract;

public class Client {
  public static void main(String[] args) {
    IImplement imp = new ConcreteImplementor();
    IAbstract abs = new RefindAbstract(imp);
    abs.request();
  }
}
