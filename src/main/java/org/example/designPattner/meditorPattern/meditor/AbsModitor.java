package org.example.designPattner.meditorPattern.meditor;

import java.util.ArrayList;
import java.util.List;

import org.example.designPattner.meditorPattern.colleague.AbsColleague;

/**
 * moditor handle all action
 */
public abstract class AbsModitor {

  protected List<AbsColleague> list = new ArrayList<>();

  public void addColleague(AbsColleague colleague) {
    list.add(colleague);
  }

  public abstract void report();

  public abstract void send(String msg, AbsColleague colleague);

}
