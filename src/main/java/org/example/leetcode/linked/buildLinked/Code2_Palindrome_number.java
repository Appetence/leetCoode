package org.example.leetcode.linked.buildLinked;

/**
 * 给 一个数，判断是否是回文 palindrone
 */
public class Code2_Palindrome_number {
    public static void main(String[] args) {
        String base = "12e21";
        boolean result = palindromeNumber(base);
        System.out.println(result);
    }

    private static boolean palindromeNumber2(String context) {
        if (context == null || context.isEmpty()) {
            return false;
        }
        int left = 0;
        int right = context.length() - 1;
        while (left < right) {
            if (context.charAt(right) != context.charAt(left)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean palindromeNumber(String context) {
        if (context == null || context.length() < 1) {
            return false;
        }
        int length = context.length();
        for (int i = 0; i < length / 2; i++) {
            if (context.charAt(i) != context.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
