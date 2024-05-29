package org.example.designPattner.componsitePattern.node;

import java.util.ArrayList;
import java.util.List;

import org.example.designPattner.componsitePattern.component.Component;

public class Breach implements Component {
  private List<Component> list = new ArrayList<>();

  @Override
  public void doSamething() {
    System.out.println("breach do samething");
    each();
  }

  public void add(Component component) {
    list.add(component);
  }

  public void each(){
    System.out.println("=========== begin ==========");
    list.forEach(item -> item.doSamething());
    System.out.println("===========  end  ==========");
  }
}
