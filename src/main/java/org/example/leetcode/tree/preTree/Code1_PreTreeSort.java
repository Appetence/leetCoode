package org.example.leetcode.tree.preTree;

/**
 * 前缀树
 * 
 * 
 */
public class Code1_PreTreeSort {

  public static void main(String[] args) {

  }

}

class TrieTree {

  private Node root;

  public TrieTree() {
    root = new Node();
  }

  public void insert(String words) {
    if (words == null) {
      return;
    }
    Node node = root;
    node.pass++;
    int path = 0;
    char[] charArray = words.toCharArray();
    for (char c : charArray) {
      path = c - 'a';

      if (node.nextNodes[path] == null) {
        node.nextNodes[path] = new Node();
      }
      node = node.nextNodes[path];
      node.pass++;
    }
    node.end++;

  }

  public static class Node {
    public int pass;
    public int end;
    public Node[] nextNodes;

    public Node() {
      // 26 个小写英文字母
      nextNodes = new Node[26];
    }

  }
}
