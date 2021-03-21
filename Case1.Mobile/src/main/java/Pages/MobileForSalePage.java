package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileForSalePage {

	public WebDriver driver;
	WebElement element;
	
	@FindBy(xpath="//button[@class='btn btn-white'][2]")
	WebElement clickFilterBar;
	
	@FindBy(xpath="//option[@value='izmir']")
	WebElement selectCity;
	
	@FindBy(xpath="//*[contains(text(),'İşyeri')]")
	WebElement selectCategory;
	
	/*
	@FindBy(xpath="//*[contains(text(), 'En Az')]")
	WebElement minPrice;
	
	@FindBy(xpath="//*[contains(text(),'En Çok')]")
	WebElement maxPricey;
    */
	
	@FindBy(xpath="//*[contains(text(),'Bina Yaşı Seçiniz')]")
	WebElement selectBuildingAgeBar;
	
	@FindBy(xpath="//*[contains(text(),'Sıfır Bina')]")
	WebElement selectBuildingAgeCheckBox;
	
	@FindBy(xpath="//*[contains(text(),'1-5')]")
	WebElement selectBuildingAgeCheckBox2;
	
	@FindBy(xpath="//*[contains(text(),'6-10')]")
	WebElement selectBuildingAgeCheckBox3;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div/div[1]/section[5]/section/div[2]/button")
	WebElement clickApplyBtn;
	
	@FindBy(xpath="//*[contains(text(),'Sonuçları Göster')]")
	WebElement clickResultsBtn;
	
	@FindBy(xpath="//div[@class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-android']")
    WebElement checkFilterBar;
	
	
	public MobileForSalePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public MobileForSalePage click_FilterBar() throws InterruptedException
	{
		Thread.sleep(5000);
		clickFilterBar.click();
		return this;
	}
	
	public MobileForSalePage select_City() throws InterruptedException
	{
		Thread.sleep(5000);
		selectCity.click();
		return this;
	}
	
	public MobileForSalePage select_County() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//section[@class='select-content']")).click();
		driver.findElement(By.xpath("//input[@class='district-search']")).sendKeys("Bornova");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-red filter-close']")).click();
		return this;
	}
	
	public MobileForSalePage select_Category()
	{
		selectCategory.click();
		return this;
	}
	
	/* ---> I have tried to locate these elements over and over again by using 
	 * different types of variations but could not manage to do it, I have tried to use all types of waits but 
	 * they also didnt work so I had to skip this part !
	 
	public MobileForSalePage select_Prices(String min, String max) throws InterruptedException
	{
		Thread.sleep(3000);
		minPrice.sendKeys(min);
		maxPricey.sendKeys(max);
		return this;
	}
	*/
	
	public MobileForSalePage select_BuildingAge() throws InterruptedException
	{
		Thread.sleep(5000);
		selectBuildingAgeBar.click();
		selectBuildingAgeCheckBox.click();
		Thread.sleep(2000);
		selectBuildingAgeCheckBox2.click();
		Thread.sleep(2000);
		selectBuildingAgeCheckBox3.click();
		Thread.sleep(2000);
		clickApplyBtn.click();		
		return this;
	}
	
	public WebElement verify_Filters() throws InterruptedException
	{
		Thread.sleep(3000);
		return checkFilterBar;
	}
	
	public MobileForSalePage select_Results() throws InterruptedException
	{
		Thread.sleep(3000);
		clickResultsBtn.click();
		return this;
	}
	
}
