
package ca.sheridancollege.chieur.my_card_game;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author Ricky Chieu 2022/08/20
 */
public class ConsoleControllerTest {
	public ConsoleControllerTest() {}

	/**
	 * Test of promptPlayerAmount method, of class ConsoleController.
	 */
	@Test
	public void testPromptPlayerAmount() {
		System.out.println("promptPlayerAmount");
		int min = 2;
		int max = 4;
		ConsoleController instance = ConsoleController.getSingleton();
		int expResult = 0;
		int result = instance.promptPlayerAmount(min, max);
		assertEquals(expResult, result);
	}
}