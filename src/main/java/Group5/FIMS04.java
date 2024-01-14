package Group5;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Test Case for Add New Store Subcategory
 *
 * @author Jiayi
 *
 */

public class FIMS04 {

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
        Thread.sleep(5000);
    }

    @Test
    public void FIMS0401_valid_add_inactive() throws InterruptedException {

        // Expected New Description
        String ExpectedDesc = RandomStringUtils.randomAlphanumeric(10);

        // Expected New Status
        String ExpectedStatus = "INACTIVE";

        // Click "+ New" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category_container\"]/div[3]/div[2]/span")).click();
        Thread.sleep(1000);

        // Input New Description
        driver.findElement(By.xpath("//*[@id=\"sc_subcat_desc\"]")).sendKeys(ExpectedDesc);
        Thread.sleep(1000);

        // Input New Status
        driver.findElement(By.xpath("//*[@id=\"sc_status\"]/option[3]")).click();
        Thread.sleep(1000);

        // Click "Save" button
        driver.findElement(By.xpath("//*[@id=\"inputArea_footer\"]/div/button[2]")).click();
        Thread.sleep(3000);

        // Click "Ok" button
        By.xpath("//*[@id=\"modalAlert\"]/div/div/div[3]/button").findElement(driver).click();
        Thread.sleep(3000);

        // Get actual data
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(3000);
        String ActualDesc = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[4]")).getText();
        Thread.sleep(1000);
        String ActualStatus = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[5]")).getText();
        Thread.sleep(1000);

        // Assert to verify if test case is successful
        Assert.assertEquals(ExpectedDesc, ActualDesc);
        Thread.sleep(1000);
        Assert.assertEquals(ExpectedStatus, ActualStatus);
        Thread.sleep(1000);
    }

    @Test
    public void FIMS0402_valid_add_active() throws InterruptedException {

        // Expected New Description
        String ExpectedDesc = RandomStringUtils.randomAlphanumeric(10);

        // Expected New Status
        String ExpectedStatus = "ACTIVE";

        // Click "+ New" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category_container\"]/div[3]/div[2]/span")).click();
        Thread.sleep(1000);

        // Input New Description
        driver.findElement(By.xpath("//*[@id=\"sc_subcat_desc\"]")).sendKeys(ExpectedDesc);
        Thread.sleep(1000);

        // Input New Status
        driver.findElement(By.xpath("//*[@id=\"sc_status\"]/option[2]")).click();
        Thread.sleep(1000);

        // Click "Save" button
        driver.findElement(By.xpath("//*[@id=\"inputArea_footer\"]/div/button[2]")).click();
        Thread.sleep(3000);

        // Click "Ok" button
        By.xpath("//*[@id=\"modalAlert\"]/div/div/div[3]/button").findElement(driver).click();
        Thread.sleep(3000);

        // Get actual data
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(3000);
        String ActualDesc = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[4]")).getText();
        Thread.sleep(1000);
        String ActualStatus = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[5]")).getText();
        Thread.sleep(1000);

        // Assert to verify if test case is successful
        Assert.assertEquals(ExpectedDesc, ActualDesc);
        Assert.assertEquals(ExpectedStatus, ActualStatus);
        Thread.sleep(1000);
    }
    @Test
    public void FIMS0403_cancel_add() throws InterruptedException {

        // Get previous last data
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(1000);

        String LastDesc = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[4]")).getText();
        Thread.sleep(1000);

        String LastStatus = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[5]")).getText();
        Thread.sleep(1000);

        // Click "+ New" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category_container\"]/div[3]/div[2]/span")).click();
        Thread.sleep(1000);

        // Input New Description
        driver.findElement(By.xpath("//*[@id=\"sc_subcat_desc\"]")).sendKeys("New Desc");
        Thread.sleep(1000);

        // Input New Status
        driver.findElement(By.xpath("//*[@id=\"sc_status\"]/option[2]")).click();
        Thread.sleep(1000);

        // Click "Cancel" button
        driver.findElement(By.xpath("//*[@id=\"inputArea_footer\"]/div/button[1]")).click();
        Thread.sleep(1000);

        // Get actual data
        String ActualDesc = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[4]")).getText();
        Thread.sleep(1000);
        String ActualStatus = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[5]")).getText();
        Thread.sleep(1000);

        // Assert to verify if test case is successful
        Assert.assertEquals(LastDesc, ActualDesc);
        Thread.sleep(1000);
        Assert.assertEquals(LastStatus, ActualStatus);
        Thread.sleep(1000);
    }

    @After
    public void afterTest() throws InterruptedException{
        driver.close();
    }

}
