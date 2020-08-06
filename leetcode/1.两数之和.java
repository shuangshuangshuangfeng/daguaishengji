/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */


 class Main{
     public static void main(String[] args) {
         Solution solution = new Solution();
         int[] nums = new int[]{2, 7, 11, 15};
         
         int target = 9;
         int [] res = solution.twoSum(nums, target);
        System.out.print(res[0]+"-"+res[1]);
         
     }
 }

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // System.out.print("12345");
        return new int[] {2, 9};
    }
}
// @lc code=end

