package TestScenarios;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.MobileForSalePage;
import Pages.MobileLandingPage;
import junit.framework.Assert;

public class MobileTest {
    WebDriver driver;
	
	@Test(priority=1)
	public void mobileTest() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Documents\\chromedriver.exe");
		
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Galaxy S5");
		
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities);
		driver.get("https://www.hurriyetemlak.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-red btn-large']"))).click();
	}
	
	@Test(priority=2)
	public void gotoForSalePage() throws InterruptedException
	{
		MobileLandingPage mlp = new MobileLandingPage(driver);
		MobileForSalePage mfsp = mlp.click_Satilik();
	}
	
	@Test(priority=3)
	public void gotoFilterSection() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		mfsp.click_FilterBar();
	}
	
	@Test(priority=4)
	public void selectCityPart() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		mfsp.select_City();
	}
	
	@Test(priority=5)
	public void selectCountyPart() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		mfsp.select_County();
	}
	
	@Test(priority=6)
	public void selectCategoryPart() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		mfsp.select_Category();
	}
	
	/*
	@Test(priority=7)
	public void selectPricesPart() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		mfsp.select_Prices("100000", "2000000");
	}
	*/
	
	@Test(priority=7)
	public void selectBuildingAge() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		mfsp.select_BuildingAge();
	}
	
	@Test(priority=8)
	public void verifyFilterBar() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		Assert.assertTrue(mfsp.verify_Filters().isDisplayed());
	}
	
	@Test(priority=9)
	public void selectResults() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		mfsp.select_Results();
	}
}
