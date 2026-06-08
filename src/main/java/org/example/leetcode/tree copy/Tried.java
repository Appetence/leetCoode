package com.xiaodai.fund.mgmt.reconciliation.tree;

import lombok.Data;

@Data
public class Tried {
    private int pass;
    private int end;

    private Tried[] nexts = new Tried[26];

}
