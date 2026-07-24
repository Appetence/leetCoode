package org.example.leetcode.code.str;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class All_Sub_Str {
    public static void main(String[] args) {
        String str = "abcdae";
        char[] strArr = str.toCharArray();
        List<String> result = new LinkedList();
        process(strArr, 0, result);

        System.out.println(result);
    }

    private static void process(char[] strArr, int i, List<String> result) {
        if (i == strArr.length) {
            result.add(String.valueOf(strArr));
        }
        boolean[] visit = new boolean[26];
        // pre fix
        for (int j = i; j < strArr.length; j++) {
            if (!visit[strArr[j] - 'a']) {
                visit[strArr[j] - 'a'] = true;

                // begin i == j
                swap(strArr, i, j);
                process(strArr, i + 1, result);
                swap(strArr, i, j);

            }

        }
    }

    private static void swap(char[] ca, int i, int j) {
        if (i == j) {
            return;
        }
        char ans = ca[i];
        ca[i] = ca[j];
        ca[j] = ans;
    }

}
