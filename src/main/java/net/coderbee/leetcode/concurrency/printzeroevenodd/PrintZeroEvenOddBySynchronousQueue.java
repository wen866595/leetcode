package net.coderbee.leetcode.concurrency.printzeroevenodd;

import java.util.concurrent.SynchronousQueue;
import java.util.function.IntConsumer;

public class PrintZeroEvenOddBySynchronousQueue extends PrintZeroEvenOdd {
	private SynchronousQueue<Integer> evenQueue = new SynchronousQueue<Integer>();
	private SynchronousQueue<Integer> oddQueue = new SynchronousQueue<Integer>();

	public PrintZeroEvenOddBySynchronousQueue(int n) {
		super(n);
	}

	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			printNumber.accept(0);
			index++;
			SynchronousQueue<Integer> targetQueue = (index & 1) == 0 ? evenQueue : oddQueue;
			targetQueue.put(0);
			targetQueue.take();
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			evenQueue.take();
			printNumber.accept(i);
			evenQueue.put(0);
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			oddQueue.take();
			printNumber.accept(i);
			oddQueue.put(0);
		}
	}

}
