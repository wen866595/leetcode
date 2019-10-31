package net.coderbee.leetcode.concurrency.printzeroevenodd;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

import org.junit.Assert;
import org.junit.Test;

import net.coderbee.leetcode.concurrency.printzeroevenodd.PrintZeroEvenOdd;
import net.coderbee.leetcode.concurrency.printzeroevenodd.PrintZeroEvenOddBySynchronousQueue;

public class PrintZeroEvenOddTest {
	@Test
	public void test() throws InterruptedException {
		Assert.assertTrue("".equals(unit(new PrintZeroEvenOddBySynchronousQueue(0))));
		Assert.assertTrue("01".equals(unit(new PrintZeroEvenOddBySynchronousQueue(1))));
		Assert.assertTrue("0102030405".equals(unit(new PrintZeroEvenOddBySynchronousQueue(5))));
	}

	public String unit(PrintZeroEvenOdd alternately) throws InterruptedException {
		StringBuffer sb = new StringBuffer();

		IntConsumer intConsumer = new IntConsumer() {
			@Override
			public void accept(int value) {
				sb.append(value);
			}
		};

		List<Callable<Void>> tasks = Arrays.asList(() -> {
			try {
				alternately.zero(intConsumer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}, () -> {
			try {
				alternately.even(intConsumer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}, () -> {
			try {
				alternately.odd(intConsumer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		});

		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		threadPool.invokeAll(tasks);
		threadPool.shutdown();

		System.err.println(sb.toString());
		return sb.toString();
	}

}
