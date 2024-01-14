package Group5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;

/**
 * Test Case for Sort Store Subcategory
 *
 * @author Jiayi
 *
 */

public class FIMS02 {

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
    public void FIMS0201_sort_ascending() throws InterruptedException {

        // Click "Subcategory" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(1000);

        // Get displayed rows
        ArrayList<Integer> record = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            boolean rowExists = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[" + i + "]/td[1]")).isDisplayed();
            if (rowExists) {
                record.add(Integer.valueOf(driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[" + i + "]/td[1]")).getText()));
            }
        }

        // Check if records are sorted ascending
        boolean sorted = false;
        for (int i = 0; i < record.size()-1; i++) {
            if (record.get(i) < record.get(i+1)){
                sorted = true;
            }
        }

        // Assert to verify if test case is successful
        Assert.assertTrue(sorted);
    }

    @Test
    public void FIMS0202_sort_descending() throws InterruptedException {

        // Click "Subcategory" button
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/thead/tr/th[3]")).click();
        Thread.sleep(1000);

        // Get displayed rows
        ArrayList<Integer> record = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            boolean rowExists = driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[" + i + "]/td[3]")).isDisplayed();
            if (rowExists) {
                record.add(Integer.valueOf(driver.findElement(By.xpath("//*[@id=\"dt_store_category\"]/tbody/tr[" + i + "]/td[3]")).getText()));
            }
        }

        // Check if records are sorted ascending
        boolean sorted = false;
        for (int i = 0; i < record.size()-1; i++) {
            if (record.get(i) > record.get(i+1)){
                sorted = true;
            }
        }

        // Assert to verify if test case is successful
        Assert.assertTrue(sorted);
    }

    @After
    public void afterTest() throws InterruptedException{
        driver.close();
    }

}