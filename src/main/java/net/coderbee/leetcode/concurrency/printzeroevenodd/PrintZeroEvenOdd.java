package net.coderbee.leetcode.concurrency.printzeroevenodd;

import java.util.function.IntConsumer;

public abstract class PrintZeroEvenOdd {
	protected int n;
	protected volatile int index = 0;

	public PrintZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public abstract void zero(IntConsumer printNumber) throws InterruptedException;

	public abstract void even(IntConsumer printNumber) throws InterruptedException;

	public abstract void odd(IntConsumer printNumber) throws InterruptedException;
}
