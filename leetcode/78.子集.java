import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList();
        result.add(list);
        for(int i=0; i<nums.length; i++){
            for(List<Integer> list_temp : result){
                List<Integer> m = new ArrayList();
                for(Integer p : list_temp){
                    m.add(p);
                }
                m.add(nums[i]);
                result.add(m);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsets(new int[]{1, 2, 3});
        for(List<Integer> l: result){
            System.out.println(l);
        }
        
    }
}
// @lc code=end

