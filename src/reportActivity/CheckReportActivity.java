package reportActivity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import reportActivity.MyInterface;

public class CheckReportActivity {

	private MyInterface connect;

	public boolean currentDateChecker(String date2) {
		LocalDate date1 = LocalDate.parse(date2);

		if (date1.isAfter(LocalDate.now()))
			return false;
		return true;
	}

	public boolean checkBetweenTwoDates(String datetemp, String date3) {
		LocalDate date2 = LocalDate.parse(date3);
		LocalDate date1 = LocalDate.parse(datetemp);

		if (ChronoUnit.DAYS.between(date1, date2) > 0)
			return true;
		return false;
	}

	public CheckReportActivity(MyInterface stub) {
		connect = stub;
	}

	public String getNumberOfSubGroups(String number) {
		return number;
	}

	public String getNameOfSubGroup1(String name1) {
		return name1;
	}

	public String getQuantityOfSubGroup1(String quantity1) {
		return quantity1;
	}

	public String getNameOfSubGroup2(String name2) {
		return name2;
	}

	public String getQuantityOfSubGroup2(String quantity2) {
		return quantity2;
	}

	public String getNameOfSubGroup3(String name3) {
		return name3;
	}

	public String getQuantityOfSubGroup3(String quantity3) {
		return quantity3;
	}

	public String getNameOfSubGroup4(String name4) {
		return name4;
	}

	public String getQuantityOfSubGroup4(String quantity4) {
		return quantity4;
	}

	public String getMedian(String median) {
		return median;
	}

	public String getStandardDeviation(String deviation) {
		return deviation;
	}

	public String getSaveStatus(String saveStatus) {
		return saveStatus;
	}
}
