import sampleapp.RunAllTests;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RunAllTests runAll = new RunAllTests();
        runAll.setUp();
        runAll.runAllTests();
        runAll.closeBrowser();
    }
}
