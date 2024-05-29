package org.example.leetcode.tree.preTree;

public class Code1_PreTreeSort_N {
  public static void main(String[] args) {
    // pre tree
    String str1 = "abcd";
    String str2 = "acd";
    String strr = "";

    Tree tree = new Tree();
    System.out.println(tree.search(strr));

    tree.insert(str1);
    tree.insert(str2);
    tree.insert(strr);

    System.out.println(tree.search(str1));

    System.out.println("tree.searchPre(\"ab\") " + tree.searchPre("ab"));
    System.out.println("tree.searchPre(\"ae\") " + tree.searchPre("ae"));
    System.out.println("tree.delete(\"ae\") " + tree.delete("ae"));
    System.out.println("tree.delete(str2) " + tree.delete(str2));
    System.out.println("tree.search(str2) " + tree.search(str2));
    System.out.println(">>>");
  }
}

class Tree {

  public Tree() {
  }

  private Node firstNode;

  /**
   * delete first seach last delete
   * 
   * @param str
   * @return
   */
  public boolean delete(String str) {
    if (str == null || str.length() == 0) {
      return false;
    }
    if (firstNode == null) {
      return false;
    }
    if (search(str)) {
      Node node = firstNode;
      node.pass--;
      for (char c : str.toCharArray()) {
        int idx = c - 'a';
        // next node
        if (--node.subNode[idx].pass == 0) {
          // 当前node last nod
          node.subNode[idx] = null;
          return true;
        }
        // 能到这里，说明下一个节点必定有数据
        node = node.subNode[idx];
      }
      node.end--;
      return true;
    }
    return false;

  }

  public int searchPre(String str) {
    if (str == null || str.length() == 0) {
      return -1;
    }
    if (firstNode == null) {
      return -1;
    }
    char[] charArray = str.toCharArray();
    Node node = firstNode;
    for (char c : charArray) {
      int idx = c - 'a';
      Node subNode = node.subNode[idx];
      if (subNode == null || subNode.pass < 1) {
        return -1;
      }
      node = subNode;
    }
    return node.pass;
  }

  public boolean search(String str) {
    if (str == null || str.length() == 0) {
      return false;
    }
    if (firstNode == null) {
      return false;
    }
    Node node = firstNode;
    char[] charArray = str.toCharArray();
    for (char c : charArray) {
      int idx = c - 'a';
      // 兼容删除场景
      if (node.subNode[idx] == null || node.pass == 0) {
        return false;
      }
      node = node.subNode[idx];

    }

    return true;
  }

  public void insert(String str) {
    if (str == null || str.length() == 0) {
      return;
    }
    char[] charArray = str.toCharArray();
    if (firstNode == null) {
      firstNode = new Node();
    }
    Node node = firstNode;
    for (char c : charArray) {
      // 当前节点 current
      node.pass++;
      int idx = c - 'a';
      Node[] subNode = node.subNode;
      if (subNode[idx] == null) {
        subNode[idx] = new Node();
      }
      node = subNode[idx];
    }
    // 子节点节点数量加1
    node.pass++;
    // 节点结尾加1
    node.end++;
  }

  class Node {
    // 多少字符点过我
    int pass;
    // 多少字符在该节点结尾
    int end;
    Node[] subNode;

    public Node() {
      this.subNode = new Node[26];
    }

  }
}
