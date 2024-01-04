package org.example.leetcode.tree.preTree;

import java.util.HashMap;

/**
 * 使用哈希处理
 */
public class Code12_PreTrieTree {
  public static void main(String[] args) {

  }


  class Node {
    public int pass;
    public int end;

    public HashMap<Integer, Node> nextNodes;

    public Node() {
      nextNodes = new HashMap<>();
    }

  }

}
