import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    private Stack<Integer> stack = null;
    private Stack<Integer> min_stack = null;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    // 插入
    public void push(int x) {
        stack.push(x);
        // 更新辅助栈
        if(min_stack.empty()){
            min_stack.push(x);
        }else{
            if(x <= min_stack.peek()){
                min_stack.push(x);
            }
        }

    }
    // 弹出
    public void pop() {
        if(!stack.empty()){
            int val = stack.pop();
            if(val == min_stack.peek()){
                min_stack.pop();
            }
        }
        
    }
    // 栈顶
    public int top() {
        return stack.peek();
    }
    // 获得最小值
    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

