package org.example.leetcode.tree.preTree;

import java.util.HashMap;
import java.util.Map;

import org.example.leetcode.tree.preTree.Code12_PreTrieTree.Tree.Node;

/**
 * 使用哈希处理
 * 不仅局限于26个字母，还可以处理任意字符
 */
public class Code12_PreTrieTree {
  public static void main(String[] args) {
    Tree tree = new Tree();
    String str = "abcd";
    String str3 = "abcd";
    String str1 = "acde";
    String str2 = "adef";
    System.out.println("str insert is " + tree.insert(str));
    System.out.println("str3 insert is " + tree.insert(str3));
    System.out.println("str1 insert is " + tree.insert(str1));
    System.out.println("str2 insert is " + tree.insert(str2));

    System.out.println("strs search is " + tree.search("strs"));

    // System.out.println("strs delete is " + tree.delete("strs"));
    // System.out.println("str delete is " + tree.delete(str));
    // System.out.println("str search is " + tree.search(str));

    System.err.println("ab search Pre is " + tree.searchPre("ab"));
    System.err.println("abc search Pre is " + tree.searchPre("abc"));
    System.err.println("abcd search Pre is " + tree.searchPre("abcd"));

  }

  /**
   * Tree
   * 
   */
  static class Tree {

    public Tree() {
      this.firstNode = new Node();
    }

    private Node firstNode;

    class Node {
      public int pass;
      public int end;

      public HashMap<Character, Node> nextNodes;

      public Node() {
        nextNodes = new HashMap<>();
      }

    }

    public int searchPre(String str) {
      if (check(str)) {
        return -1;
      }

      char[] chars = str.toCharArray();
      Node node = firstNode;
      if (node.pass == 0) {
        return -1;
      }
      for (char ch : chars) {
        Node nexNode = node.nextNodes.get(ch);
        if (nexNode == null || nexNode.pass == 0) {
          return -1;
        }
        node = nexNode;
      }

      return node.pass;
    }

    public boolean delete(String str) {
      if (!search(str)) {
        return false;
      }
      char[] chars = str.toCharArray();
      Node node = firstNode;
      node.pass--;
      for (char ch : chars) {
        Node nextNode = node.nextNodes.get(ch);
        if (--nextNode.pass == 0) {
          // 某个节点 开始无其他节点使用，不在继续往后走
          node.nextNodes.remove(ch);
          return true;
        }
        node = nextNode;
      }
      // 前后都不重要了，因为如果当前节点是最后一踏节点，在循环里是会被处理到的
      node.end--;
      return true;
    }

    public boolean search(String str) {
      if (check(str) || firstNode.pass == 0) {
        return false;
      }
      Node node = firstNode;

      char[] chars = str.toCharArray();
      for (char ch : chars) {
        if (node.nextNodes.containsKey(ch)) {
          node = node.nextNodes.get(ch);
          if (node.pass == 0) {
            return false;
          }
        } else {
          return false;
        }
      }

      return node.end > 0 ? true : false;
    }

    public boolean insert(String str) {
      if (check(str)) {
        return false;
      }
      char[] chars = str.toCharArray();
      Node node = firstNode;
      node.pass++;
      for (char ch : chars) {
        Map<Character, Node> map = node.nextNodes;

        if (map.containsKey(ch)) {
          node = map.get(ch);
        } else {
          node = new Node();
          map.put(ch, node);
        }
        node.pass++;
      }
      node.end++;

      return true;
    }

    private boolean check(String str) {
      return str == null || str.length() == 0;
    }

  }
}
