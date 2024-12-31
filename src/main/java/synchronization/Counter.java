package synchronization;

/**
 * Author: PRASANT
 * Date: 17/12/24
 */

public class Counter {
	private int count = 0;

//	type - 1 (using synchronized keyword)
	public synchronized void increment() {
		count++;
	}

//	type - 2 (using synchronized block)
//	public void increment() {
//		synchronized (this) {
//			count++;
//		}
//	}

	public int getCount() {
		return count;
	}
}
