package com.xiaodai.fund.mgmt.reconciliation.tree;

public class TriedProblem {

    /**
     * 插入单词，沿路节点的 pass 自增，末尾节点 end 自增
     */
    public void insert(String str, Tried head) {
        if (str == null || str.isEmpty()) {
            return;
        }
        head.setPass(head.getPass() + 1);  // 根节点 pass 记录总插入次数
        char[] charArray = str.toCharArray();
        Tried cur = head;
        for (char c : charArray) {
            int idx = c - 'a';
            if (cur.getNexts()[idx] == null) {
                cur.getNexts()[idx] = new Tried();
            }
            Tried next = cur.getNexts()[idx];
            next.setPass(next.getPass() + 1);
            cur = next;
        }
        cur.setEnd(cur.getEnd() + 1);
    }

    /**
     * 精确搜索：单词必须完整存在（end > 0 才算命中）
     */
    public boolean search(String str, Tried head) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        char[] charArray = str.toCharArray();
        Tried cur = head;
        for (char c : charArray) {
            int idx = c - 'a';
            if (cur.getNexts()[idx] == null) {
                return false;
            }
            cur = cur.getNexts()[idx];
        }
        return cur.getEnd() > 0;  // 关键：必须 end > 0 才是完整单词
    }

    /**
     * 前缀搜索：路径存在即返回 true
     */
    public boolean startsWith(String prefix, Tried head) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        char[] charArray = prefix.toCharArray();
        Tried cur = head;
        for (char c : charArray) {
            int idx = c - 'a';
            if (cur.getNexts()[idx] == null) {
                return false;
            }
            cur = cur.getNexts()[idx];
        }
        return true;
    }

    /**
     * 删除单词：沿路 pass 递减，末尾 end 递减；pass 归零则断链
     */
    public boolean delete(String str, Tried head) {
        if (!search(str, head)) {
            return false;
        }

        head.setPass(head.getPass() - 1);  // 根节点 pass 递减
        char[] charArray = str.toCharArray();
        Tried cur = head;
        for (char c : charArray) {
            int idx = c - 'a';
            Tried child = cur.getNexts()[idx];

            int nPass = child.getPass() - 1;
            child.setPass(nPass);  // 修复：设置 child 的 pass，而非 cur
            if (nPass == 0) {
                cur.getNexts()[idx] = null;  // 无词经过，断链释放
                return true;
            }
            cur = child;
        }
        cur.setEnd(cur.getEnd() - 1);  // 末尾节点 end 递减
        return true;
    }
}
