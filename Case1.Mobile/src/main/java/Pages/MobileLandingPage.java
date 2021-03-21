package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileLandingPage {

	public WebDriver driver;
	WebElement element;
	
	@FindBy(linkText="Satılık")
	WebElement clickSatilik;
	
	public MobileLandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public MobileForSalePage click_Satilik() throws InterruptedException
	{
		MobileForSalePage mfsp = new MobileForSalePage(driver);
		Thread.sleep(3000);
		clickSatilik.click();
		return mfsp;
	}

}
