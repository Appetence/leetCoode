package org.example.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

  public static boolean matches(String text, String role) {
    return Pattern.matches(role, text);
  }

  public static List<String> isMatch(String regex, String role) {
    Pattern pattern = Pattern.compile(role);
    Matcher matcher = pattern.matcher(regex);

    List<String> list = new ArrayList<>();
    while (matcher.find()) {
      list.add(matcher.group());
    }
    return list;
  }
}
