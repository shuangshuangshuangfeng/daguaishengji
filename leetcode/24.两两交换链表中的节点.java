/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res_head = null, res_tail = null;
        ListNode pre_node = null;
        
        int flag = 0;
        while(head != null){
            if(flag == 0){
                pre_node = head;
                flag = 1;
            }else{
                if(res_head == null){
                    res_head = head;
                    res_tail = head;
                    res_tail.next = pre_node;
                    res_tail = pre_node;
                }else{
                    res_tail.next = head;
                    head.next = pre_node;
                    res_tail = pre_node;
                }
                flag = 0;
            }
            head = head.next;
        }

        return res_head;
    }
}
// @lc code=end

