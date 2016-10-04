package testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.b2w.suite.B2WTestSuite;

public class TestSuite extends B2WTestSuite {
	public static String[] testList;

	public TestSuite(String fileName) {
		super();
		File testList = new File(fileName);
		if (!testList.exists()) {
			// If the file is not found look in home dir
			System.out.println("File not found using " + fileName + ", looking in home dir");
			String fileLoc = System.getenv("UserProfile") + "//MRL.tests";
			testList = new File(fileLoc);
		}
		List<String> testNames = new ArrayList<String>(20);
		String[] tests = { "" };
		try {
			FileReader in = new FileReader(testList);
			BufferedReader read = new BufferedReader(in);
			String line = null;
			while ((line = read.readLine()) != null) {
				testNames.add(line.trim());
			}
			read.close();
			tests = testNames.toArray(tests);
			TestSuite.testList = tests;
			this.addToTestList(TestSuite.testList);
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " was not found in ");// +
																// Platform.getUserHome());
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println("An IO Error Occured");
			System.out.println(e.toString());
		}
	}

	@Override
	public void testMain() throws Throwable {
		// Nothing to do here
	}

	@Override
	public String getCategory() {
		return "Suite Runner";
	}

	@Override
	public String getAuthor() {
		return "";
	}

	@Override
	public String getDataPath() {
		return "data";
	}

	@Override
	public boolean isSupported() {
		return false;
	}

}
