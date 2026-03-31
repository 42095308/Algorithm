package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionMergeKLists {
    public ListNode mergeKLists(ListNode[] lists) { // 小顶堆
        // 核心思想：结果链表中的第一个节点必定是所有链表中的第一个节点，且每个链表都是有序的
        if (lists.length < 2) {
            return lists[0];
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (ListNode head : lists) {
            pq.offer(head);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            if (node.next != null) {
                pq.offer(node.next);
                node.next = null;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
