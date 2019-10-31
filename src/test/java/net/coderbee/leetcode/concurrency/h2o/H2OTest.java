package net.coderbee.leetcode.concurrency.h2o;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class H2OTest {
	private static List<String> comps = Arrays.asList("HHO", "HOH", "OHH");

	@Test
	public void test() throws InterruptedException {
		Assert.assertTrue(isValid(run("OOHHHH")));
		Assert.assertTrue(isValid(run("OHHHHO")));
	}

	private boolean isValid(String str) {
		for (int i = 0; i < str.length(); i = i + 3) {
			if (!comps.contains(str.substring(i, i + 3))) {
				return false;
			}
		}
		return true;
	}

	public String run(String str) throws InterruptedException {
		H2O h2o = new H2O();

		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		CountDownLatch latch = new CountDownLatch(chars.length);
		for (final char ch : chars) {
			new Thread(() -> {
				try {
					if (ch == 'H') {
						h2o.hydrogen(() -> {
							sb.append('H');
						});
					} else {
						h2o.oxygen(() -> {
							sb.append('O');
						});
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				latch.countDown();
			}).start();
		}
		boolean b = latch.await(5, TimeUnit.SECONDS);

		if (!b) {
			throw new IllegalArgumentException("timeout .");
		}

		System.out.println("\n" + sb);
		return sb.toString();
	}

}
