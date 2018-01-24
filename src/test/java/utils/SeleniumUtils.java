package utils;

/**
 * Created by Katsiaryna_Skarzhyns on 1/24/2018.
 */
public class SeleniumUtils {

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ignored) {
		}
	}
}
