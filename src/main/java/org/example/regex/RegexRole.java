package org.example.regex;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.List;
import java.util.regex.Matcher;
import org.example.regex.util.RegexUtil;

public class RegexRole {
  static Matcher matcher;

  public static void main(String[] args) {

    // String role = "\\d";
    // String role = "[0-9]";
    // String role = "\\D";
    // String role = ".";
    // String role = "(\\d)\\d\\1";// [343, 707]
    // String role = "\\d{3}";// [123, 435, 123, 707]
    // String role = "\\d{3,5}";// 最小匹配数量，最大匹配数量 [12343, 1234, 7077]
    // ? 0次或一次 + 一次或多次 * 零次或多次
    // String role = "^(\\d{3,5}[.-]?)+$";// ^ 表示排除 ^\d equal [^0-9] equal \D
    // [12343, , , , , , , 1234., 7077, ]
    // String role = "(\\d{3,5}[.-]?)+$";// ^ 表示排除 ^\d equal [^0-9] equal \D
    // String role = "\\w"; // 字母，数字 ，下划线 [1, 2, 3, 4, 3, 5, a, b, d, s, e, 1, 2, 3,
    // 4, 7, 0, 7, 7, _, X]
    // String role = "\\W"; // 非 （字母，数字 ，下划线） [。]
    // String role = "\\s"; //  匹配 ' ' \t \r \n
    // String role = "\\ba.{3}e\\b"; // abcde, abdfe]
    // String source = "abcde abdfe"; // 限定了开始，结束边界 [abcde, abdfe]
    // String role = "^[-+]?([0-9]+)(\\.[0-9]+)([ef])\\2$"; 
    // String source = "-3.141e.141"; // [-3.141e.141]
    // String role = "^[-+]?([0-9]+)(?:\\.[0-9]+)?([ef])\\2$"; //(?:.... ) 使用?:来标识该分组不需要被捕获 [-3.1ee]
    // String source = "-3.1ee"; //
    String role = "^[-+]?([0-9]+)(\\.[0-9]+)?([ef])$"; 
    String source = "-3.1e"; //
    
    // String role = "\\ba.{3}e\\b"; //  

    // String source = "123435abdse1234.7077_X \r\n\t";
    regex(role, source);
  }

  private static void regex(String role, String source) {
    System.out.println(RegexUtil.regex(source, role));
    // List<String> regex = RegexUtil.regex(source, role);
    // regex.forEach(item -> System.out.println(Charset.defaultCharset().encode(item)));
  }

}
