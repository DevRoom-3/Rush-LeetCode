package com.ctrip.hotel.order.processservice.soa;

public class Solution {
    public static void main(String args[]) throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        int k = 2;
        System.out.println(new Solution().rotateRight(n1, k));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        int sum = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            sum++;
        }

        tmp.next = head;
        ListNode tmp2 = head;
        int r = k % sum;
        for (int i = 1; i < sum - r; i++) {
            tmp2 = tmp2.next;
        }

        tmp = tmp2.next;
        tmp2.next = null;

        return tmp;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}