package net.coderbee.leetcode.ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache extends InnerRUCache<Integer, Integer> {

	public LRUCache(int capacity) {
		super(capacity);
	}

	public int get(int key) {
		Integer io = super.get(key);
		if (io == null) {
			return -1;
		}
		return io;
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

}

class InnerRUCache<K, V> {
	Map<K, ListNode> map = new HashMap<>();
	final int capacity;
	int size = 0;
	ListNode head;
	ListNode tail;

	public InnerRUCache(int capacity) {
		this.capacity = capacity;
		head = new ListNode(null, null);
		tail = new ListNode(null, null);
		head.next = tail;
		tail.prev = head;
	}

	public V get(K key) {
		ListNode node = map.get(key);
		if (node == null) {
			return null;
		}
		dequeue(node);
		enqueue(node);
		return node.val;
	}

	public void put(K key, V value) {
		ListNode node = map.get(key);
		if (node == null) {
			if (size >= capacity) {
				ListNode h = head.next;
				dequeue(h);
				map.remove(h.key);
				size--;
			}
			node = new ListNode(key, value);
			map.put(key, node);
			enqueue(node);
			size++;
		} else {
			node.val = value;
			dequeue(node);
			enqueue(node);
		}
	}

	private void enqueue(ListNode node) {
		tail.prev.next = node;
		node.prev = tail.prev;
		node.next = tail;
		tail.prev = node;
	}

	private void dequeue(ListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
	}

	class ListNode {
		K key;
		V val;
		ListNode next;
		ListNode prev;

		public ListNode(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}

}