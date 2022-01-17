package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomAct2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@Class=\"btn btn-primary\"]")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		String cw = windows.get(1);
		System.out.println(cw);
		driver.switchTo().window(cw);
		String title = driver.getTitle();
		System.out.println(title);
		driver.switchTo().window(parentWindow);
		driver.close();
		
		
		
		

	}

}
