package org.example.designPattner.meditorPattern.meditor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.example.designPattner.meditorPattern.colleague.AbsColleague;

/*+
 * support all action
 */
public class LeaderModitor extends AbsModitor {


  @Override
  public void send(String msg, AbsColleague colleague) {
    List<AbsColleague> receiveList = list.stream().filter(item -> !item.equals(colleague)).collect(Collectors.toList());
    receiveList.forEach(item -> item.receive(msg));
  }

  @Override
  public void report() {
    System.out.println("report action");
  }


}
