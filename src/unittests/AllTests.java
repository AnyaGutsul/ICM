package unittests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Test;
import junit.framework.TestSuite;

/**All Tests Suite*/
@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		suite.addTestSuite(ReportActivityControllerTest.class);    /**Client Tests */
		suite.addTestSuite(ServerActivityReportTest.class);        /**Server Tests */ 
		return suite;
	}

}
