import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
   
    // 3. 空间换时间, 单调栈
    // 时间复杂度为O(N)
    // 空间复杂度为O(N)
    public int largestRectangleArea(int[] heights) {
        // 用来存储最小柱子高度的index
        Stack<Integer> stack = new Stack<>();

        // copy一份新的数组
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        int max_area = 0; //最大面积

        for(int i=0; i<tmp.length; i++){  
            while(!stack.isEmpty() && tmp[i]<tmp[stack.peek()]){
                // 如果当前tmp[i]小于tmp[stack.peek()]
                int index = stack.pop();
                int height = tmp[index];
                max_area = Math.max(max_area, (i-stack.peek()-1)*height);
            }
            stack.push(i);
        }
        return max_area;
    }

    // 2. 暴力解法2
    // 时间复杂度为O(N^3)
    // 空间复杂度为O(1)
    public int largestRectangleArea_2(int[] heights) {
        int max_area = 0; //最大面积
        for(int i=0; i<heights.length; i++){  
            for(int j=0; j<=i; j++){ 
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



    // 1. 暴力解法1
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

