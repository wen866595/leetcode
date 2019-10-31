package net.coderbee.leetcode.concurrency.h2o;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {
	private ReentrantLock lock = new ReentrantLock();
	private Condition waitHydrogen = lock.newCondition();
	private Condition waitOxygen = lock.newCondition();

	private LinkedBlockingQueue<Runnable> hydrogenQueue = new LinkedBlockingQueue<>();
	private LinkedBlockingQueue<Runnable> oxygenQueue = new LinkedBlockingQueue<>();

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		// releaseHydrogen.run();
		hydrogenQueue.put(releaseHydrogen);

		lock.lock();
		try {
			do {
				if (!isDone() && oxygenQueue.size() < 1) {
					waitOxygen.await();
				}
				if (!isDone() && hydrogenQueue.size() < 1) {
					waitHydrogen.await();
				}

				if (canSuccess()) {
					break;
				}
				if (isDone()) {
					break;
				}
			} while (true);
		} finally {
			lock.unlock();
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		// releaseOxygen.run();
		oxygenQueue.put(releaseOxygen);

		lock.lock();
		try {
			do {
				if (!isDone() && hydrogenQueue.size() < 2) {
					waitHydrogen.await();
				}

				if (canSuccess()) {
					break;
				}
				if (isDone()) {
					break;
				}
			} while (true);
		} finally {
			lock.unlock();
		}
	}

	private boolean isDone() {
		return oxygenQueue.size() == 0 || hydrogenQueue.size() == 0;
	}

	private boolean canSuccess() throws InterruptedException {
		if (oxygenQueue.size() < 1 || hydrogenQueue.size() < 2) {
			return false;
		}

		oxygenQueue.take().run();
		hydrogenQueue.take().run();
		hydrogenQueue.take().run();
		// System.out.println("HHO");

		waitHydrogen.signalAll();
		waitOxygen.signalAll();

		return true;
	}

}
