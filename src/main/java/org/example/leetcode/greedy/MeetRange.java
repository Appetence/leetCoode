package com.xiaodai.fund.mgmt.reconciliation.greedy;

import java.util.List;
import java.util.Objects;

/**
 * 时间段范围内 满足条件的会议
 * <p>
 * 1  依据结束时间进行排序
 * 2  依次遍历各 node，判断开始时间是否满足条件
 */
public class MeetRange {


    /**
     * 贪心算法：统计最多可安排的非重叠会议数量
     * <p>
     * 策略：先按结束时间升序排序，再依次选择 begin >= 当前 end 的会议
     *
     * @param list 待排会议列表（会被内部排序，如需保留原顺序请传入副本）
     * @return 最多可安排的非重叠会议场次
     */
    public int maxMeetingCount(List<Meeting> list) {
        if (Objects.isNull(list) || list.isEmpty()) {
            return 0;
        }
        // 步骤 1：按结束时间升序
        list.sort(MeetingComparator.BY_END_ASC);

        // 步骤 2：贪心选择
        int count = 1;
        int curEnd = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            Meeting m = list.get(i);
            if (m.begin >= curEnd) {
                count++;
                curEnd = m.end;
            }
        }
        return count;
    }

    public int result(List<Meeting> list) {
        return maxMeetingCount(list);
    }

    /**
     * 按结束时间升序排列（贪心标准策略）
     */
    public List<Meeting> sort(List<Meeting> list) {
        if (Objects.isNull(list) || list.isEmpty()) {
            return list;
        }
        list.sort(MeetingComparator.BY_END_ASC);
        return list;
    }
}

