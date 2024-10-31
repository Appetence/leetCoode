package org.example.regex.util;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
  public static List<String> regex(String source, String role) {

    Pattern pattern = Pattern.compile(role);
    Matcher matcher = pattern.matcher(source);
    List<String> result = new LinkedList<>();
    while (matcher.find()) {
      result.add(matcher.group());
    }
    return result;
  }
}
