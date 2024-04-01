package lcode; /**
 * @description: Leetcode_146 LRU缓存
 * 最近最少使用元素，查找插入修改时间复杂度都为O(1)。使用HashMap加上有序双向链表(即队列)的方式
 * 1、创建Node {key,value,prev,next,有参构造，无参构造}
 * 2、补充LRUCache构造方法,就是 初始化链表（head.next = tail; tail.prev = head;）
 * 3、补充put get方法，其中用到moveToHead,addToHead,removeTail等方法
 * 4、put: hashMap.get(key)，如果没有就添加，创建node对象，addToHead方法添加，并hashmap.put(key),并判断添加完后链表大小是否大于容量，大于则removeTail
 * 5、get: hashMap.get(key),有就return得到的value，没有就是return -1
 * 6、moveToHead: node.prev.next = node.next; node.next.prev = node.prev; node.prev = head; node.next = head.next; head.next.prev = node; head.next = node;
 * 7、addToHead: node.prev = head; node.next = head.next; head.next.prev = node; head.next = node;
 * 8、removeTail: tail.prev.prev.next = tail; tail.prev = tail.prev.prev;
 * @author: HammerRay
 * @date: 2024/3/22 下午8:35
 */

import java.util.HashMap;
import java.util.Map;
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        // hashMap ＋ 队列（双向链表） 一层hash包一层双向链表
        this.size = 0;
        this.capacity = capacity;
        // 伪头部和伪尾部
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果key存在，想通过hashmap定位，再移动到头部  hashmap与hashtable的关系是 前者是线程不安全的，后者安全的
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode result = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return result;
    }
}

