/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    /**
     * 基本上是一个斐波那契
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 迈至每个台阶都有两种走法：
        // 1. 上个台阶迈一步
        // 2. 上上个台阶迈两步
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int[] cnt = new int[n+1];
        cnt[0] = 0;
        cnt[1] = 1;
        cnt[2] = 2;
        for(int i=3; i<=n; i++){
            cnt[i] = cnt[i-1]+cnt[i-2];
        }

        return cnt[n];
    }

    //动态规划法2， 省空间
    public int climbStairs_dongtaiguihua2(int n) {
        if(n == 1) return 1;
        if(n == 2)return 2;
        int cnt_1 = 1, cnt_2 = 2, result = 0;
        for(int i=2; i<n; i++){
            result = cnt_1 + cnt_2;
            cnt_1 = cnt_2;
            cnt_2 = result;
        }
        return result;
    }

    //动态规划法1
    public int climbStairs_dongtaiguihua(int n) {
        if(n == 1) return 1;
        if(n == 2)return 2;
        int nums[] = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        for(int i=2; i<n; i++){
            nums[i] = nums[i-1] +nums[i-2];
        }
        return nums[n-1];
    }



    public int climbStairs_digui(int n) {
        return climb_stairs(0, n);
    }

    // 递归法
    int climb_stairs(int current_num, int target_num){
        if(current_num > target_num) return 0;
        if(current_num == target_num) return 1;
        return climb_stairs(current_num+1, target_num)+climb_stairs(current_num+2, target_num);
    }
}
// @lc code=end

