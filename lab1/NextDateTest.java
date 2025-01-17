package lab1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class NextDateTest {
	NextDate dateGenerator = new NextDate(01, 01, 2021);

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test //S1
	void testEndOfThirtyOneDayMonth() {
		int day = 31;
	  	int month = 01;
		int year = 1990;
		String expectedNextDate = "02/01/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S2
	void testMiddleOfThirtyOneDayMonth() {
		int day = 20;
		int month = 03;
		int year = 1990;
		String expectedNextDate = "03/21/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S3
	void testInvalidDate() {
		int day = 0;
		int month = 03;
		int year = 1990;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S4
	void testMiddleOfThirtyDayMonth() {
		int day = 20;
		int month = 04;
		int year = 1990;
		String expectedNextDate = "04/21/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S5
	void testEndOfThirtyDayMonth() {
		int day = 30;
		int month = 6;
		int year = 1990;
		String expectedNextDate = "07/01/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S6
	void testInvalidThirtyDayMonth() {
		int day = 31;
		int month = 9;
		int year = 1990;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S7
	void testMiddleOfDecember() {
		int day = 12;
		int month = 12;
		int year = 1990;
		String expectedNextDate = "12/13/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S8 -- expected to fail
	void testInvalidDecember() {
		int day = 32;
		int month = 12;
		int year = 1990;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S9
	void testInvalid2021December() {
		int day = 32;
		int month = 12;
		int year = 2021;
		String expectedNextDate = "Invalid Next Year";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S10
	void testMiddleOfFebruary() {
		int day = 02;
		int month = 02;
		int year = 1990;
		String expectedNextDate = "02/03/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S11
	void test28February() {
		int day = 28;
		int month = 02;
		int year = 1990;
		String expectedNextDate = "03/01/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S12
	void test29FebruaryLeapYear() {
		int day = 29;
		int month = 02;
		int year = 2004;
		String expectedNextDate = "03/01/2004";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S13
	void test29FebruaryNotLeapYear() {
		int day = 29;
		int month = 02;
		int year = 1900;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S14
	void testInvalidFebruary() {
		int day = 33;
		int month = 02;
		int year = 2001;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S15
	void test28FebruaryLeapYear() {
		int day = 28;
		int month = 02;
		int year = 2000;
		String expectedNextDate = "02/29/2000";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //S16
	void test28FebruaryNotLeapYear() {
		int day = 28;
		int month = 02;
		int year = 2001;
		String expectedNextDate = "03/01/2001";
		testDate(day, month, year, expectedNextDate);
	}
	
	
	////////////////// Just because-tests
	
	@Test //Just because
	void testInvalidThirtyOneDayMonth() {
		int day = 40;
		int month = 03;
		int year = 1990;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	
	////////////////// Predicate tests
	
	@Test //P1
	void testInvalidMonth() {
		int day = 10;
		int month = 0;
		int year = 1990;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //P2
	void testInvalidMonth2() {
		int day = 10;
		int month = 13;
		int year = 1990;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //P3
	void testInvalidYear() {
		int day = 10;
		int month = 11;
		int year = 1800;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //P4
	void testInvalidYear2() {
		int day = 10;
		int month = 11;
		int year = 2022;
		String expectedNextDate = "Invalid Input Date";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //P5
	void testMiddleOfAnotherThirtyOneDayMonth() {
		int day = 3;
		int month = 5;
		int year = 1990;
		String expectedNextDate = "05/04/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //P6
	void testMiddleOfAnotherThirtyOneDayMonth2() {
		int day = 3;
		int month = 8;
		int year = 1990;
		String expectedNextDate = "08/04/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //P7
	void testMiddleOfAnotherThirtyOneDayMonth3() {
		int day = 3;
		int month = 10;
		int year = 1990;
		String expectedNextDate = "10/04/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	
	@Test //P8
	void testMiddleOfAnotherThirtyDayMonth() {
		int day = 3;
		int month = 9;
		int year = 1990;
		String expectedNextDate = "09/04/1990";
		testDate(day, month, year, expectedNextDate);
	}

	@Test //P9
	void testMiddleOfAnotherThirtyDayMonth2() {
		int day = 3;
		int month = 11;
		int year = 1990;
		String expectedNextDate = "11/04/1990";
		testDate(day, month, year, expectedNextDate);
	}
	
	@Test //B1 or P10 idk
	void testJuly() {
		int day = 12;
		int month = 07;
		int year = 1990;
		String expectedNextDate = "13/12/1990";
		testDate(day, month, year, expectedNextDate);
	}

	

	private void testDate(int day, int month, int year, String expected) {
		String nextDay = dateGenerator.run(month, day, year);
		assertEquals(expected, nextDay);
	}

}
