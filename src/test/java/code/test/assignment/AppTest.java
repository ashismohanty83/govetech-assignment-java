package code.test.assignment;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	static final String rootFolder = "./";
	final Predicate<String> isJSFile = path -> path.endsWith(".js");
	final Predicate<String> isJsonFile = path -> path.endsWith(".json");
	final Predicate<String> isJavaFile = path -> path.endsWith(".java");
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    /**
     * check the total no of files present of files type .json, .js & .java files
     */
    public void testgetNoOfFilesScanInTheDir() {
    	
    	int count = 11;
    	List<String> fileList = SearchUtil.getAllFilesFromDirectory(rootFolder);
    	assertEquals(count, fileList.size());
    }

    /**
     * check search operation only for  files type .json, .js & .java files
     */
    public void testGetScanFileListToSearchForSpecificFileType() {
    	
    	List<String> fileList = SearchUtil.getAllFilesFromDirectory(rootFolder);
    	boolean isOtherFileTypeExist = fileList.stream()
    			.filter((isJSFile.or(isJavaFile).or(isJsonFile)).negate())
    			.findFirst().isPresent();
        assertFalse( isOtherFileTypeExist );
    }
    
    /**
     * check if files /assignment/src/main/resource/subfolder/subfolder2/todo.js contains "TODO"
     */
    public void testCheckIfFilesContainsTODO() {
    	
    	List<String> fileList = new ArrayList<>();
    	fileList.add("./src/main/resource/subfolder/subfolder2/todo.js");
    	fileList = SearchUtil.getSearchedFiles(fileList, "TODO");
    	boolean isTodoJsFileExist = null != fileList && !fileList.isEmpty();
        assertTrue( isTodoJsFileExist );
    }
    
    /**
     * check if file src\main\resource\subfolder\subfolder1\todo-test.js does not contain "TODO"
     */
    public void testCheckIfFilesNotContainsTODO() {
    	
    	List<String> fileList = new ArrayList<>();
    	fileList.add("./src/main/resource/subfolder/subfolder1/todo-test.js");
    	fileList = SearchUtil.getSearchedFiles(fileList, "TODO");
    	boolean isTodoJsFileExist = null != fileList && fileList.isEmpty();
         assertFalse( isTodoJsFileExist );
    }
}
