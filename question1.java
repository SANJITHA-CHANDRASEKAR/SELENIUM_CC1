package cc1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class question1 {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		WebDriver drive = new EdgeDriver();
		drive.manage().window().maximize();
		
		drive.get("https://www.saucedemo.com/");
		drive.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		drive.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce",Keys.ENTER);
		Thread.sleep(5000);
		
		drive.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		
		drive.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		String cart = drive.getCurrentUrl();
		if(cart.equals("https://www.saucedemo.com/cart.html"))
			System.out.println("The cart can be viewed");
		
		drive.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		Thread.sleep(2000);
		String check = drive.getCurrentUrl();
		if(check.equals("https://www.saucedemo.com/checkout-step-one.html"))
			System.out.println("Your Information page opened");
		
		drive.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("hello");
		drive.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("user");
		drive.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("123456");
		drive.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		String bill = drive.getCurrentUrl();
		if(bill.equals("https://www.saucedemo.com/checkout-step-two.html"))
			System.out.println("Product overview is displayed");
		System.out.println("Name of the product: "+drive.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());
		System.out.println("Price of the product: "+drive.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText());
		
		
		String url2 = drive.getCurrentUrl();
		if(url2.equals("https://www.saucedemo.com/checkout-step-two.html"))
			System.out.println("Url of the page is CORRECT!");
		else
			System.out.println("Url of the page is WRONG!");
		
		String title = drive.getTitle();
		if(title.equals("Swag Labs"))
			System.out.println("Title of the page is CORRECT!");
		else
			System.out.println("Title of the page is WRONG!");
		Thread.sleep(1000);
		drive.quit();
	}

}
