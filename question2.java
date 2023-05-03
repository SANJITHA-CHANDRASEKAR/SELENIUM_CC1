package cc1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class question2 {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		WebDriver drive = new EdgeDriver();
		drive.manage().window().maximize();
		
		drive.get("https://www.saucedemo.com/");
		drive.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		drive.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce",Keys.ENTER);
		Thread.sleep(5000);
		drive.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
		
		drive.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")).click();
		System.out.println("Filter: A-Z");
		System.out.println(drive.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div")).getText());
		
		drive.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).click();
		Thread.sleep(2000);
		System.out.println("\nFilter: Z-A");
		System.out.println(drive.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText());
		
		drive.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
		Thread.sleep(2000);
		System.out.println("\nFilter: Low to High");
		System.out.println(drive.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).getText());

		drive.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).click();
		Thread.sleep(2000);
		System.out.println("\nFilter: High to Low");
		System.out.println(drive.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div")).getText());

		drive.quit();
		
	}

}
