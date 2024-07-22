package utils;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
private static final int DEFAULT_WAIT_TIME = 10;
	
	/**
	 * Try to find an element in the page by xpath. If the element is not found,
	 * null is returned.
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public static WebElement findElement(WebDriver driver, String xpath) {
		try {
			return driver.findElement(By.xpath(xpath));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Try to find elements in the page by xpath. If the elements are not found,
	 * null is returned.
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public static List<WebElement> findElements(WebDriver driver, String xpath) {
		try {
			return driver.findElements(By.xpath(xpath));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Wait for an element to be visible on the screen, given a maximum time to wait
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(WebDriver driver, String xpath, int timeOutInSeconds) {
		//WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//alert
	public static Alert waitForAlert(WebDriver driver, int timeOutInSeconds) {
		//WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			return wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	/**
	 * Wait for an element to be visible on the screen, using the DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(WebDriver driver, String xpath) {
		return waitForElementToBeVisible(driver, xpath, DEFAULT_WAIT_TIME);
	}
	
	/**
	 * Wait for an element to be present in the DOM, given a maximum time to wait
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @return
	 */
	public static WebElement waitForElement(WebDriver driver, String xpath, int timeOutInSeconds) {
		//WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Wait for an element to be present in the DOM, using the DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public static WebElement waitForElement(WebDriver driver, String xpath) {
		return waitForElement(driver, xpath, DEFAULT_WAIT_TIME);
	}
	
	public static WebElement waitForCssElement(WebDriver driver, String cssSelector) {
		return waitForElement(driver, cssSelector, DEFAULT_WAIT_TIME);
	}
	/**
	 * Wait for at least one element to be present in the DOM, given a maximum time to wait
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @return
	 */
	public static List<WebElement> waitForElements(WebDriver driver, String xpath, int timeOutInSeconds) {
		//WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Wait for at least one element to be present in the DOM, using the DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public static List<WebElement> waitForElements(WebDriver driver, String xpath) {
		return waitForElements(driver, xpath, DEFAULT_WAIT_TIME);
	}
	
	/**
	 * Wait for an element to be clickable, given a maximum time to wait
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @return
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, String xpath, int timeOutInSeconds) {
		//WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Wait for an element to be clickable, using the DEFAULT_WAIT_TIME
	 * 
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public static WebElement waitForElementToBeClickable(WebDriver driver, String xpath) {
		return waitForElementToBeClickable(driver, xpath, DEFAULT_WAIT_TIME);
	}
	
	/**
	 * Wait for a certain condition to occur for up to DEFAULT_WAIT_TIME
	 * 
	 * Usage: waitUntil(driver, ExpectedConditions.elementToBeClickable(By.xpath("/input[@id='q']")))
	 * 
	 * @param condition
	 * @return
	 */
	public <T> T waitUntil(WebDriver driver, Function<? super WebDriver, T> condition) {
		return waitUntil(driver, condition, DEFAULT_WAIT_TIME);
	}
	
	/**
	 * Wait for a certain condition to occur for up to a given time in seconds
	 * 
	 * @param condition
	 * @param timeOutInSeconds
	 * @return
	 */
	public <T> T waitUntil(WebDriver driver, Function<? super WebDriver, T> condition, int timeOutInSeconds) {
		//WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(condition);
	}
	
	 // Method to scroll to an element and click it
	public static WebElement scrollToElementAndClick(WebDriver driver, String xpath, int timeOutInSeconds) {
    //public <T> T scrollToElementAndClick(WebDriver driver,  Function<? super WebDriver, T> condition, int timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            System.out.println("Clicked the element: " + xpath);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + xpath);
       
        }
		return null;
	}
	
	// Method to check if an element is displayed
    public static boolean isElementDisplayed(WebDriver driver, String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

