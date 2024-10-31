package setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Setup {
	public WebDriver driver; 
	
	@BeforeTest
	public void start () {
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://localhost:5174/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
            driver.quit();
        }
	}
		
}
