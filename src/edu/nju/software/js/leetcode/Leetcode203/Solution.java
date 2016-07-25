package edu.nju.software.js.leetcode.Leetcode203;

/**
 * Created by liveangel on 2016-3-8.
 */

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode p = head;

        
        while(true){
            if(head==null) return head;
            if(p.val!=val) break;
            p=p.next;
            head =p;
        }

        while(p.next!=null){
            if (p.next.val == val){
                ListNode tmp = p.next;
                p.next = tmp.next;
            }else{
                p=p.next;
            }
        }
        return head;


    }

}
