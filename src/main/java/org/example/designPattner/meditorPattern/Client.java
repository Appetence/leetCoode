package org.example.designPattner.meditorPattern;

import org.example.designPattner.meditorPattern.colleague.NormalColleague;
import org.example.designPattner.meditorPattern.colleague.SaleRepColleague;
import org.example.designPattner.meditorPattern.meditor.AbsModitor;
import org.example.designPattner.meditorPattern.meditor.LeaderModitor;

/**
 * meditor pattern
 * moditor content other action , open method support third method use
 * 
 * 
 */
public class Client {

  public static void main(String[] args) {
    AbsModitor moditor = new LeaderModitor();
    NormalColleague normal = new NormalColleague("normal", moditor);
    SaleRepColleague saleRep = new SaleRepColleague("saleRep", moditor);

    normal.send("normal handle msg");
    saleRep.send("saleRep handle msg");
  }
}
