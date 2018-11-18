import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptA {
    public static void main(String[] args)  {
        WebDriver driver = getDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        Authorization(driver);
        Delay(2000);

        WebElement inAvatarSmall = driver.findElement(By.id("employee_infos"));
        inAvatarSmall.click();

        WebElement inLogout = driver.findElement(By.id("header_logout"));
        inLogout.click();

        Delay(2000);

        driver.quit();
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources//chromedriver.exe");
        return new ChromeDriver();
    }

        public static void Delay(long ms){
            try{
                Thread.sleep(ms);
            }
            catch(InterruptedException e){
                System.out.println("thread interrupted");
            }
        }

        public static void Authorization(WebDriver currdriver)
        {
            // authorization
            WebElement emailInput = currdriver.findElement(By.id("email"));
            emailInput.sendKeys("webinar.test@gmail.com");

            WebElement passInput = currdriver.findElement(By.id("passwd"));
            passInput.sendKeys("Xcg7299bnSmMuRLp9ITw");

            WebElement inButton = currdriver.findElement(By.name("submitLogin"));
            inButton.click();
            // authorization complete
        }


}
