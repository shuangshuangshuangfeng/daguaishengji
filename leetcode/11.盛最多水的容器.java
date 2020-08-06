/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    /**
     * 双指针法： 
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max_area = 0;
        // @TODO: 每次只移动最小的那个
        // 谁的高度最小，挪动才有可能得到更高的棒子，可能得到更优的解
        // 左右边界，向中间收敛（）
       int i = 0, j = height.length-1;
        while(i < j){
            // 使用条件运算符要比使用Math.min()函数要快些
            int y = height[i]<height[j] ? height[i]:height[j];
            int x = (j-i);
            if(max_area < x*y) max_area = x*y;
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }

        }


        return max_area;
    }


    /**
     * 暴力解决
     * @param height
     * @return
     */
    public int maxArea_mine(int[] height) {
        int max_area = 0;
        for(int i=0; i<height.length; i++){
            for(int j=0; j<i; j++){
                // y 为高， x为宽
                int y = Math.min(height[i], height[j]);
                int x = (i-j);
                if(max_area < x*y) max_area = x*y;
            }
        }    


        return max_area;
    }
}
// @lc code=end

