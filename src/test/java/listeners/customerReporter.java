package listeners;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

public class customerReporter implements IReporter {


    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println(" Generating Custom Report...");
        suites.forEach(suite -> {
            System.out.println("Suite: " + suite.getName());
            suite.getResults().forEach((key, result) -> {
                System.out.println("Test: " + result.getTestContext().getName());
                System.out.println("Passed: " + result.getTestContext().getPassedTests().size());
                System.out.println("Failed: " + result.getTestContext().getFailedTests().size());
                System.out.println("Skipped: " + result.getTestContext().getSkippedTests().size());
            });
        });
    }
}
