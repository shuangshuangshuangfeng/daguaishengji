import org.graalvm.compiler.lir.EdgeMoveOptimizer;

import sun.security.util.HexDumpEncoder;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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

    /**
     * 递归的方法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 链表分为三部分：
        // 1. 已反转， 2，待反转， 3.未反转
        if(head == null || head.next == null) return head;

        ListNode tail = head;
        for(int i=0; i<k; i++){
            // 剩余数量若小于k的化，不需要反转
            if(tail == null){
                return head;
            }
            tail = tail.next;
        }

        // 反转前k个元素
        ListNode newHead = _reverseNodes(head, tail);
        // 下一轮开始的地方就是tail
        head.next = reverseKGroup(tail, k);
        
        
        return newHead;
    }



    /**
     * 反转链表, 左闭右开区间
     * @param one
     * @param two
     * @return
     */
    private ListNode _reverseNodes(ListNode one, ListNode two){
        ListNode temp = new ListNode();
        
        while(one != two){
            ListNode p = one;
            one = one.next;
            p.next = temp.next;
            temp.next = p;
        }

        return temp.next;
    }

    public ListNode reverseKGroup_mine(ListNode head, int k) {
        // 使用一个数组存储k个ListNode地址
        ListNode[] array = new ListNode[k];
        int cnt = 0;
        ListNode temp_head = head;
        ListNode res = new ListNode();
        ListNode tail_pointer = res;
        while(temp_head != null){
            if(cnt != k){
                array[cnt++] = temp_head;
                temp_head = temp_head.next;
            }
            if(cnt == k){
                // todo
                for(int i=k-1; i>=0; i--){
                    tail_pointer.next = array[i];
                    tail_pointer = tail_pointer.next;
                    tail_pointer.next = null;
                }
                cnt = 0;
            }
        }

        if(cnt < k && cnt != 0){
            for(int i=0; i<cnt; i++){
                tail_pointer.next = array[i];
                tail_pointer = tail_pointer.next; 
                tail_pointer.next = null;
            }
        }
        return res.next;
    }
}
// @lc code=end

