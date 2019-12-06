package code.test.assignment;

import java.util.List;
import java.util.Scanner;

public class SerchTextFromDir {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("Please input a directory to read files");
			String directoryPath = scanner.nextLine();
			System.out.println("Please input a search string");
			String searchString = scanner.nextLine();
			List<String> fileList = SearchUtil.getAllFilesFromDirectory(directoryPath);
			fileList = SearchUtil.searchAndGetFilesUsingSearchString(fileList, searchString);
			fileList.stream().forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
