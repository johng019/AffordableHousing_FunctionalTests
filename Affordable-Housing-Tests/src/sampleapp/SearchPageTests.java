package sampleapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SearchPageTests implements IGlobalConstants{
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {

        //set chromedriver path and initialize
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Specialty Shops #3\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        //set wait for response duration and delete cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();

        //open url and maximize window
        //driver.get(local);
        driver.get(site);
        Thread.sleep(2500);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyAddressRadioButtonReturnsAddressesToDropBox() throws InterruptedException {
        Thread.sleep(3000);

        //navigate to search page
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/ll-header/header/div/div/div[1]/ul/li[1]/a/span[1]")).click();
        Thread.sleep(2000);

        //click in address radio button
        driver.findElement(By.xpath("//*[@id=\"mat-radio-5\"]/label/span[1]/span[2]")).click();
        Thread.sleep(2000);

        //click in dropdown box
        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).click();
        Thread.sleep(2500);

        //click outside dropbox
        driver.findElement(By.className("container")).click();

        //validate element label matches expected value
        String a = driver.findElement(By.xpath("//*[@id=\"mat-radio-5\"]/label/span[2]")).getText();
        System.out.println(a + " list");
        assert(a.contains("Address"));
        Thread.sleep(2000);
    }

    @Test
    public void verifyAddressesInDropBoxFiltersWhenSelected() throws InterruptedException {
        Thread.sleep(3000);

        //navigate to search page
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/ll-header/header/div/div/div[1]/ul/li[1]/a/span[1]")).click();
        Thread.sleep(2000);

        //click in address radio button
        driver.findElement(By.xpath("//*[@id=\"mat-radio-5\"]/label/span[1]/span[2]")).click();
        Thread.sleep(2000);

        //click in dropdown box
        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).click();
        Thread.sleep(2500);

        //click 9405 Dowden Dr
        driver.findElement(By.xpath("/html/body/div/div/div/div/mat-option[4]")).click();
        Thread.sleep(3000);

        //click on property link
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[2]/div/div/mat-table/mat-row/mat-cell[1]/a")).click();
        Thread.sleep(4000);

        //get url and verify it matches expected url
        String expectedUrl = site + "products/4";
        String getUrl  = driver.getCurrentUrl();
        System.out.println(getUrl);
        Assert.assertEquals(expectedUrl ,getUrl);
    }

    @Test
    public void verifyNeighborhoodRadioButtonReturnsNeighborhoodsToDropBox() throws InterruptedException {
        Thread.sleep(3000);

        //navigate to search page
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/ll-header/header/div/div/div[1]/ul/li[1]/a/span[1]")).click();
        Thread.sleep(2000);

        //click in neighborhood radio button
        driver.findElement(By.xpath("//*[@id=\"mat-radio-6\"]/label/span[1]/span[2]")).click();
        Thread.sleep(2000);

        //click in dropdown box
        driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).click();
        Thread.sleep(2500);

        //click outside dropbox
        driver.findElement(By.className("container")).click();

        //validate element label matches expected value
        String n = driver.findElement(By.xpath("//*[@id=\"mat-radio-6\"]/label/span[2]")).getText();
        System.out.println(n + " list");
        assert(n.contains("Neighborhood"));
        Thread.sleep(2000);
    }

    @Test
    public void verifyNeighborhoodInDropboxFiltersWhenSelected() throws InterruptedException {
        Thread.sleep(3000);

        //navigate to search page
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/ll-header/header/div/div/div[1]/ul/li[1]/a/span[1]")).click();
        Thread.sleep(2000);

        //click in neighborhood radio button
        driver.findElement(By.xpath("//*[@id=\"mat-radio-6\"]/label/span[1]/span[2]")).click();
        Thread.sleep(2000);

        //click in dropdown box
        driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).click();
        Thread.sleep(2500);

        //Select College Park
        driver.findElement(By.xpath("/html/body/div/div/div/div/mat-option[17]")).click();
        Thread.sleep(3000);
    }

    @Test
    public void verifyEnergyRatingSearchCheckboxesAreSelectedAndDeselected() throws InterruptedException {
        Thread.sleep(2000);

        //navigate to search page
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/ll-header/header/div/div/div[1]/ul/li[1]/a/span[1]")).click();
        Thread.sleep(3000);

        // click on Energy Rating Search to open checkbox options
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/mat-tab-header/div/div/div/div[2]")).click();
        Thread.sleep(3000);

        //select checkboxes one at a time
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[1]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[2]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[3]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[4]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[5]/label/span[1]")).click();
        Thread.sleep(1000);

        //deselect checkboxes one at a time
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[5]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[4]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[3]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[2]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[2]/div/div[2]/mat-checkbox[1]/label/span[1]")).click();
        Thread.sleep(1000);
    }

    @Test
    public void verifyUtilityCostSearchCheckboxesAreSelectedAndDeselected() throws InterruptedException {
        Thread.sleep(2000);

        //navigate to search page
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/ll-header/header/div/div/div[1]/ul/li[1]/a/span[1]")).click();
        Thread.sleep(3000);

        // click on Energy Rating Search to open checkbox options
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/mat-tab-header/div/div/div/div[3]/div")).click();
        Thread.sleep(3000);

        //select checkboxes one at a time
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[1]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[2]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[3]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[4]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[5]/label/span[1]")).click();
        Thread.sleep(1000);

        //deselect checkboxes one at a time
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[5]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[4]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[3]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[2]/label/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[1]/div/div/div/div/div/div[1]/mat-tab-group/div/mat-tab-body[3]/div/div[2]/mat-checkbox[1]/label/span[1]")).click();
        Thread.sleep(1000);
    }

    @Test
    public void verifyPropertyLinkRoutesToCorrectProductdetailsPage() throws InterruptedException {
        Thread.sleep(2000);

        //navigate to search page
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/ll-header/header/div/div/div[1]/ul/li[1]/a/span[1]")).click();
        Thread.sleep(3000);

        //click on property link
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-search-list/div[2]/div/div/mat-table/mat-row[2]/mat-cell[1]/a")).click();
        Thread.sleep(3000);

        //get url and verify it matches expected url
        String expectedUrl = site + "products/2";
        String getUrl  = driver.getCurrentUrl();
        System.out.println(getUrl);
        Assert.assertEquals(expectedUrl ,getUrl);
    }

    @Test
    public void verifyAutocompleteFunctionsInTextbox() throws InterruptedException {
        Thread.sleep(3000);

        //navigate to search page
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/ll-header/header/div/div/div[1]/ul/li[1]/a/span[1]")).click();
        Thread.sleep(2000);

        //click in dropdown box
        WebElement e = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
        e.sendKeys("B");
        Thread.sleep(1000);
        e.sendKeys("e");
        Thread.sleep(1000);
        e.sendKeys("n");
        Thread.sleep(4500);
        /*
        The user should see only results that contain the string "Ben"
        The user should only see map marker results for properties that contain the string "Ben"
        Observation of success only.No further action needed.
         */
    }

    //close browser
    @After
    public void closeBrowser(){
        driver.close();
    }
}
