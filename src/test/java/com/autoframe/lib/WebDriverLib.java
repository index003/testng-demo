package com.autoframe.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverLib {

    private WebDriver webDriver = null;
    private String baseUrl = DataStore.D_URL;
    private String browser = DataStore.D_Browser;

    public void newSetup()


    {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\webDriver\\chromedriver_win32\\chromedriver.exe");

            webDriver = new ChromeDriver();

        }else if (browser.equalsIgnoreCase("ie")) {

            System.setProperty("webdriver.ie.driver", "D:\\webDriver\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
            webDriver = new InternetExplorerDriver();

        }else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "D:\\webDriver\\edgedriver_win64\\msedgedriver.exe");
            webDriver = new EdgeDriver();

        }else{
            System.setProperty("webdriver.firefox.bin", "D:\\webDriver\\firefoxdriver_win64\\geckodriver.exe");
            webDriver = new FirefoxDriver();
        }
        if (webDriver!=null)
        {
            webDriver.get(baseUrl);
            webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
        }
    }
    public void newTeardown(){

        webDriver.quit();

    }
    public By parseObject(String p_object) {
        String newObjecyt = null;

        if (p_object.startsWith(".//") || p_object.startsWith("//")) {
            return By.xpath(p_object);
        } else if ( p_object.startsWith("linkText=")) {
            newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
            return By.linkText(newObjecyt);
        } else if (p_object.startsWith("xpath=")) {
            newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
            return By.xpath(newObjecyt);
        } else if (p_object.startsWith("id=")) {
            newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
            return By.id(newObjecyt);
        } else if (p_object.startsWith("css=")) {
            newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
            return By.cssSelector(newObjecyt);
        } else if (p_object.startsWith("className=")) {
            newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
            return By.className(newObjecyt);
        } else if (p_object.startsWith("tagName=")) {
            newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
            return By.tagName(newObjecyt);
        } else if (p_object.startsWith("name=")) {
            newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
            return By.name(newObjecyt);
        } else if (p_object.startsWith("partialLinkText=")) {
            newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
            return By.name(newObjecyt);
        } else
            return null;

    }

    public void newClick(String p_id){
        webDriver.findElement(parseObject(p_id)).click();
    }

    public void sendKey(String p_id,String keys){
        webDriver.findElement(parseObject(p_id)).sendKeys(keys);
    }
}
