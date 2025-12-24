package org.example.regex;

public class Code_Regex {
  
  public static void main(String[] args) {
    // String role = "^The.*$";
    // String role = "\\Be\\B";// e在非边界位置出现的次数
    // String role = "(?i)the";// 忽略大小写
    String role = "(the|The|THE)";
    // String role = "^(.*)$";

    // String regex = "The Rime of the Ancient Mariner";
    String regex = "THe the THE";

    regexUtil(regex,role);
  }

  private static void regexUtil(String regex, String role) {
    System.out.println(RegexUtil.isMatch(role,regex));
    System.out.println(RegexUtil.matches(regex,role));
  }
}
