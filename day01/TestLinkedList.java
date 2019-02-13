package com.example.github.algo.day01;

public class TestLinkedList {

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    //反转链表
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    //合并两个有序链表(递归)
    public Node mergeTwoNode(Node node1, Node node2) {
        Node result;
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val < node2.val) {
            result = node1;
            node1.next = mergeTwoNode(node1.next, node2);
        } else {
            result = node2;
            node2.next = mergeTwoNode(node2.next, node1);
        }
        return result;
    }

    //删除列表里倒数第n个节点(快慢指针法)
    public Node removeNthFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (null == fast) {
            return head.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    //获取链表的中间节点（快慢指针法）
    public Node getMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
