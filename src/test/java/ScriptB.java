import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScriptB {
    private WebElement menuElement;

    public static void main(String[] args){
        WebDriver driver = getDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.manage().window().maximize();

        Authorization(driver);
        Delay(2000);

        String[] menuNames = {
                "Заказы",
                "Каталог",
                "Клиенты",
                "Служба поддержки",
                "Статистика",
                "Modules",
                "Design",
                "Доставка",
                "Способ оплаты",
                "International",
                "Shop Parameters",
                "Конфигурация",
                "Dashboard"
        };

        for (int i = 0; i < menuNames.length; i++){
            WebElement menuElement = driver.findElement(By.xpath("//span[contains(text(),'" + menuNames[i] + "')]"));
            menuElement.click();
            Delay(2000);
            //getting Title of chapter
            WebElement menuTitle = driver.findElement(By.xpath("//h2[@class='title'] | //h2 [@class='page-title']"));
            String currentTitle = menuTitle.getText();
            System.out.println("Title name = " + currentTitle);

            driver.navigate().refresh();
            Delay(2000);

            WebElement menuTitleNew = driver.findElement(By.xpath("//h2[@class='title'] | //h2 [@class='page-title']"));
            String currentTitleNew = menuTitleNew.getText();
            System.out.println("old: "+currentTitle+" --- new: "+currentTitleNew);

            if (currentTitle.equals(currentTitleNew))
            {
            System.out.println("It's OK, we on right page");}
            else {
            System.out.println("Something gone wrong, titels not equal");}
        }

        // end of test
        driver.quit();
    }

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
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
