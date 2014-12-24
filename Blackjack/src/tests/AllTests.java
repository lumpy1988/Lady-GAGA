package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// run the tests
@RunWith(Suite.class)
@SuiteClasses({
	//the test cases to run
	AllTestsCard.class,
	AllTestsPlayer.class,
	AllTestsModel.class
})

public class AllTests {
	// nothing to see here, just a place holder
}