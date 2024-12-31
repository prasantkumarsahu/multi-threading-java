package methods;

/**
 * Author: PRASANT
 * Date: 17/12/24
 */

public class SetDaemon extends Thread{

	@Override
	public void run() {
		while (true) {
			System.out.println("Hello World!");
		}
	}

	public static void main(String[] args) {
		SetDaemon t1 = new SetDaemon();
		t1.setDaemon(true);
		t1.start();

		System.out.println("Main end");
	}
}
