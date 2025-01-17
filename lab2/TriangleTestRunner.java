package lab2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TriangleTestRunner {
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";


	public static void main(String[] args) {		
		Result result = JUnitCore.runClasses(TriangleTest.class);
		System.out.println("Failed tests: " + result.getFailureCount());
		for (Failure failure : result.getFailures()) {
			System.out.println();
			System.out.println(ANSI_RED + failure.getTestHeader() + ANSI_RESET);
			System.out.println(failure.getException());
		}
	}

}
