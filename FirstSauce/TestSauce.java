package FirstSauce;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSauce {
 static WebDriver driver;

    public static void setup() throws InterruptedException {
        driver= new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    public static  void login() throws InterruptedException {
        Thread.sleep( 2000);
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }
    public static void verify1(String locator,String expected){
        String actual = driver.findElement(By.xpath(locator)).getText();
        Assert.isTrue(actual.contains(expected),"Expected asmatch");
    }
    public static  void addToCart() throws InterruptedException {
        Thread.sleep( 2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

    }
    public static void verify2(String locator,String expected){
        String actual = driver.findElement(By.xpath(locator)).getText();
        Assert.isTrue(actual.contains(expected),"Expected asmatch");
    }


    public static void checkout() throws InterruptedException {
        Thread.sleep( 2000);
        driver.findElement(By.name("checkout")).click();

    }
    public static void cont() throws InterruptedException  {
        Thread.sleep( 2000);
        driver.findElement(By.id("first-name")).sendKeys("Muskan");
        driver.findElement(By.id("last-name")).sendKeys("Sharma");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
    }
    public static void overview() throws InterruptedException  {
        Thread.sleep( 2000);
        driver.findElement(By.id("finish")).click();
    }

    public static void backhome() throws InterruptedException  {
        Thread.sleep( 2000);
        driver.findElement(By.id("back-to-products")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        setup();
        login();
        verify1("//span[@class='title']","PRODUCTS");

        addToCart();
        verify1("//span[@class='title']","YOUR CART");
        checkout();
        cont();
        overview();
        backhome();
    }
}






