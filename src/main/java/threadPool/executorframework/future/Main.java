package threadPool.executorframework.future;

import java.util.concurrent.*;

/**
 * Author: PRASANT
 * Date: 31/12/24
 */

public class Main {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(() -> {
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				System.out.println("Exception occurred: " + e);
			}

			return 42;
		});
		Integer i = null;
		try {
//			System.out.println(future.isDone());
			i = future.get(1, TimeUnit.SECONDS);
			System.out.println(i);
		} catch (TimeoutException | InterruptedException | ExecutionException e) {
			System.out.println("Exception occurred: " + e);
		}
		executorService.shutdown();
	}
}
