package loginSignup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class UserOperations {
	public static HashMap<String, User> loginInfo = new HashMap<String, User>();

	/**
	 * Takes the userData.txt file and parses the information to create the users.
	 */
	public UserOperations() {
		try {
			File dataFile = new File("userData.txt");
			Scanner scanner = new Scanner(dataFile);
			while(scanner.hasNext()) {
				String dataLine = scanner.nextLine();
				String[] data = dataLine.split(" ");
				loginInfo.put(data[0], new User(data[0], data[1]));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("userData.txt file not found.");
		}
	}
	protected HashMap<String, User> getLogInfo() {
		return loginInfo;
	}
}
