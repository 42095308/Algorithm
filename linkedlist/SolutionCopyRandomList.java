package linkedlist;

public class SolutionCopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // 复制链表
        for (Node i = head; i != null; i = i.next.next) {
            Node newNode = new Node(i.val);
            newNode.next = i.next;
            i.next = newNode;
        }
        // 将新复制的节点的random进行赋值
        for (Node i = head; i != null; i = i.next.next) {
            Node rawRandom = i.random;
            if (rawRandom != null) {
                i.next.random = rawRandom.next;
            }
        }
        // 提取新复制的节点，并恢复原节点
        Node dummy = new Node(-1);
        Node i = head;
        Node curCopy = dummy;
        while (i != null) {
            // 获取下一个新节点
            Node nextOrigin = i.next.next;
            // 获取新复制的节点
            Node newNode = i.next;
            i.next = nextOrigin;
            curCopy.next = newNode;
            curCopy = curCopy.next;
            i = nextOrigin;
        }
        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
