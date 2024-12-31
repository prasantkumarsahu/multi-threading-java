package lambda;

/**
 * Author: PRASANT
 * Date: 26/12/24
 */

public class LambdaExpression {
	public static void main(String[] args) {
		Thread task1 = new Thread(() -> System.out.println("Hello World"));

		task1.start();
	}
}
