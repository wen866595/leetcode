package net.coderbee.leetcode.concurrency.fizzbuzz;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzbuzzBySemaphore extends Fizzbuzz {
	Semaphore fizzSemaphore = new Semaphore(0);
	Semaphore buzzSemaphore = new Semaphore(0);
	Semaphore fizzbuzzSemaphore = new Semaphore(0);
	Semaphore numberSemaphore = new Semaphore(1);

	public FizzbuzzBySemaphore(int n) {
		super(n);
	}

	@Override
	public void fizz(Runnable printFizz) throws InterruptedException {
		for (int i = 3; i <= n; i += 3) {
			if (isFizz(i)) {
				fizzSemaphore.acquire();
				printFizz.run();
				notifyNext();
			}
		}
	}

	@Override
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (int i = 5; i <= n; i += 5) {
			if (isBuzz(i)) {
				buzzSemaphore.acquire();
				printBuzz.run();
				notifyNext();
			}
		}

	}

	@Override
	public void fizzbuzz(Runnable printFizzbuzz) throws InterruptedException {
		for (int i = 15; i <= n; i += 15) {
			if (isFizzbuzz(i)) {
				fizzbuzzSemaphore.acquire();
				printFizzbuzz.run();
				notifyNext();
			}
		}
	}

	@Override
	public void number(IntConsumer printInt) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (isNumber(i)) {
				numberSemaphore.acquire();
				printInt.accept(i);
				notifyNext();
			}
		}
	}

	private void notifyNext() {
		index++;

		if (isNumber(index)) {
			numberSemaphore.release();
		} else if (isFizz(index)) {
			fizzSemaphore.release();
		} else if (isBuzz(index)) {
			buzzSemaphore.release();
		} else {
			fizzbuzzSemaphore.release();
		}
	}

}
