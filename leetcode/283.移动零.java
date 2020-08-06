import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {

    public void moveZeroes(int[] nums) {
        
        int i = 0; //指针
        //先移动非零的数
        // 滚雪球
        for(int j=0; j<nums.length; j++){
            if(nums[j] != 0){
                // 这里做了一个交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
      
    } 


    public void moveZeroes_mine_1(int[] nums) {
        
        int i = 0; //指针
        //先移动非零的数
        for(int j=0; j<nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        //后面补零
        for(int j=i; j<nums.length; j++){
            nums[j] = 0;
        }
    }

    public void moveZeroes_mine(int[] nums) {
        // 冒泡
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length-i-1; j++){
                if(nums[j] == 0){
                    nums[j] = nums[j+1];
                    nums[j+1] = 0;
                }
            }
        }
    }
}
// @lc code=end

