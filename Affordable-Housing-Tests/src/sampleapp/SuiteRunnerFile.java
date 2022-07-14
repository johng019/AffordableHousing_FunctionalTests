package sampleapp;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({HomePageTests.class, SearchPageTests.class })

public class SuiteRunnerFile {
        public static void main(String args[])
        {
            Result result=JUnitCore.runClasses(HomePageTests.class, SearchPageTests.class);
            for (Failure failure : result.getFailures())
            {
                System.out.println(failure.toString());
            }
        }
}
