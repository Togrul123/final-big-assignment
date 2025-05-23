package suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    tests.LoginTest.class,
    tests.LogoutTest.class,
    tests.StaticPageTest.class,
    tests.ComplexXPathTest.class,
    tests.HistoryTest.class,
    tests.JavaScriptExecutorTest.class,
    tests.WebDriverConfigurationTest.class
})
public class AllTests {
    
}
