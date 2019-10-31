package net.coderbee.leetcode.concurrency.fizzbuzz;

import java.util.function.IntConsumer;

public class FizzbuzzByYield extends Fizzbuzz {
	public FizzbuzzByYield(int n) {
		super(n);
	}

	public void fizz(Runnable printFizz) throws InterruptedException {
		for (int i = 3; i <= n; i++) {
			if (isFizz(i)) {
				while (!isFizz(index)) {
					Thread.yield();
				}
				printFizz.run();
				index++;
			}
		}
	}

	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (int i = 5; i <= n; i++) {
			if (isBuzz(i)) {
				while (!isBuzz(index)) {
					Thread.yield();
				}
				printBuzz.run();
				index++;
			}
		}

	}

	public void fizzbuzz(Runnable printFizzbuzz) throws InterruptedException {
		for (int i = 15; i <= n; i++) {
			if (isFizzbuzz(i)) {
				while (!isFizzbuzz(index)) {
					Thread.yield();
				}
				printFizzbuzz.run();
				index++;
			}
		}
	}

	public void number(IntConsumer printInt) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (isNumber(i)) {
				while (!isNumber(index)) {
					Thread.yield();
				}
				printInt.accept(i);
				index++;
			}
		}
	}

}
