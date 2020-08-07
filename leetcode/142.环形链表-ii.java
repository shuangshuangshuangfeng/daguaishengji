import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    /**
     * 双指针，一个指针每次走一步，另一个指针一次走两步
     * 这样他们相遇时，恰好
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast_pointer = head;
        ListNode slow_pointer = head;
        int flag = 0; // 判断是否相遇

        // 一步和两步同时走，相遇的时候，两步比一步多走的
        // 路一定在循环里面
        while(fast_pointer != null && slow_pointer != null){
            if(fast_pointer == null || fast_pointer.next == null) return null;
            
            fast_pointer = fast_pointer.next.next;
            slow_pointer = slow_pointer.next;
            if(slow_pointer == fast_pointer){
                flag = 1;
                 break;
            }
        }

        if(flag == 0) return null;

        fast_pointer = head; //重置faster_pointer
        // fast 和 slow都走一步，相遇的地方即为循环起点
        while(fast_pointer != slow_pointer){
            fast_pointer = fast_pointer.next;
            slow_pointer = slow_pointer.next;
        }
        return fast_pointer;
    }


    /**
     * 使用set存储之前走过的node
     * @param head
     * @return
     */
    public ListNode detectCycle_1(ListNode head) {
        Set<ListNode> sets = new HashSet<>();
        while(head != null){
            if(sets.contains(head)){
                return head;
            }
            sets.add(head);
            head = head.next;
        }
        return null;
    }
}
// @lc code=end

