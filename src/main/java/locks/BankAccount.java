package locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: PRASANT
 * Date: 18/12/24
 */

public class BankAccount {
	private int balance = 100;

	private final Lock lock = new ReentrantLock();

	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
		try {
			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				System.out.println(Thread.currentThread().getName() + " lock acquired");
				if(balance >= amount) {
					System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
					try {
						Thread.sleep(3000);
						balance -= amount;
						System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance : " + balance);
					} catch (Exception ex) {
						Thread.currentThread().interrupt();
					} finally {
						lock.unlock();
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " insufficient balance");
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " lock acquired failed, will try later.");
			}
		} catch (Exception ignore) {
			Thread.currentThread().interrupt();
		}
	}
}
