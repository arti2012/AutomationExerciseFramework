package stepdefinitions;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.Base;
import utils.Reporter;

public class Hooks extends Base {

    public static ExtentTest test;
    public static Reporter reporter = new Reporter();


    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests");
        reporter.generateReport("Automation exercise Report");

    }
    @Before
    public void before() {
        System.out.println("Before each test");
        openBrowser();
        test = reporter.createTest("Automation excercise Test");
    }

    @After
    public void after() {
        System.out.println("After each test");
        closeBrowser();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all tests");
        reporter.flushing();
    }
}
