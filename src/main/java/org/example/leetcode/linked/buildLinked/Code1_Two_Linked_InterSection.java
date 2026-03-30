package org.example.leetcode.linked.buildLinked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 两个有序列表，求交集
 * 
 * 1 相同则同时移动
 * 
 * 2 不同时，谁小谁移动
 * 
 * 
 * two linked
 * complate InterSection
 */
public class Code1_Two_Linked_InterSection {
   public static void main(String[] args) {

      List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
      List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 8));
      ArrayList<Integer> interSection = interSection(list1, list2);
      System.out.println(interSection);
   }

   private static ArrayList<Integer> interSection(List<Integer> list, List<Integer> list2) {
      if (list == null || list2 == null || list.size() == 0 || list2.size() == 0) {
         return new ArrayList<>();

      }
      int l1 = 0;
      int l2 = 0;
      ArrayList<Integer> result = new ArrayList<>();
      while (l1 < list.size() && l2 < list2.size()) {

         Integer integer = list.get(l1);
         Integer integer2 = list2.get(l2);
         int compareTo = integer.compareTo(integer2);
         if (compareTo == 0) {
            if (result.isEmpty() || !result.get(result.size() - 1).equals(integer)) {
               result.add(integer);
            }
            l1++;
            l2++;
         } else if (compareTo > 0) {
            l2++;
         } else {
            l1++;
         }
      }
      return result;
   }

}
