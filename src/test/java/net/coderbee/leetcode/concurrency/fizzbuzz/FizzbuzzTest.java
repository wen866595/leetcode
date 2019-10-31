package net.coderbee.leetcode.concurrency.fizzbuzz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class FizzbuzzTest {

	@Test
	public void test() throws InterruptedException {
		assertTrue(Fizzbuzz.isFizzbuzz(15));
		assertTrue(Fizzbuzz.isFizz(3));
		assertTrue(Fizzbuzz.isBuzz(5));
		assertFalse(Fizzbuzz.isFizz(15));
		assertFalse(Fizzbuzz.isBuzz(15));

		testMain(new FizzbuzzBySemaphore(15));
		testMain(new FizzbuzzByQueue(15));
		testMain(new FizzbuzzByYield(15));
	}

	public void testMain(Fizzbuzz obj) throws InterruptedException {
		StringBuilder sb = new StringBuilder();
		CountDownLatch latch = new CountDownLatch(4);

		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.submit(() -> {
			try {
				obj.buzz(() -> {
					System.out.println("buzz");
					sb.append(", buzz");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			latch.countDown();
		});
		pool.submit(() -> {
			try {
				obj.fizz(() -> {
					System.out.println("fizz");
					sb.append(", fizz");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			latch.countDown();
		});
		pool.submit(() -> {
			try {
				obj.fizzbuzz(() -> {
					System.out.println("fizzbuzz");
					sb.append(", fizzbuzz");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			latch.countDown();
		});
		pool.submit(() -> {
			try {
				obj.number((int j) -> {
					System.out.println(j);
					sb.append(", " + j);
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			latch.countDown();
		});

		latch.await();

		System.err.println(sb.substring(2));
	}

}
