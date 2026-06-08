package com.xiaodai.fund.mgmt.reconciliation.greedy;

import java.util.Comparator;

/**
 * 会议室贪心算法——自定义比较器集合
 * <p>
 * 贪心策略：优先选择结束时间最早的会议，可安排最多场会议。
 */
public class MeetingComparator {

    /**
     * 按结束时间升序（贪心标准策略）
     * end 相同时按 begin 升序作为决胜
     */
    public static final Comparator<Meeting> BY_END_ASC = (a, b) -> {
        int cmp = Integer.compare(a.end, b.end);
        return cmp != 0 ? cmp : Integer.compare(a.begin, b.begin);
    };

    /**
     * 按开始时间升序
     */
    public static final Comparator<Meeting> BY_BEGIN_ASC = (a, b) -> {
        int cmp = Integer.compare(a.begin, b.begin);
        return cmp != 0 ? cmp : Integer.compare(a.end, b.end);
    };

    /**
     * 按时长升序（end - begin）
     */
    public static final Comparator<Meeting> BY_DURATION_ASC = (a, b) -> {
        int durA = a.end - a.begin;
        int durB = b.end - b.begin;
        int cmp = Integer.compare(durA, durB);
        return cmp != 0 ? cmp : Integer.compare(a.begin, b.begin);
    };

    private MeetingComparator() {
        // 工具类，禁止实例化
    }
}
