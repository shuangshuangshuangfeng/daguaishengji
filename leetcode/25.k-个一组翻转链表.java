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
     * 尾插法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 反转后链表的头指针
        ListNode result = new ListNode();
        result.next = head;
        // 指向待翻转部分的头指针
        ListNode reverse_head = result;
        // 指向待翻转部分的尾指针
        ListNode reverse_tail = result;
        
        while(true){
            // 计数器
            int cnt = k;
            // 找到待翻转尾部
            while(cnt>0 && reverse_tail!=null){
                cnt--;
                reverse_tail = reverse_tail.next;
            }

            if(reverse_tail == null) break;
            //暂存新head
            ListNode new_head = reverse_head.next;
            
            // 尾插法翻转
            while(reverse_head.next != reverse_tail){
                ListNode temp = reverse_head.next;
                reverse_head.next = temp.next;
                temp.next = reverse_tail.next;
                reverse_tail.next = temp;
                
            }
            // 重置新的待翻转起点
            reverse_head = new_head;
            reverse_tail = new_head;
            // System.out.println("new head:"+new_head.val);

            // print
            // ListNode r = result;
            // while(r != null){
            //     System.out.print(r.val+"-");
            //     r = r.next;
            // }
            // System.out.println();
            
        }
    
        return result.next;
    }


    /**
     * 递归的方法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup_digui(ListNode head, int k) {
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

