package test;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("iphone12");
		WebElement searchbtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbtn.click();
		
		List<WebElement> productname = new ArrayList<>(driver.findElements(By.xpath("//span[@class ='a-size-medium a-color-base a-text-normal']")));
		List<WebElement> productprice = new ArrayList<>(driver.findElements(By.xpath("//span[@class ='a-price-whole']")));
		
		System.out.println("Count of Iphone = " +productname.size());
		for (WebElement elm: productname )
		{
			System.out.println(elm.getText());
			}
		
		System.out.println("Count of prices= " +productprice.size());
		for (WebElement elm1: productprice)
		System.out.println("Prices are = " +elm1.getText());
		
		for(int i=0; i<productname.size();i++)
		{
			if (productname.get(i).getText().contains("Apple iPhone 1"))
			{
				System.out.println("Name of Product : " +productname.get(i).getText() + " Price =" +productprice.get(i).getText());
			}
		}
		
		}
	
	}