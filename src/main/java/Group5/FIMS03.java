package Group5;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Objects;

/**
 * Test Case for Edit Store Subcategory
 *
 * @author Jiayi
 *
 */

public class FIMS03 {

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
    public void FIMS0301_valid_edit_description() throws InterruptedException {

        // Expected Description
        String ExpectedDesc = RandomStringUtils.randomAlphanumeric(10);

        // Click "Edit" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[6]/a[1]/i")).click();
        Thread.sleep(1000);

        // Edit Description
        driver.findElement(By.xpath("//*[@id=\"sc_subcat_desc\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"sc_subcat_desc\"]")).sendKeys(ExpectedDesc);
        Thread.sleep(1000);

        // Click "Save" button
        driver.findElement(By.xpath("//*[@id=\"inputArea_footer\"]/div/button[2]")).click();
        Thread.sleep(3000);

        // Click "Ok" button
        driver.findElement(By.xpath("//*[@id=\"modalAlert\"]/div/div/div[3]/button")).click();
        Thread.sleep(3000);

        // Actual Description
        String ActualDesc = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[4]")).getText();
        Thread.sleep(1000);

        // Assert to verify if test case is successful
        Assert.assertEquals(ExpectedDesc, ActualDesc);
        Thread.sleep(1000);
    }

    @Test
    public void FIMS0302_valid_edit_status() throws InterruptedException {

        // Get original status
        String OriginalStatus = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[5]")).getText();
        Thread.sleep(1000);

        // Expected Status
        String ExpectedStatus = "empty";

        // Click "Edit" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[6]/a[1]/i")).click();
        Thread.sleep(1000);

        if (Objects.equals(OriginalStatus, "INACTIVE")){
            ExpectedStatus = "ACTIVE";
            driver.findElement(By.xpath("//*[@id=\"sc_status\"]/option[2]")).click();
            Thread.sleep(3000);
        }else if (Objects.equals(OriginalStatus, "ACTIVE")){
            ExpectedStatus = "INACTIVE";
            driver.findElement(By.xpath("//*[@id=\"sc_status\"]/option[3]")).click();
            Thread.sleep(3000);
        }

        // Click "Save" button
        driver.findElement(By.xpath("//*[@id=\"inputArea_footer\"]/div/button[2]")).click();
        Thread.sleep(3000);

        // Click "Ok" button
        By.xpath("//*[@id=\"modalAlert\"]/div/div/div[3]/button").findElement(driver).click();
        Thread.sleep(3000);

        // Actual Status
        String ActualStatus = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[5]")).getText();
        Thread.sleep(1000);

        // Assert to verify if test case is successful
        Assert.assertEquals(ExpectedStatus, ActualStatus);
        Thread.sleep(1000);
    }
    @Test
    public void FIMS0303_cancel_edit() throws InterruptedException {

        // Expected Description
        String ExpectedDesc = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[4]")).getText();
        Thread.sleep(1000);

        // Expected Status
        String ExpectedStatus = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[5]")).getText();
        Thread.sleep(1000);

        // Click "Edit" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[6]/a[1]/i")).click();
        Thread.sleep(3000);

        // Click "Cancel" button
        driver.findElement(By.xpath("//*[@id=\"inputArea_footer\"]/div/button[1]")).click();
        Thread.sleep(3000);

        // Actual Description
        String ActualDesc = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[4]")).getText();
        Thread.sleep(1000);

        // Actual Status
        String ActualStatus = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[5]")).getText();

        // Assert to verify if test case is successful
        Assert.assertEquals(ExpectedStatus, ActualStatus);
        Thread.sleep(1000);
        Assert.assertEquals(ExpectedDesc, ActualDesc);
        Thread.sleep(1000);
    }

    @Test
    public void FIMS0304_invalid_edit() throws InterruptedException {

        // Expected Message
        String ExpectedMessage = "Compulsory";
        Thread.sleep(1000);

        // Click "Edit" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[1]/td[6]/a[1]/i")).click();
        Thread.sleep(3000);

        // Click "X - Clear" button
        driver.findElement(By.xpath("//*[@id=\"inputArea_sc_status\"]/span/span[1]")).click();
        Thread.sleep(3000);

        // Click "Save" button
        driver.findElement(By.xpath("//*[@id=\"inputArea_footer\"]/div/button[2]")).click();
        Thread.sleep(3000);

        // Actual Message
        String ActualMessage = driver.findElement(By.xpath("//*[@id=\"inputArea_sc_status\"]/div")).getText();
        Thread.sleep(1000);

        // Assert to verify if test case is successful
        Assert.assertEquals(ExpectedMessage, ActualMessage);
        Thread.sleep(1000);
    }

    @After
    public void afterTest() throws InterruptedException{
        driver.close();
    }

}
