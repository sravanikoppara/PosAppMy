package pages;

import org.openqa.selenium.WebDriver;

public class PageBase {
	
		private WebDriver driver;
		
		public PageBase (WebDriver driver) {
			this.driver = driver;
		}
		
		/**
		 * Get the page title
		 * 
		 * @return
		 */
		public String getTitle() {
			return driver.getTitle();
		}
	}


