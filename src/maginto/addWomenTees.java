package maginto;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class addWomenTees {
	WebDriver driver = new ChromeDriver();
	String webSite = "https://magento.softwaretestingboard.com/";
	
	Faker faker = new Faker();
	
	
	
	
	int radiantNumber = 1;
	String radiantNumberString = "1";
	int breatheNumber = 1;
	String breatheNumberString = "1";

	int argusNumber = 1;
	String argusNumberString = "1";



	int numberOfItemTobeAdded = 3;

	// this the price
	String RadinetPrice;
	String breathePrice;

	String argusPrice;


		
	Random rand = new Random();
	
	
	
	
	@BeforeTest
	public void mySetUp() {
		driver.get(webSite);
		driver.manage().window().maximize();
	
	}
	@Test(priority = 1)
	public void signUpProcess2() throws InterruptedException {
		
		
		WebElement createAcount = driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']"));
		createAcount.click();
		
		
		 String randomFirstName = faker.name().firstName();
	        String randomLastName = faker.name().lastName();
	        String randomEmail = faker.internet().emailAddress();
	        String randomPassword = faker.internet().password();
	   
	        
	        
	        
	        WebElement firstNameInput = driver.findElement(By.id("firstname"));
	        firstNameInput.sendKeys(randomFirstName);

	        WebElement lastNameInput = driver.findElement(By.id("lastname"));
	        lastNameInput.sendKeys(randomLastName);

	        WebElement emailInput = driver.findElement(By.id("email_address"));
	        emailInput.sendKeys(randomEmail);

	        WebElement passwordInput = driver.findElement(By.id("password"));
	        passwordInput.sendKeys("Ali"+randomPassword+"*");
		
	        WebElement confPass = driver.findElement(By.id("password-confirmation"));
	        confPass.sendKeys("Ali"+randomPassword+"*");
	        
	        WebElement createBtn = driver.findElement(By.xpath("//button[@title='Create an Account']"));
			createBtn.click();
			Thread.sleep(3000);
			 WebElement btnV = driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']"));
			 btnV.click();
				Thread.sleep(1000);
			 WebElement signOut = driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']"));
			 signOut.click();
			
			
			
			
			 driver.get("https://magento.softwaretestingboard.com/");
			Thread.sleep(2000);
			WebElement signIn = driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"));
			signIn.click();			
			
			WebElement emailLOgIn = driver.findElement(By.xpath("//input[@id='email']"));
			WebElement passwordLOgIn = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']"));
			emailLOgIn.sendKeys(randomEmail);
			passwordLOgIn.sendKeys("Ali"+randomPassword+"*");
			
			WebElement signInBtn = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']"));
			signInBtn.click();
			
			Thread.sleep(2000);
			
			 WebElement btnWoman = driver.findElement(By.xpath("//a[@id='ui-id-4']"));
			 btnWoman.click();
			 
		        WebElement teesSection = driver.findElement(By.xpath("//a[contains(text(),'Tees')]"));
		        teesSection.click();
			
		        
		        
		     
			/*	List<WebElement> liElements = driver.findElements(By.className("products-grid").tagName("ol"));

		       
		        if (liElements.size() <= 12) {
		           
		            for (int i = 0; i <liElements.size(); i++) {
		                WebElement liElement = liElements.get(i);

		            
		                System.out.println("Text of <li> element " + (i + 1) + ": " + liElement.getText());

		                liElement.click();
		            }
		            
		            
		        } else {
		            System.out.println("Less than 12 <li> elements found on the page.");
		        }    */

	}
		        
		        
		        @Test(priority = 2)
		    	public void AddItems() throws InterruptedException {
		    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    		String[] ItemPages = { "https://magento.softwaretestingboard.com/women/tops-women/tees-women.html",
		    				"https://magento.softwaretestingboard.com/desiree-fitness-tee.html",
		    				"https://magento.softwaretestingboard.com/gwyn-endurance-tee.html",
		    				"https://magento.softwaretestingboard.com/radiant-tee.html" };
		    				

		    		for (String ITEM : ItemPages) {
		    			driver.get(ITEM);

		    			Thread.sleep(5000);

		    			if (driver.getCurrentUrl().contains("fitness")) {
		    				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
		    				Quantity.clear();

		    				Quantity.sendKeys(radiantNumberString);

		    				WebElement ColorBox = driver
		    						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
		    				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
		    				int randomIndexForTheColor = rand.nextInt(0, colors.size());
		    				colors.get(randomIndexForTheColor).click();
		    				WebElement SizesBox = driver
		    						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
		    				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

		    				int randomindex = rand.nextInt(0, sizes.size());
		    				sizes.get(randomindex).click();

		    				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		    				AddtoCart.click();
		    				Thread.sleep(1000);

		    			} else if (driver.getCurrentUrl().contains("endurance")) {
		    				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
		    				Quantity.clear();

		    				Quantity.sendKeys(breatheNumberString);

		    				WebElement ColorBox = driver
		    						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
		    				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
		    				int randomIndexForTheColor = rand.nextInt(0, colors.size());
		    				colors.get(randomIndexForTheColor).click();

		    				WebElement SizesBox = driver
		    						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
		    				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

		    				int randomindex = rand.nextInt(0, sizes.size());
		    				sizes.get(randomindex).click();

		    				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		    				AddtoCart.click();
		    				Thread.sleep(1000);

		    			} else if (driver.getCurrentUrl().contains("radiant")) {

		    				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
		    				Quantity.clear();

		    				Quantity.sendKeys(argusNumberString);

		    				WebElement ColorBox = driver
		    						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
		    				List<WebElement> colors = ColorBox.findElements(By.tagName("div"));
		    				int randomIndexForTheColor = rand.nextInt(0, colors.size());
		    				colors.get(randomIndexForTheColor).click();

		    				WebElement SizesBox = driver
		    						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
		    				List<WebElement> sizes = SizesBox.findElements(By.tagName("div"));

		    				int randomindex = rand.nextInt(0, sizes.size());
		    				sizes.get(randomindex).click();

		    				WebElement AddtoCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		    				AddtoCart.click();
		    				Thread.sleep(1000);

		    			
		    		}

		    	}
		    		Thread.sleep(2000);
		    		
		    		String actualItems = driver.findElement(By.className("counter-number")).getText();
		    		System.out.println(actualItems);
		    		
		    		Assert.assertEquals(actualItems, "3");
		        
		        }
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
		        
			
			
			
	
	@Test(enabled=false)
	public void signUpProcess() {
		WebElement createAcount = driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']"));
		createAcount.click();
		
		
		WebElement fName = driver.findElement(By.id("firstname"));
		WebElement lName = driver.findElement(By.id("lastname"));
		WebElement email = driver.findElement(By.id("email_address"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement confPass = driver.findElement(By.id("password-confirmation"));
		
		
		fName.sendKeys("ali");
		lName.sendKeys("ahmad");
		email.sendKeys("ali2@gmail.com");
		pass.sendKeys("Ali20203020*");
		confPass.sendKeys("Ali20203020*");
		
		
		WebElement createBtn = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		createBtn.click();
		
		 WebElement womenSection = driver.findElement(By.xpath("//a[@id='ui-id-4']")); 
	        womenSection.click();
	        
	
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	 
	        
	        
	}
	@Test(enabled=false)
	public void logIn() {
		driver.get("https://magento.softwaretestingboard.com/");
		WebElement signIn = driver.findElement(By.xpath("//b]utton[@title='Create an Account'"));
		
		
		
	}

	@AfterTest
	public void closeWebsite() {
		
	}
	
	
}
