package Group5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Test Case for Search Store Subcategory
 *
 * @author Jiayi
 *
 */

public class FIMS01 {

    static WebDriver driver;
    @Before
    public void beforeTest() throws InterruptedException{
        SetProperty driverC = new SetProperty();
        System.setProperty(driverC.getDriver(), driverC.getDriverProperty());
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://fimsclone.kerisi.my/");
        Thread.sleep(3000);

        // Input Email
        driver.findElement(By.xpath("//*[@id=\"userID\"]")).sendKeys("ENTRY2");
        Thread.sleep(1000);

        // Input Password
        driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("qwertyuiop");
        Thread.sleep(1000);

        // Click Login
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
        Thread.sleep(1000);

        // Click "Store" button
        driver.findElement(By.xpath("//*[@id=\"menu_id_1129\"]")).click();
        Thread.sleep(1000);

        // Click "Setup" button
        driver.findElement(By.xpath("//*[@id=\"menu_id_2172\"]")).click();
        Thread.sleep(1000);

        // Click "General" button
        driver.findElement(By.xpath("//*[@id=\"menu_id_2747\"]")).click();
        Thread.sleep(1000);

        // Click "Store Subcategory" button
        driver.findElement(By.xpath("//*[@id=\"menu_id_2459\"]")).click();
        Thread.sleep(1000);
    }
    @Test
    public void FIMS0101_valid_search() throws InterruptedException {

        // Enter Search bar
        driver.findElement(By.xpath("//*[@id=\"dt_store_category_filter\"]/label/input")).sendKeys("0006");
        Thread.sleep(3000);

        // Get Text From Page
        String ActualID = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr/td[3]/span")).getText();
        Thread.sleep(1000);

        // Expected Title
        String ExpectedID = "0006";
        Thread.sleep(1000);

        // Assert to verify if test case is successful
        Assert.assertEquals(ExpectedID, ActualID);
        Thread.sleep(1000);
    }

    @After
    public void afterTest() throws InterruptedException{
      driver.close();
  }

}