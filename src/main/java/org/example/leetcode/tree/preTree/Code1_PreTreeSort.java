package org.example.leetcode.tree.preTree;

/**
 * 前缀树
 * a-z 范围内字符，获取某个字符串出现的次数
 * 给定字符串，获取重复出现的次数
 */
public class Code1_PreTreeSort {

  public static void main(String[] args) {
    TrieTree trieTree = new TrieTree();

    String[] arr = { "abc", "bcd", "cde", "acd", "abc", "abcd" };
    for (String item : arr) {
      trieTree.insert(item);
    }

    System.out.println(trieTree.search("abc"));
    System.out.println(trieTree.searchPre("ac"));
    System.out.println(trieTree.delete("abc"));
    System.out.println(trieTree.delete("abc"));
    System.out.println(trieTree.search("abc"));

  }

}

class TrieTree {

  private Node root;

  public TrieTree() {
    root = new Node();
  }

  public int delete(String words) {
    if (words == null || search(words) == -1) {
      return -1;
    }
    char[] chars = words.toCharArray();
    Node node = root;
    node.pass--;
    for (char c : chars) {
      int idx = c - 'a';
      // 沿途节点，经过数量减一
      if (--node.nextNodes[idx].pass == 0) {
        // 把子节点处理为null 也不存在end有值的情况了
        node.nextNodes[idx] = null;
        return 0;
      }
      node = node.nextNodes[idx];
    }
    // 注意，最后结束标识也要同步减少
    return --node.end;
  }

  /**
   * 前缀出现次数
   * 
   * @param pre
   * @return
   */
  public int searchPre(String pre) {
    if (pre == null) {
      return 0;
    }
    Node node = root;
    char[] charArray = pre.toCharArray();
    for (char c : charArray) {
      int idx = c - 'a';
      Node item = node.nextNodes[idx];
      if (item != null) {
        node = item;
      } else {
        return 0;
      }
    }
    return node.pass;
  }

  /**
   * 指定字符 或指定前缀出现次数
   * 
   * @return
   */
  public int search(String item) {
    if (item == null || item == "") {
      return -1;
    }
    Node node = root;
    char[] charArray = item.toCharArray();
    for (char c : charArray) {
      int path = c - 'a';
      Node subNode = node.nextNodes[path];
      // 指定节点非空，且节点元素大于0

      if (subNode != null && subNode.pass > 0) {
        node = subNode;
      } else {
        return -1;
      }
    }

    return node.end > 0 ? node.end : -1;
  }

  /**
   * 前缀树插入
   * 
   * @param words
   */
  public void insert(String words) {
    if (words == null) {
      return;
    }
    Node node = root;
    // 根节点数据，首先加一 统计一共有多少个数据
    node.pass++;
    // begin 0
    char[] charArray = words.toCharArray();
    for (char c : charArray) {
      // offset
      int path = c - 'a';
      // 子节点标识为存在
      if (node.nextNodes[path] == null) {
        node.nextNodes[path] = new Node();
      }
      // 子节点作为下一个根节点
      node = node.nextNodes[path];
      // 路过数据加一
      node.pass++;
    }
    // 最后一个节点标识加一
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
