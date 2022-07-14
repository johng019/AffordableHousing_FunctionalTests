import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import sampleapp.HomePageTests;
import sampleapp.SearchPageTests;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Result result= JUnitCore.runClasses(HomePageTests.class, SearchPageTests.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
    }
}
