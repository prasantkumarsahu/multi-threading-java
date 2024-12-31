import methods.SetDaemon;

/**
 * Author: PRASANT
 * Date: 16/12/24
 */

public class Test {
	public static void main(String[] args) {
		SetDaemon t1 = new SetDaemon();
		t1.setDaemon(true);
		t1.start();

		System.out.println("Main end");
	}
}
