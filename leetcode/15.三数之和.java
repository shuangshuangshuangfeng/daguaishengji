import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 先排序, 得到从小到大排序结果
        Arrays.sort(nums);

        if(nums == null || nums.length <3) return res;

        int len = nums.length;

        for(int i=0; i<len-1; i++){
            int current = nums[i];
            if(current > 0) return res;
            if(i > 0 && current == nums[i-1]) continue;
           
            // 中间指针
            int left_index = i+1;
            int right_index = len-1;
            while(left_index < right_index){
                int cnt = current+nums[left_index]+nums[right_index];
                
                if(cnt == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(current);
                    list.add(nums[left_index]);
                    list.add(nums[right_index]);

                    res.add(list);
                    while(left_index < right_index && nums[left_index+1] == nums[left_index]) left_index++;
                    while (left_index <right_index && nums[right_index-1] == nums[right_index]) right_index--;
                    left_index ++;
                    right_index --;
                }else if(cnt > 0){
                    right_index--;
                    
                }else{
                    left_index++;
                }
                
            }
        }

        
        return res;
    }


    public List<List<Integer>> threeSum_mine(int[] nums) {
        // 先排序
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                for(int k=0; k<j; k++){
                    if(i!=j && j!=k && i!=k){
                        if(nums[i] + nums[j] + nums[k] == 0){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            res = add_quchong(res, list);
                        }
                    }
                }
            }
        }

        
        return res;
    }


    private List<List<Integer>> add_quchong(List<List<Integer>> list, List<Integer> e){
        // 如果List<Integer> 中的数是已经排好序的
        int flag = 0;
        for(List<Integer> l: list){
            boolean a = l.get(0) == e.get(0);
            boolean b = l.get(1) == e.get(1);
            boolean c = l.get(2) == e.get(2);
            if(a == true && b == true && c == true){
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            list.add(e);
        }
        
        return list;
    }
}
// @lc code=end

