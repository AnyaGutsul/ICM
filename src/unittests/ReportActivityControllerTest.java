package unittests;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import reportActivity.CheckReportActivity;
import reportActivity.StubConnectionToServer;
import junit.framework.TestCase;

/** Client Testing*/
class ReportActivityControllerTest extends TestCase {

	private StubConnectionToServer stub = new StubConnectionToServer();
	private CheckReportActivity report;
	private ArrayList<String> arr;
	private ArrayList<String> arrForServer;
	private ArrayList<String> arrReturnedToClient;

	@BeforeEach
	protected void setUp() throws Exception {
		stub = new StubConnectionToServer();
		report = new CheckReportActivity(stub);
		arr = new ArrayList<>();
		arrForServer = new ArrayList<>();
		arrReturnedToClient = new ArrayList<>();
		arr.add("4");
		arr.add("2019-12-22 - 2019-12-28");
		arr.add("2019-12-29 - 2020-01-04");
		arr.add("2020-01-05 - 2020-01-11");
		arr.add("2020-01-12 - 2020-01-18");
		arr.add("1");
		arr.add("2");
		arr.add("3");
		arr.add("4");
		arr.add("5");
		arr.add("8.33f");
		arr.add("updated");
		stub.addArr(arr);
		arrForServer.add("79");
		arrForServer.add("Active");
		arrForServer.add("2019-12-22");
		arrForServer.add("2020-01-18");
	}

	/** Current Date Checker tests*/
	@Test
	void testCurrentDateCheckerSuccess() {
		boolean expected = true;
		assertEquals(expected, report.currentDateChecker("2020-01-20"));
	}

	@Test
	void testCurrentDateCheckerFail() {
		boolean expected = false;
		assertEquals(expected, report.currentDateChecker("2020-01-25"));
	}

	@Test
	void testCurrentDateCheckerNull() {
		boolean expected = false;
		try {
			assertEquals(expected, report.currentDateChecker(""));
		} catch (Exception e) {
		}
	}

	/**Check between two dates tests */
	@Test
	void testCheckBetweenTwoDatesSuccess() {
		boolean expected = true;
		assertEquals(expected, report.checkBetweenTwoDates("2020-01-20", "2020-01-24"));
	}

	@Test
	void testCheckBetweenTwoDatesFail() {
		boolean expected = false;
		assertEquals(expected, report.checkBetweenTwoDates("2020-01-24", "2020-01-20"));
	}

	@Test
	void testCheckBetweenTwoDatesFirstNull() {
		boolean expected = false;
		try {
			assertEquals(expected, report.checkBetweenTwoDates("", "2020-01-20"));
		} catch (Exception e) {
		}
	}

	@Test
	void testCheckBetweenTwoDateSecondNull() {
		boolean expected = false;
		try {
			assertEquals(expected, report.checkBetweenTwoDates("2020-01-24", ""));
		} catch (Exception e) {
		}
	}

	@Test
	void testCheckBetweenTwoDateBothNull() {
		boolean expected = false;
		try {
			assertEquals(expected, report.checkBetweenTwoDates("", ""));
		} catch (Exception e) {
		}
	}

	/**Data Returned from server tests*/
	@Test
	void testGetNumOfSubGroups() {
		String expected = "4";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getNumberOfSubGroups(arrReturnedToClient.get(0)));
	}

	@Test
	void testGetNameOfSubGroup1() {
		String expected = "2019-12-22 - 2019-12-28";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getNameOfSubGroup1(arrReturnedToClient.get(1)));
	}

	@Test
	void testGetQuantityOfSubGroup1() {
		String expected = "1";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getQuantityOfSubGroup1(arrReturnedToClient.get(5)));
	}

	@Test
	void testGetNameOfSubGroup2() {
		String expected = "2019-12-29 - 2020-01-04";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getNameOfSubGroup2(arrReturnedToClient.get(2)));
	}

	@Test
	void testGetQuantityOfSubGroup2() {
		String expected = "2";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getQuantityOfSubGroup2(arrReturnedToClient.get(6)));
	}

	@Test
	void testGetNameOfSubGroup3() {
		String expected = "2020-01-05 - 2020-01-11";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getNameOfSubGroup3(arrReturnedToClient.get(3)));
	}

	@Test
	void testGetQuantityOfSubGroup3() {
		String expected = "3";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getQuantityOfSubGroup3(arrReturnedToClient.get(7)));
	}

	@Test
	void testGetNameOfSubGroup4() {
		String expected = "2020-01-12 - 2020-01-18";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getNameOfSubGroup4(arrReturnedToClient.get(4)));
	}

	@Test
	void testGetQuantityOfSubGroup4() {
		String expected = "4";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getQuantityOfSubGroup4(arrReturnedToClient.get(8)));
	}

	@Test
	void testGetMedian() {
		String expected = "5";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getMedian(arrReturnedToClient.get(9)));
	}

	@Test
	void testGetStandardDeviation() {
		String expected = "8.33f";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getStandardDeviation(arrReturnedToClient.get(10)));
	}

	@Test
	void testSaveStatus() {
		String expected = "updated";
		arrReturnedToClient = stub.Query(arrForServer);
		assertEquals(expected, report.getStandardDeviation(arrReturnedToClient.get(11)));
	}
}