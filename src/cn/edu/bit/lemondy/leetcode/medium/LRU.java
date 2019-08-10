package cn.edu.bit.lemondy.leetcode.medium;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author zhang
 * @description ʹ��˫�����������ݣ�LRUά���ľ���˫�������е����ݣ�
 * 				ʹ��hashMap�����key��ʵ��O��1��ʱ�临�Ӷ��ж�ĳ��key�Ƿ��Ѿ����������
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
        // HashMap �ĸ���������0.75�� 3/4
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
    	 * д������ʱ�����ȿ���key�Ƿ��Ѿ���������
    	 * 1. ����Ѿ��������У���ô����Ҫ�Ѹ�key�ƶ��������head;
    	 * 2. ����������У���ô��Ҫ����Ԫ�ز�����ͷ
    	 * 
    	 * ���������Ҫ�жϵ�ǰ��Ԫ�ظ����Ƿ��Ѿ�����HashMap�����ֵ���ǵĻ�����Ҫɾ���������һ��Ԫ��
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
    	// ��һ��Ԫ�ش����жϿ�
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