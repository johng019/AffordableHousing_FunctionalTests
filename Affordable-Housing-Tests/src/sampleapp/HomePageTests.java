package sampleapp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class HomePageTests implements GlobalConstatnts{
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
        driver.get(site);
        //driver.get(local);
        Thread.sleep(2500);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyAddressRadioButtonReturnsAddressesToDropBox() throws InterruptedException {

        //click in address radio button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mat-radio-2\"]/label/span[1]/span[2]")).click();

        //click in dropdown box
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"video-container\"]/div/div/div[2]/div[2]/div/form/mat-form-field")).click();

        //click outside dropbox
        Thread.sleep(2500);
        driver.findElement(By.className("container")).click();

        //validate element label matches expected value
        String a = driver.findElement(By.xpath("//*[@id=\"mat-radio-2\"]/label/span[2]")).getText();
        System.out.println(a + " list");
        assert(a.contains("Address"));
        Thread.sleep(2000);
    }

    @Test
    public void verifyNeighborhoodRadioButtonReturnsNeighborhoodsToDropBox() throws InterruptedException {

        //click in neighborhood radio button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mat-radio-3\"]/label/span[1]/span[2]")).click();

        //click in dropdown box
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"video-container\"]/div/div/div[2]/div[2]/div/form/mat-form-field")).click();

        //click outside dropbox
        Thread.sleep(2500);
        driver.findElement(By.className("container")).click();

        //validate element label matches expected value
        String n = driver.findElement(By.xpath("//*[@id=\"mat-radio-3\"]/label/span[2]")).getText();
        System.out.println(n + " list" );
        assert(n.contains("Neighborhood"));
        Thread.sleep(2000);
    }

    @Test
    public void verifyPropertyLinkRoutesToCorrectProductdetailsPage() throws InterruptedException {
        Thread.sleep(3000);

        //click on property link
        driver.findElement(By.xpath("/html/body/ll-root/ll-base-layout/div/mat-sidenav-container/mat-sidenav-content/main/ll-home/div[3]/div/div[2]/mat-table/mat-row[1]/mat-cell[1]/a")).click();
        Thread.sleep(3000);

        //get url and verify it matches expected url
        //String expectedUrl = "https://genuine-ganache-d769f7.netlify.app/products/1";
        //String expectedUrl = "http://localhost:4200/products/1";
        String expectedUrl = "https://genuine-ganache-d769f7.netlify.app/products/1";
        String getUrl  = driver.getCurrentUrl();
        System.out.println(getUrl);
        Assert.assertEquals(expectedUrl ,getUrl);
    }

    //close browser
    @After
    public void closeBrowser(){
        driver.close();
    }
}
