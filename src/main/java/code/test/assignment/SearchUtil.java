package code.test.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchUtil {
	
	public static final Predicate<Path> isFile = path -> path.toFile().isFile();
	public static final Predicate<Path> isJSFile = path -> path.toString().endsWith(".js");
	public static final Predicate<Path> isTxtFile = path -> path.toString().endsWith(".txt");
	public static final Predicate<Path> isJsonFile = path -> path.toString().endsWith(".json");
	public static final Predicate<Path> isJavaFile = path -> path.toString().endsWith(".java");
	
	/**
	 * 
	 * To Get List of specific files (.js, .json & .java) from given directory and its child directory to to scan for search string i.e. TODO
	 * 
	 * @param searchDirectory - Directory and sub-directory to scan 
	 * @return List of Files path
	 */
	public static List<String> getAllFilesFromDirectory(String searchDirectory) {
		
		if (null == searchDirectory || searchDirectory.isEmpty()) {
			System.out.println("Please provide valid directory to search");
			return null;
		}
		
		Path dirPath = Paths.get(searchDirectory);
		
		if (!Files.exists(dirPath)) {
			System.out.println("Please provide valid directory to search");
			return null;
		}
		
		Stream<Path> stream = null;
		try {
			stream = Files.walk(dirPath, Integer.MAX_VALUE);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return stream.filter(isFile.and(isJSFile)
									.or(isJsonFile)
									.or(isJavaFile))
				.map(String::valueOf).sorted()
				.collect(Collectors.toList());
		
	}
	
	/**
	 * Method used for search the token in given files and return the found files with absolute path.
	 * 
	 * @param fileList - Files to process and scan for search 
	 * @param searchString - Token to search in the given files
	 * @return - return the found files.
	 */
	public static List<String> searchAndGetFilesUsingSearchString(List<String> fileList, String searchString) {
		
		if (null == fileList || fileList.isEmpty()) {
			System.out.println("Please provide valid file to search");
			return null;
		} else if (null == searchString || searchString.isEmpty()) {
			System.out.println("Please provide valid search string");
			return null;
		}
		
		List<String> searchFiles = new ArrayList<>();
		
		if (null != fileList && !fileList.isEmpty()) {
			
			fileList.forEach(absPath -> {

				Path path = Paths.get(absPath);
				
				try {
					Stream<String> lines = Files.lines(path);
					boolean isContentPresent = lines
							.filter(line -> line.contains(searchString))
							.findFirst()
							.isPresent();
					if (isContentPresent) {
						searchFiles.add(path.toAbsolutePath().toString());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			if (searchFiles.isEmpty()) {
				searchFiles.add("No matching file found for Search string : " + searchString);
			}
		}
		
		return searchFiles;
	}

}
