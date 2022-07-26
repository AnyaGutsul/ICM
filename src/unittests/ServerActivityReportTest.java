package unittests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import server.ActivityReport;
import server.IExtensionManager;
import server.StubExtensionManager;

/** Server Testing*/
class ServerActivityReportTest extends TestCase{

	ActivityReport fakeActivityReport;
	IExtensionManager fakeConn;

	@BeforeEach
	public void setUp() {
		fakeConn = new StubExtensionManager();
		fakeActivityReport = new ActivityReport(fakeConn);
	}

	/**Less than a week period success test*/
	@Test
	public void subgroupsNumberDaysTest() {
		long daysBetween = 5;
		assertEquals(ActivityReport.subgroupsNumberCalc(daysBetween), 5);
	}

	/**Less than a week period failure test*/
	@Test
	public void subgroupsNumberDaysFailureTest() {
		long daysBetween = 7;
		assertNotEquals(ActivityReport.subgroupsNumberCalc(daysBetween), 1);
	}

	/**Less than a month period success test*/
	@Test
	public void subgroupsNumberWeeksTest() {
		long daysBetween = 28;
		assertEquals(ActivityReport.subgroupsNumberCalc(daysBetween), 4);
	}

	/**Less than a month period failure test*/
	@Test
	public void subgroupsNumberWeeksFailureTest() {
		long daysBetween = 28;
		assertNotEquals(ActivityReport.subgroupsNumberCalc(daysBetween), 7);
	}

	/**Less than a year period success test*/
	@Test
	public void subgroupsNumberMonthsTest() {
		long daysBetween = 160;
		assertEquals(ActivityReport.subgroupsNumberCalc(daysBetween), 12);
	}
	
	/**Less than a month period failure test*/
	@Test
	public void subgroupsNumberMonthsFailureTest() {
		long daysBetween = 160;
		assertNotEquals(ActivityReport.subgroupsNumberCalc(daysBetween), 10);
	}

	/**median tests*/
	@Test
	public void MedianPositiveTest() { // positive answer correct
		int[] array = { 1, 2, 3, 4, 5, 6 };
		double median = 3.5;
		assertEquals(ActivityReport.MedianCalc(array), median);
	}

	@Test
	public void MedianNegativeTest() { // negative answer correct
		int[] array = { -1, -2, -3, -4, -5, -6 };
		double median = -3.5;
		assertEquals(ActivityReport.MedianCalc(array), median);
	}

	@Test
	public void MedianFailureTest1() { // positive answer but not correct
		int[] array = { 1, 2, 3, 4, 5, 6 };
		double median = 35;
		assertNotEquals(ActivityReport.MedianCalc(array), median);

	}

	@Test
	public void MedianFailureTest2() { // negative answer but not correct
		int[] array = { -1, -2, -3, -4, -5, -6 };
		double median = -35;
		assertNotEquals(ActivityReport.MedianCalc(array), median);
	}

	/**Standard Deviation tests*/
	@Test
	public void SDTest1() { // correct answer
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		double sd = 2.29128784747792;
		assertEquals(ActivityReport.StandardDeviationCalc(array), sd);
	}

	@Test
	public void SDTest2() { // wrong answer
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		double sd = 2.2;
		assertNotEquals(ActivityReport.StandardDeviationCalc(array), sd);
	}

	/**Frequency Distribution tests*/
	@Test
	public void FrequencyDistributionTest1() { // correct answer
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int daysbetween = 7;
		ArrayList<String> fd = new ArrayList<>();
		fd.add("1");
		fd.add("2");
		fd.add("3");
		fd.add("4");
		fd.add("5");
		fd.add("6");
		fd.add("7");
		assertEquals(ActivityReport.FrequencyDistributionCalc(array, daysbetween), fd);
	}

	@Test
	public void FrequencyDistributionTest2() { // wrong answer
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int daysbetween = 7;
		ArrayList<String> fd = new ArrayList<>();
		fd.add("7");
		fd.add("6");
		fd.add("5");
		fd.add("4");
		fd.add("3");
		fd.add("2");
		fd.add("1");
		assertNotEquals(ActivityReport.FrequencyDistributionCalc(array, daysbetween), fd);
	}

	/**Get Activity Report tests*/
	@SuppressWarnings("static-access")
	@Test
	public void getActivityReportTest1() { // correct answer
		String option = "Active";
		String date1 = "2020-01-01";
		String date2 = "2020-01-10";
		ArrayList<String> activityReport = new ArrayList<>();
		activityReport.add("5");
		activityReport.add("2020-01-01 - 2020-01-02");
		activityReport.add("2020-01-03 - 2020-01-04");
		activityReport.add("2020-01-05 - 2020-01-06");
		activityReport.add("2020-01-07 - 2020-01-08");
		activityReport.add("2020-01-09 - 2020-01-10");
		activityReport.add("3");
		activityReport.add("7");
		activityReport.add("11");
		activityReport.add("15");
		activityReport.add("9");
		activityReport.add("5.0");
		activityReport.add("2.581988897471611");
		activityReport.add("updated");

		assertEquals(fakeActivityReport.getActivityReport(option, date1, date2), activityReport);
	}

	@SuppressWarnings("static-access")
	@Test
	public void getActivityReportTest2() { // wrong answer
		String option = "Active";
		String date1 = "2020-01-01";
		String date2 = "2020-01-10";
		ArrayList<String> activityReport = new ArrayList<>();
		activityReport.add("10");
		activityReport.add("2020-01-01 - 2020-01-02");
		activityReport.add("2020-01-03 - 2020-01-04");
		activityReport.add("2020-01-05 - 2020-01-06");
		activityReport.add("2020-01-07 - 2020-01-08");
		activityReport.add("2020-01-09 - 2020-01-10");
		activityReport.add("3");
		activityReport.add("7");
		activityReport.add("11");
		activityReport.add("15");
		activityReport.add("9");
		activityReport.add("5.0");
		activityReport.add("2.581988897471611");
		activityReport.add("updated");

		assertNotEquals(fakeActivityReport.getActivityReport(option, date1, date2), activityReport);
	}

	/** Calculating the Active requests tests*/
	@Test
	public void countActiveRequestsInRangeTest1() { // correct answer

		String date1 = "2020-01-01";
		String date2 = "2020-01-04";
		int[] arrayExpected = { 1, 2, 3 };
		int[] arrayResult = fakeConn.countActiveRequestsInRange(date1, date2);

		for (int i = 0; i < arrayResult.length; i++)
			assertEquals(arrayResult[i], arrayExpected[i]);
	}

	@Test
	public void countActiveRequestsInRangeTest2() { // wrong answer

		String date1 = "2020-01-01";
		String date2 = "2020-01-04";
		int[] arrayExpected = { 6, 9, 5 };
		int[] arrayResult = fakeConn.countActiveRequestsInRange(date1, date2);

		for (int i = 0; i < arrayResult.length; i++)
			assertNotEquals(arrayResult[i], arrayExpected[i]);
	}

	/**Days between two dates calculation tests */
	@Test
	public void daysBetweenTest1() { // correct answer

		String date1 = "2020-01-01";
		String date2 = "2020-01-10";
		long daysbetweenExpected = 9;

		assertEquals(fakeConn.daysBetweenCalc(date1, date2), daysbetweenExpected);
	}

	@Test
	public void daysBetweenTest2() { // wrong answer

		String date1 = "2020-01-01";
		String date2 = "2020-01-10";
		long daysbetweenExpected = 1;

		assertNotEquals(fakeConn.daysBetweenCalc(date1, date2), daysbetweenExpected);
	}

	/**Saving the Report in Data Base Tests*/
	@Test
	public void saveActivityReportTest1() { // correct answer
		String option = "Active";
		String date1 = "2020-01-01";
		String date2 = "2020-01-10";
		int subgroupsNumber = 5;
		String subgroupsNamesDB;
		String frequencyDistributionDB;
		Double median = 5.0;
		Double SD = 2.581988897471611;

		ArrayList<String> subgroupsNamesDBarray = new ArrayList<>();
		subgroupsNamesDBarray.add("2020-01-01 - 2020-01-02");
		subgroupsNamesDBarray.add("2020-01-03 - 2020-01-04");
		subgroupsNamesDBarray.add("2020-01-05 - 2020-01-06");
		subgroupsNamesDBarray.add("2020-01-07 - 2020-01-08");
		subgroupsNamesDBarray.add("2020-01-09 - 2020-01-10");
		subgroupsNamesDB = subgroupsNamesDBarray.toString().substring(1, subgroupsNamesDBarray.toString().length() - 1);

		ArrayList<String> frequencyDistributionDBarray = new ArrayList<>();
		frequencyDistributionDBarray.add("3");
		frequencyDistributionDBarray.add("7");
		frequencyDistributionDBarray.add("11");
		frequencyDistributionDBarray.add("15");
		frequencyDistributionDBarray.add("9");
		frequencyDistributionDB = frequencyDistributionDBarray.toString().substring(1,
				frequencyDistributionDBarray.toString().length() - 1);

		String saveresult = "updated";

		assertEquals(fakeConn.saveActivityReport(option, date1, date2, subgroupsNumber, subgroupsNamesDB,
				frequencyDistributionDB, median, SD), saveresult);
	}

	@Test
	public void saveActivityReportTest2() { // wrong answer
		String option = "Active";
		String date1 = "2020-01-01";
		String date2 = "2020-01-10";
		int subgroupsNumber = 5;
		String subgroupsNamesDB;
		String frequencyDistributionDB;
		Double median = 5.0;
		Double SD = 2.581988897471611;

		ArrayList<String> subgroupsNamesDBarray = new ArrayList<>();
		subgroupsNamesDBarray.add("2020-01-01 - 2020-01-02");
		subgroupsNamesDBarray.add("2020-01-03 - 2020-01-04");
		subgroupsNamesDBarray.add("2020-01-05 - 2020-01-06");
		subgroupsNamesDBarray.add("2020-01-07 - 2020-01-08");
		subgroupsNamesDBarray.add("2020-01-09 - 2020-01-10");
		subgroupsNamesDB = subgroupsNamesDBarray.toString().substring(1, subgroupsNamesDBarray.toString().length() - 1);

		ArrayList<String> frequencyDistributionDBarray = new ArrayList<>();
		frequencyDistributionDBarray.add("3");
		frequencyDistributionDBarray.add("7");
		frequencyDistributionDBarray.add("11");
		frequencyDistributionDBarray.add("15");
		frequencyDistributionDBarray.add("9");
		frequencyDistributionDB = frequencyDistributionDBarray.toString().substring(1,
				frequencyDistributionDBarray.toString().length() - 1);

		String saveresult = "update failure";

		assertNotEquals(fakeConn.saveActivityReport(option, date1, date2, subgroupsNumber, subgroupsNamesDB,
				frequencyDistributionDB, median, SD), saveresult);
	}
}

