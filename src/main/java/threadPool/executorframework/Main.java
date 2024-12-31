package threadPool.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author: PRASANT
 * Date: 26/12/24
 */

public class Main {
	public static void main(String[] args) {
		ExecutorService executer = Executors.newFixedThreadPool(3);
		long startTime = System.currentTimeMillis();
		for (int i = 1; i < 10; i++) {
			int value = i;
			executer.submit(() -> System.out.println(factorial(value)));
		}
		executer.shutdown();
		try {
			while (!executer.awaitTermination(10, TimeUnit.MILLISECONDS)) {
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Completed in : " + (System.currentTimeMillis() - startTime));
	}

	private static int factorial(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignore) {

		}
		int fact = 1;
		for (int j = 2; j <= i; j++) {
			fact *= j;
		}

		return fact;
	}
}
