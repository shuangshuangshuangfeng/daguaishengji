/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
   
   // 1. 暴力解法
    // 时间复杂度为O(N^3)
    // 空间复杂度为O(1)
    public int largestRectangleArea(int[] heights) {
        int max_area = 0; //最大面积
        for(int i=0; i<heights.length; i++){  // 右边界
            for(int j=0; j<=i; j++){ //左边界
                // 左右边界中间最小高度
                int min_height = heights[j];
                for(int m=j; m<=i; m++){
                    if(heights[m] < min_height) min_height = heights[m];
                }
                int area = (i-j+1)*(min_height);
                if(area > max_area) max_area = area;
                // System.out.println("left:"+j+" right:"+i+" height:"+min_height+" area:"+ area);
            }
            
        }
        return max_area;
    }


    // 1. 暴力解法
    // 时间复杂度为O(N^3)
    // 空间复杂度为O(1)
    public int largestRectangleArea_1(int[] heights) {
        int max_area = 0; //最大面积
        for(int i=0; i<heights.length; i++){  // 右边界
            for(int j=0; j<=i; j++){ //左边界
                // 左右边界中间最小高度
                int min_height = heights[j];
                for(int m=j; m<=i; m++){
                    if(heights[m] < min_height) min_height = heights[m];
                }
                int area = (i-j+1)*(min_height);
                if(area > max_area) max_area = area;
                // System.out.println("left:"+j+" right:"+i+" height:"+min_height+" area:"+ area);
            }
            
        }
        return max_area;
    }

}
// @lc code=end

