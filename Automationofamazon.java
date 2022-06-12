package selenium;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automationofamazon {
	

		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			//WebDriverWait w = new WebDriverWait(driver, Duration(30));
			WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(30));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(By.id("nav-link-accountList")).click();
			driver.findElement(By.id("ap_email")).sendKeys("thenmozhip028@gmail.com");
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys("Thenmozhi@028");
			driver.findElement(By.id("auth-signin-button")).click();
			// selection element in static dropdown
			
			WebElement staticdropdown = driver.findElement(By.id("searchDropdownBox"));
			w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("twotabsearchtextbox")));
			// Thread.sleep(1000);
			Select dropdown = new Select(staticdropdown);
			dropdown.selectByIndex(2);
			dropdown.getFirstSelectedOption().getText();
			// selectin element in dynamic dropdown
			// Thread.sleep(1000);
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ipho");
			Thread.sleep(1000);
			List<WebElement> options = driver
					.findElements(By.cssSelector("div[class='autocomplete-results-container'] div"));
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase("iphone 13")) {
					option.click();
					break;
				}
			}
			// Thread.sleep(1000);
			
			w.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//img[@alt='Apple iPhone 13 (128GB) - Midnight']")));
			driver.findElement(By.xpath("//img[@alt='Apple iPhone 13 (128GB) - Midnight']")).click();
			// Thread.sleep(3000);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-now-button")));
			driver.findElement(By.id("buy-now-button")).click();
			driver.findElement(By.cssSelector("div[class='a-fixed-left-grid']")).click();
			// Thread.sleep(3000);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-box pmts-instrument-box']")));
			driver.findElement(By.xpath("//div[@class='a-box pmts-instrument-box']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("740");

			driver.findElement(By.xpath("//span[@class='a-label a-checkbox-label']")).click();
			driver.findElement(By.xpath("//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")).click();
			// Thread.sleep(9000);
			// driver.findElement(By.id("prime-interstitial-nothanks-button")).click();
			// Thread.sleep(9000);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.id("placeYourOrder")));
			driver.findElement(By.id("placeYourOrder")).click();

			/*
			 * Set<String> windows=driver.getWindowHandles(); Iterator<String>
			 * it=windows.iterator(); String Parentwindow=it.next(); Thread.sleep(9000);
			 * String Childwindow=it.next(); driver.switchTo().window(Childwindow);
			 */
			// System.out.println(driver.findElement(By.id("buy-now-button")).getText());

			/*
			 * List<WebElement> products=driver.findElements(By.
			 * cssSelector("h2[class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"
			 * )); for(int i=0;i<products.size();i++) {
			 * 
			 * String[] itemname=products.get(i).getText().split("-"); String
			 * formatedname=itemname[1].trim();
			 * 
			 * 
			 * if(formatedname.contains("Starlight")) {
			 * 
			 * System.out.println(driver.findElement(By.
			 * xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText()
			 * );
			 * 
			 * }
			 * 
			 * }
			 */

		}

	}

