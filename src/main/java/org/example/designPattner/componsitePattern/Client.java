package org.example.designPattner.componsitePattern;

import java.util.ArrayList;

import org.example.designPattner.componsitePattern.corp.Corp;
import org.example.designPattner.componsitePattern.corp.ManagerCorp;
import org.example.designPattner.componsitePattern.corp.NormalCorp;
import org.example.designPattner.componsitePattern.node.Breach;
import org.example.designPattner.componsitePattern.node.Leaf;

public class Client {
  public static void main(String[] args) {

    Corp manager = new ManagerCorp("manager 1");
    Corp manager2 = new ManagerCorp("manager 2");
    Corp normal = new NormalCorp("normal 1");
    Corp normal2 = new NormalCorp("normal 2");
    ArrayList<Corp> list = new ArrayList<>();
    list.add(normal);
    list.add(normal2);
    manager.setCorpList(list);
    ArrayList<Corp> list2 = new ArrayList<>();

    list2.add(manager);
    manager2.setCorpList(list2);
    manager2.doSomething();

    Breach breach = new Breach();
    Breach breach2 = new Breach();

    Leaf leaf = new Leaf();
    Leaf leaf2 = new Leaf();


    breach.add(breach2);
    breach2.add(leaf);
    breach2.add(leaf2);
    // breach2.each();
    breach.each();
  }
}
