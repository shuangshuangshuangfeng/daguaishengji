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
    public ListNode detectCycle(ListNode head) {
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

