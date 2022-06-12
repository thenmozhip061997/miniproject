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

public class Amazonautomation {

	
		

			public static void main(String[] args) throws InterruptedException {
				
		        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		        WebDriver driver=new ChromeDriver();
		        WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
		        driver.get("https://www.amazon.in/");
		        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		        //Thread.sleep(1000);
		        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
		        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		        driver.findElement(By.xpath("/html/body")).click();
		        driver.findElement(By.id("ap_email")).sendKeys("thenmozhip028@gmail.com");
		        driver.findElement(By.id("continue")).click();
		        driver.findElement(By.id("ap_password")).sendKeys("Thenmozhi");
		        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		        driver.findElement(By.id("signInSubmit")).click();
		        Thread.sleep(1000);
		        System.out.println(driver.findElement(By.xpath("//h4[@class='a-alert-heading']")).getText() );
		        driver.findElement(By.id("auth-fpp-link-bottom")).click();
		        int i=0;
		        while(i<4) {
		        driver.navigate().back();
		        i++;
		        }
		        driver.navigate().to("https://www.amazon.in/");
		        WebElement staticdropdown=driver.findElement(By.id("searchDropdownBox"));
		        Select dropdown=new Select(staticdropdown);
		        dropdown.selectByIndex(6);
		        System.out.println(dropdown.getFirstSelectedOption().getText());
		        
		       //otherwaya to select options 
		        
		       //dropdown.selectByVisibleText("Appliances");
		       //dropdown.selectByValue("search-alias=appliances");
		        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Refri");
		        Thread.sleep(1000);
		        List<WebElement> options =driver.findElements(By.cssSelector("div[class='autocomplete-results-container'] div"));
		        Thread.sleep(1000);
		        for(WebElement option : options) {
		        	if(option.getText().equalsIgnoreCase("refrigerator small")) {
		        		option.click();
		        		break;
		        	}
		        }
		        
		        
		        
		       

			}

		

	}


