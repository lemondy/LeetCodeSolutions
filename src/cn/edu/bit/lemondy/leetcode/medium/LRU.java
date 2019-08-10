package cn.edu.bit.lemondy.leetcode.medium;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author zhang
 * @description 使用双向链表存放数据，LRU维护的就是双向链表中的数据；
 * 				使用hashMap来存放key，实现O（1）时间复杂度判断某个key是否已经存放在链中
 * @param <K>
 * @param <V>
 */
public class LRU<K, V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    private class Node {

        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }


    public LRU(int maxSize) {

        this.maxSize = maxSize;
        // HashMap 的负载因子是0.75， 3/4
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.pre = head;
    }


    public V get(K key) {

        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        unlink(node);
        appendHead(node);

        return node.v;
    }


    public void put(K key, V value) {
    	/**
    	 * 写入数据时，首先看改key是否已经在链表中
    	 * 1. 如果已经在链表中，那么就需要把该key移动到链表的head;
    	 * 2. 如果不在链中，那么需要将该元素插入链头
    	 * 
    	 * 插入完后需要判断当前的元素个数是否已经超过HashMap的最大值，是的话就需要删除链表最后一个元素
    	 */
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);

        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }


    private void unlink(Node node) {
    	// 将一个元素从链中断开
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }


    private void appendHead(Node node) {
        Node next = head.next;
        node.next = next;
        next.pre = node;
        node.pre = head;
        head.next = node;
    }


    private Node removeTail() {

        Node node = tail.pre;

        Node pre = node.pre;
        tail.pre = pre;
        pre.next = tail;

        node.pre = null;
        node.next = null;

        return node;
    }


    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {
            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }
}