package testCases;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public Logger logger;
    public static WebDriver driver;
    public static Properties prop = new Properties();    

    @BeforeClass(groups= {"Sanity","Regression","Master"})
    @Parameters({"browser"})
    
   
   
    public void setup(String st) throws IOException {

        logger = LogManager.getLogger(this.getClass());
        FileInputStream file=new FileInputStream(".//properties/property.properties");
        prop.load(file);
        if(prop.getProperty("env").equals("remote")) {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setPlatform(Platform.LINUX);
        cap.setBrowserName("firefox");
        
        driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
        }else if(prop.getProperty("env").equals("local")) {

        switch(st) {

        case "chrome":
            driver = new ChromeDriver();
            break;

        case "edge":
            driver = new EdgeDriver();
            break;

        case "firefox":
            driver = new FirefoxDriver();
            break;

        default:
            System.out.println("Invalid browser name");
            return;
        }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }


    @AfterClass(groups= {"Sanity","Regression","Master"})
    public void teardown() {
        driver.quit();
    }
    
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}