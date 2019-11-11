package net.coderbee.interview.ds;

import java.util.Stack;

/**
 * 基于两个栈来实现队列。
 */
public class QueueOnStack<E> {

	private Stack<E> in = new Stack<>();
	private Stack<E> out = new Stack<>();

	public void enqueue(E e) {
		in.push(e);
	}

	public E dequeue() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				E e = in.pop();
				out.push(e);
			}
		}

		return out.pop();
	}

}
