package org.example.designPattner.prototype;

import java.util.List;

public class ActionObj implements Cloneable{
  private String populate;
  private List<String> list;
  

  public String getPopulate() {
    return populate;
  }

  public void setPopulate(String populate) {
    this.populate = populate;
  }
  

  @Override
  protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
     Object clone = super.clone();  
     return clone;
  }

  // @Override
  // public String toString() {
  //   return "ActionObj [populate=" + populate + "]";
  // }

  public List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }


}
