package linkedlist;

public class SolutionSortList {
    public ListNode sortList(ListNode head) { // 归并排序
        if (head == null || head.next == null) return head;
        ListNode mid = seekMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = (left == null) ? right : left;
        return dummy.next;
    }

    private ListNode seekMid(ListNode head) {
        ListNode fast = head.next; // 走快一步是为了在偶数节点时找到前半部分的末尾
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }




    //public ListNode sortList(ListNode head) {
    //    if (head == null || head.next == null) {
    //        return head;
    //    }
    //    ListNode sortedList = head;
    //    ListNode cur = head.next;
    //    head.next = null;
    //    while (cur != null) {
    //        ListNode unsortedList = cur.next;
    //        cur.next = null; // 将cur单独抽取出来
    //        if (cur.val < sortedList.val) { // 当前节点val小于head.val
    //            cur.next = sortedList;
    //            sortedList = cur;
    //        } else {
    //            ListNode pre = sortedList;
    //            while (pre.next != null && pre.next.val <= cur.val) {
    //                pre = pre.next;
    //            }
    //            cur.next = pre.next;
    //            pre.next = cur;
    //        }
    //        cur = unsortedList;
    //    }
    //    return sortedList;
    //}
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
