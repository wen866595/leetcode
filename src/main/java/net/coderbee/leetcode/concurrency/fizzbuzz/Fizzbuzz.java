package net.coderbee.leetcode.concurrency.fizzbuzz;

import java.util.function.IntConsumer;

public abstract class Fizzbuzz {
	protected final int n;
	protected volatile int index = 1;

	public Fizzbuzz(int n) {
		this.n = n;
	}

	public static boolean isMod(int i, int mod) {
		return ((int) (i / mod)) * mod == i;
	}

	public static boolean isFizz(int i) {
		return isMod(i, 3) && !isMod(i, 5);
	}

	public static boolean isBuzz(int i) {
		return !isMod(i, 3) && isMod(i, 5);
	}

	public static boolean isFizzbuzz(int i) {
		return isMod(i, 3) && isMod(i, 5);
	}

	public static boolean isNumber(int i) {
		return !isMod(i, 3) && !isMod(i, 5);
	}

	public abstract void fizz(Runnable printFizz) throws InterruptedException;

	public abstract void buzz(Runnable printBuzz) throws InterruptedException;

	public abstract void fizzbuzz(Runnable printFizzbuzz) throws InterruptedException;

	public abstract void number(IntConsumer printInt) throws InterruptedException;

}
