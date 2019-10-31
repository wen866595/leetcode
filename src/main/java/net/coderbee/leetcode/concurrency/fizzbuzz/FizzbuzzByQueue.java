package net.coderbee.leetcode.concurrency.fizzbuzz;

import java.util.concurrent.SynchronousQueue;
import java.util.function.IntConsumer;

public class FizzbuzzByQueue extends Fizzbuzz {
	private SynchronousQueue<Integer> fizzQueue = new SynchronousQueue<Integer>();
	private SynchronousQueue<Integer> buzzQueue = new SynchronousQueue<Integer>();
	private SynchronousQueue<Integer> fizzbuzzQueue = new SynchronousQueue<Integer>();

	public FizzbuzzByQueue(int n) {
		super(n);
	}

	@Override
	public void fizz(Runnable printFizz) throws InterruptedException {
		for (int i = 3; i <= n; i += 3) {
			if (isFizz(i)) {
				fizzQueue.take();
				printFizz.run();
				fizzQueue.put(0);
			}
		}
	}

	@Override
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (int i = 5; i <= n; i += 5) {
			if (isBuzz(i)) {
				buzzQueue.take();
				printBuzz.run();
				buzzQueue.put(0);
			}
		}
	}

	@Override
	public void fizzbuzz(Runnable printFizzbuzz) throws InterruptedException {
		for (int i = 15; i <= n; i += 15) {
			if (isFizzbuzz(i)) {
				fizzbuzzQueue.take();
				printFizzbuzz.run();
				fizzbuzzQueue.put(0);
			}
		}
	}

	@Override
	public void number(IntConsumer printInt) throws InterruptedException {
		// 作为主流程控制其他线程执行
		for (int i = 1; i <= n; i++) {
			if (isNumber(i)) {
				printInt.accept(i);
			} else {
				SynchronousQueue<Integer> targetQueue = getQueue(i);
				targetQueue.put(0); // 通知目标执行
				targetQueue.take(); // 等待目标执行完成
			}
		}
	}

	private SynchronousQueue<Integer> getQueue(int i) {
		if (isFizz(i)) {
			return fizzQueue;
		} else if (isBuzz(i)) {
			return buzzQueue;
		} else {
			return fizzbuzzQueue;
		}
	}

}
