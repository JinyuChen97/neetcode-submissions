class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1. 确定二分查找的上下界
        // 最小速度为 1（每小时至少吃 1 个）
        int l = 1; 
        // 最大速度为堆中香蕉的最大值（每小时吃完最大一堆即可，再大没有意义）
        int r = Arrays.stream(piles).max().getAsInt();
        // 2. 在 [l, r] 闭区间内进行二分查找
        while (l <= r) {
            int k = l + (r - l) / 2; // 避免 (l + r) 溢出的写法
            // ⚠️ 必须用 long 避免多堆累加时超出 int 范围导致溢出
            long totalTime = 0; 
            // 计算以速度 k 吃完所有香蕉需要的总小时数
            for (int p : piles) {
                // (p + k - 1) / k 等价于 Math.ceil((double) p / k)，即向上取整
                // 使用纯整数运算替代浮点数，既避免了精度问题，又提高了运行效率
                totalTime += (p + k - 1) / k;
            }
            // 3. 根据耗时调整二分搜索区间
            if (totalTime <= h) {
                // 当前速度 k 能够在 h 小时内吃完（符合条件）
                // 尝试寻找有没有更小的可行速度，收缩右边界
                r = k - 1;
            } else {
                // 当前速度 k 太慢，无法在 h 小时内吃完（不符合条件）
                // 必须加大速度，收缩左边界
                l = k + 1;
            }
        }
        // 4. 循环结束时，满足 l = r + 1
        // r 停留在最后一个“超时（totalTime > h）”的非法速度上
        // l (即 r + 1) 恰好停留在第一个“能按时吃完（totalTime <= h）”的最小合法速度上
        return r + 1; // 也可以直接返回 l
    }
}