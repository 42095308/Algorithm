package linkedlist;

import java.util.HashMap;

public class LRUCache { // 使用map+双链表实现，或者直接使用库函数
    static class Node {
        int k;
        int v;
        Node pre;
        Node next;
        public Node () {}
        public Node(int k, int v, Node pre, Node next) {
            this.k = k;
            this.v = v;
            this.pre = pre;
            this.next = next;
        }

        public Node(int key, int value) {
            this.k = key;
            this.v = value;
        }
    }
    private int capacity;
    private int size;
    private HashMap<Integer, Node> cache = new HashMap<>();
    // 使用head tail（针对双向链表）可以减去判空操作
    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // 初始化：头指向尾，尾指向头
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node target = cache.get(key);
        if (target == null) return -1;
        // 将target节点从链表中删除
        removeNode(target);
        // 将target节点插入到链表头部
        insertToHead(target);
        return target.v;
    }
    public void put(int key, int value) {
        Node target = cache.get(key);
        if (target == null) {
            // 将新节点插入到头部
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                // 超出容量
                removeEndNode();
                size--;
            }
        } else {
            // target已经存在
            // 删除target
            removeNode(target);
            target.v = value;
            // 插入到头部
            insertToHead(target);
        }
    }

    private void removeEndNode() {
        Node endNode = tail.pre;
        cache.remove(endNode.k);
        endNode.pre.next = tail;
        tail.pre = endNode.pre;
        endNode.pre = null;
        endNode.next = null;
    }

    private void insertToHead(Node target) {
        target.next = head.next;
        target.next.pre = target;
        head.next = target;
        target.pre = head;
    }

    private void removeNode(Node target) {
        target.next.pre = target.pre;
        target.pre.next = target.next;
        target.next = null;
        target.pre = null;
    }


}
