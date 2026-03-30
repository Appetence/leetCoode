## 常用
n2 nlogn n
### 选择 selection
    两两比较，交换一次
### 冒泡
    两两比较，每次交换
### 插入 （数据量较小时候）
    从后往前，两辆比较交换
### 使用场景


nlog(n)    
### 快排序
    选定一个基准值(pivot) 将数组分为2部分， 左边小 右边大，然后将两部分递归排序分而治之；先处理深度较低的栈 后处理深度较高的栈
lomuto
hoare
dutch national flag
### 归并排序    
    大数据分组，分小组依次处理


## Master 公式 只针对 子问题规模一致的场景
![alt text](./img/image.png)
    求解时间复杂度

T(N) = a * T(N/b) + O(N^d)
a b d 
|    判断 |                时间复杂度 |
| ---- | ----|
|log b a < d        | O(N^d)|
|log b a > d       |  O(N ^ log b a)|
|log b a == d     |   O(N^d * log N )|

### TODO
1 逆序对问题（归并排序）

2 堆排序
完全二叉树（i是层高）：
父节点：（i - 1）/ 2
左子树：2 * i + 1
右子树：2 * i + 2

2.1 大根堆
2.2 小根堆
2.3 去掉堆上某一个节点，保持数据结构不变
2.4 堆排序 -> 给定数组 -> 大根堆（heapInsert） -> 
            最大节点移动到最后（heap size -- ） ->
                heapSize 有值 （0 - heapsize 执行 heapify 完成排序）

优先级队列结构，底层就是堆