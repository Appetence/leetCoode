package org.example.leetcode.merge.soft;

/**
 * 给定一个区间范围 loser upper
 * 
 * 获取arr中子数组累加之和 在该范围内的
 */
public class Code2_CountAreaData {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, -2, 4 };

    int result = count(arr, 0, arr.length - 1, 2, 4);
    System.out.println(result);
  }

  private static int count(int[] arr, int minIdx, int maxIdx, int lower, int upper) {
    if (arr == null)
      return 0;
    // 前置项之和
    int[] sum = new int[arr.length];
    sum[0] = arr[0];
    for (int idx = 1; idx < arr.length; idx++) {
      sum[idx] = sum[idx - 1] + arr[idx];
    }

    return countAreaData(sum, minIdx, maxIdx, lower, upper);
  }

  private static int countAreaData(int[] sum, int L, int R, int lower, int upper) {
    if (L == R) {
      if (sum[L] >= lower && sum[L] <= upper) {
        return 1;
      } else {
        return 0;
      }
    } else {
      int mid = L + ((R - L) >> 1);
      int left = countAreaData(sum, L, mid, lower, upper);
      int right = countAreaData(sum, mid + 1, R, lower, upper);
      return left + right + merge(sum, L, mid, R, lower, upper);
    }

  }
/**
 * 
 * @param sum 前置项之和
 * @param L
 * @param mid
 * @param R
 * @param lower
 * @param upper
 * @return
 */
  private static int merge(int[] sum, int L, int mid, int R, int lower, int upper) {
    int size = 0;
    // 范围区间
    int windowL = L;
    int windowR = L;
    // 右边的节点
    for (int rBegin = mid + 1; rBegin <= R; rBegin++) {
      int item = sum[rBegin];
      // 这里的逻辑为 限制 lower , upper 范围内，计算 除去当前节点 新的数据界限 
      int max = item - lower;
      int min = item - upper;
      // 左边 小于最大值
      while (windowR <= mid && sum[windowR] <= max) {
        windowR++;
      }
      // 小于最小值 这里只有保证先排序了，才能确认小数在前边，判断有意义
      while (windowL <= mid && sum[windowL] < min) {
        windowL++;
      }
      size += windowR - windowL;

    }
    int p = L;
    int q = mid + 1;
    int hIdx = 0;
    int[] help = new int[R - L + 1];
    while (p <= mid && q <= R) {
      help[hIdx++] = sum[p] <= sum[q] ? sum[p++] : sum[q++];
    }
    while (p <= mid) {
      help[hIdx++] = sum[p++];
    }
    while (q <= R) {
      help[hIdx++] = sum[q++];
    }

    // sort 
    for (int idx = 0; idx < help.length; idx++) {
      sum[L + idx] = help[idx];
    }

    return size;
  }
}
