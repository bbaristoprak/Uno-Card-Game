package fileHandle;

import java.io.FileWriter;
import java.io.IOException;

public class GameLogger {

	/**
	 * writes the given message to logs.txt file to perform the logging
	 * @param message
	 */
	public static void log(String message) {
		try {
			FileWriter gameLogger = new FileWriter("logs.txt", true);
			gameLogger.write(message);
			gameLogger.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
