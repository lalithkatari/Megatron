package wrappers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;







import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

public class GenericWrappers {

	protected static RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;

	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch only firefox and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Babu - TestLeaf
	 * @param url - The url with http or https
	 * 
	 */
	public boolean invokeApp(String browser) {
		boolean bReturn = false;
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();		
			Reporter.reportStep("The browser:" + browser + " launched successfully", "PASS");
			bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterById(String idValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			Reporter.reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The data: "+data+" could not be entered in the field :"+idValue, "FAIL");
		}
		return bReturn;
	}
	
	/**
	 * Enter the value using the locator Id
	 * @author: Vasanthi
	 * @since 06 Feb 2016
	 * @param: locatorId - ID 
	 * @param: textValue - Value 
	 */
	public boolean enterByID(String locatorId,String textValue){
		boolean bReturn = false;		
		try {
			driver.findElement(By.id(locatorId)).clear();
			driver.findElement(By.id(locatorId)).sendKeys(textValue);
			Reporter.reportStep("Text '" + textValue + "' entered in Element with ID '" + locatorId + "'", "PASS"); 
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with id '" + locatorId + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * Enter the value using the locator name
	 * @author: Vasanthi
	 * @param: locatorName - Name 
	 * @param: textValue - Value 
	 */
	public boolean enterByName(String locatorName,String textValue){
		boolean bReturn = false;		
		try {
			driver.findElement(By.name(locatorName)).clear();
			driver.findElement(By.name(locatorName)).sendKeys(textValue);
			Reporter.reportStep("Text '" + textValue + "' entered in Element with Name '" + locatorName + "'", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			Reporter.reportStep("No element found with Name '" + locatorName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;	
	}	
	/**
	 * Enter the value using the locator Classname
	 * @author: Vasanthi
	 * @param: locatorClassName - ClassName 
	 * @param: textValue - Value
	 */
	public boolean enterByClassName(String locatorClassName,String textValue){
		boolean bReturn = false;
		try {
			driver.findElement(By.className(locatorClassName)).clear();
			driver.findElement(By.className(locatorClassName)).sendKeys(textValue);
			Reporter.reportStep("Text '" + textValue + "' entered in Element with ClassName '" + locatorClassName + "'", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			Reporter.reportStep("No Element found with ClassName '" + locatorClassName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
		
	}	
	/**
	 * Enter the value using the locator TagName
	 * @author: Vasanthi
	 * @param: locatorTagName - Tagname
	 * @param: textValue - Value
	 */	
	public boolean enterByTagName(String locatorTagName,String textValue){
		boolean bReturn = false;
		try {
			driver.findElement(By.tagName(locatorTagName)).clear();
			driver.findElement(By.tagName(locatorTagName)).sendKeys(textValue);
			Reporter.reportStep("Text '" + textValue + "' entered in Element with TagName '" + locatorTagName + "'", "PASS"); 
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No element foud with TagName '" + locatorTagName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}	
	/**
	 * Enter the value using the locator xpath
	 * @author: Vasanthi
	 * @param: locatorXpath - Xpath
	 * @param: textValue - Value
	 */		
	public boolean enterByXpath(String locatorXpath,String textValue){
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(locatorXpath)).clear();
			driver.findElement(By.xpath(locatorXpath)).sendKeys(textValue);
			Reporter.reportStep("Text '" + textValue + "' entered in Element with xPath '" + textValue + "'", "PASS"); 
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Element not found with xPath " + locatorXpath, "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}	
	/**
	 * Enter the value using the locator css
	 * @author: Vasanthi
	 * @param: locatorCss - Css
	 * @param: textValue - Value
	 */		
	public boolean enterByCss(String locatorCss,String textValue){
		boolean bReturn = false;
		try {
			driver.findElement(By.cssSelector(locatorCss)).clear();
			driver.findElement(By.cssSelector(locatorCss)).sendKeys(textValue);
			Reporter.reportStep("Text '" + textValue + "' entered in Element with css '" + textValue + "'", "PASS"); 
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Element not found with css " + locatorCss, "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}		

	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				Reporter.reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				Reporter.reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			Reporter.reportStep("The title did not match", "FAIL");
		}

		return bReturn;
	}
	/**
	 * Get page title
	 * @author Karthik
	 */		
	public String getTitle() {
		String sReturn = "";
		try {
			sReturn = driver.getTitle();
			Reporter.reportStep("Title of the page " + sReturn, "PASS");

		} catch (WebDriverException e) {
			Reporter.reportStep("Exception occured in get title " + sReturn, "FAIL");
		}
		return sReturn;
	}	
	/**
	 * Verify the text by locator name
	 * @author Karthik
	 * @param locatorName - name
	 * @param textValue - text to be verified
	 */	
	public boolean verifyTextByName(String locatorName, String textValue) {
		boolean bReturn = false;
		try {
			String verifyText = getTextByName(locatorName);
			if (verifyText.equals(textValue)) {
				Reporter.reportStep("The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are matched", "PASS");
				bReturn = true;
			} else {
				Reporter.reportStep("The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched", "FAIL");
				} 
		} catch (WebDriverException e) {
			Reporter.reportStep("Exception occured in verify text " + textValue + " using the locator name: " + locatorName, "FAIL");
			}
		return bReturn;
	}
	/**
	 * Verify the text by locator class name
	 * @author  Karthik
	 * @param locator - class name
	 * @param textValue - text to be verified
	 */	
	public boolean verifyTextByClassName(String locatorClassName, String textValue) {
		boolean bReturn = false;
		try {
			String verifyText = getTextByClassName(locatorClassName);
			if (verifyText.equals(textValue)) {
				Reporter.reportStep("The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are matched", "PASS");
				bReturn = true;
			} else {
				Reporter.reportStep("The expected text " +"\""+ textValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched", "FAIL");
				} 
		} catch (WebDriverException e) {
			Reporter.reportStep("Exception occured in verify text " + textValue + " using the locator class name: " + locatorClassName, "FAIL");
			
		}
		return bReturn;
	}
	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}


		return bReturn;
	}
	
	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextById(String id, String text){
		boolean bReturn = false;
		String sText = driver.findElementById(id).getText();
		if (driver.findElementById(id).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}


		return bReturn;
	}
	
	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextContainsByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}


		return bReturn;
	}

	/**
	 * This method will verify the given text
	 * @param id - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextContainsById(String id, String text){
		boolean bReturn = false;
		String sText = driver.findElementById(id).getText();
		if (driver.findElementById(id).getText().trim().contains(text)){
			Reporter.reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
		}


		return bReturn;
	}

	/**
	 * This method will close all the browsers
	 * @author Babu - TestLeaf
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Reporter.reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}

	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickById(String id) {
		boolean bReturn = false;
		try{
			driver.findElement(By.id(id)).click();
			Reporter.reportStep("The element with id: "+id+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByClassName(String classVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.className(classVal)).click();
			Reporter.reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByName(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.name(name)).click();
			Reporter.reportStep("The element with name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByLink(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.linkText(name)).click();
			Reporter.reportStep("The element with link name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			Reporter.reportStep("The element : "+xpathVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}
	
	/**
	 * Method to click using the locator linktext
	 * @author:	Reddy
	 * @param:	locatorPartialLinkText - PartialLinkText
	 */
	public boolean clickByPartialLinkText(String locatorPartialLinkText){
		boolean bReturn = false;
		try {
			driver.findElement(By.partialLinkText(locatorPartialLinkText)).click();
			Reporter.reportStep("Successfully clicked using the locator PartialLinktext " + locatorPartialLinkText, "PASS");
			bReturn = true;			
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed to click using the locator PartialLinktext " + locatorPartialLinkText, "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		} 
		return bReturn;
	}	
	/**
	 * Method to click using the locator tagname
	 * @author:	Reddy
	 * @param:	locatorTagName - locator
	 */
	public boolean clickByTagName(String locatorTagName){
		boolean bReturn = false;
		try {
			driver.findElement(By.tagName(locatorTagName)).click();
			Reporter.reportStep("Successfully clicked using the locator tagname " + locatorTagName, "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed to click using the locator tagname " + locatorTagName,"FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		} 
		return bReturn;
	}	
	/**
	 * Method to click using the locator css
	 * @author:Reddy
	 * @param:locatorCss - Css
	 */
	public boolean clickByCss(String locatorCss){
		boolean bReturn = false;
		try {
			driver.findElement(By.cssSelector(locatorCss)).click();
			Reporter.reportStep("Successfully clicked using the locator CSS " + locatorCss, "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed to click using the locator CSS " + locatorCss, "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		} 
		return bReturn;
	}	

	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will mouse over on the element using name as locator
	 * @param nameLocator  The name (locator) of the element to be moused over
	 * @author Karthik
	 */
	public boolean mouseOverByName(String nameLocator) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.name(nameLocator))).build().perform();
			Reporter.reportStep("The mouse over by name : "+nameLocator+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by name : "+nameLocator+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will mouse over on the element using className as locator
	 * @param classsName  The classsName (locator) of the element to be moused over
	 * @author Karthik
	 */
	public boolean mouseOverByClassName(String classsName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.className(classsName))).build().perform();
			Reporter.reportStep("The mouse over by classsName : "+classsName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by classsName : "+classsName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will mouse over on the element using partialLinkText as locator
	 * @param partialLinkName  The partialLinkText (locator) of the element to be moused over
	 * @author Karthik
	 */
	public boolean mouseOverByPartialLink(String partialLinkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.partialLinkText(partialLinkName))).build().perform();
			Reporter.reportStep("The mouse over by partialLinkText : "+partialLinkName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by partialLinkText : "+partialLinkName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will mouse over on the element using cssSelector as locator
	 * @param cssName  The cssSelector (locator) of the element to be moused over
	 * @author Karthik
	 */
	public boolean mouseOverByCSS(String cssName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssName))).build().perform();
			Reporter.reportStep("The mouse over by cssSelector : "+cssName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by cssSelector : "+cssName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			Reporter.reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * Get the text using the locator xpath
	 * @author: Kalai
	 * @param: locatorXpath - xpath
	 */	
	public String getTextByXpath(String xpathVal){
		String getText = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return getText; 
	}
	
	/**
	 * Get the text using the locator Id
	 * @author: Kalai
	 * @param: locatorId - id
	 */		
	public String getTextById(String locatorId) {
		String getText = "";
		try {
			getText = driver.findElement(By.id(locatorId)).getText();

		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed in get text using the locator '" + locatorId + "'", "FAIL");
		} catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return getText;		
	}	
	/**
	 * Get the text using the locator name
	 * @author: Kalai
	 * @param: locatorName - name
	 */		
	public String getTextByName(String locatorName) {
		String getText = "";
		try {
			getText = driver.findElement(By.name(locatorName)).getText();

		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed in get text using the locator '" + locatorName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return getText;		
	}	
	/**
	 * Get the text using the locator class name
	 * @author: Kalai
	 * @param: locatorclassName - Classname
	 */		
	public String getTextByClassName(String locatorclassName) {
		String getText = "";
		try {
			getText = driver.findElement(By.className(locatorclassName)).getText();

		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed in get text using the locator '" + locatorclassName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		} 
		return getText;		
	}	

	/**
	 * Get the text using the locator css
	 * @author: Kalai
	 * @param: locatorCss - CSS
	 */		
	public String getTextByCss(String locatorCss) {
		String getText = "";
		try {
			getText = driver.findElement(By.cssSelector(locatorCss)).getText();

		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed in get text using the locator '" + locatorCss + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		} 
		return getText;		
	}		
	/**
	 * Get the text using the locator link text
	 * @author: Kalai
	 * @param: locatorLinktext -Linktext
	 */		
	public String getTextByLinkText(String locatorLinktext) {
		String getText = "";
		try {
			getText = driver.findElement(By.linkText(locatorLinktext)).getText();

		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed in get text using the locator '" + locatorLinktext + "'", "FAIL");
		} catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return getText;		
	}		
	/**
	 * Get the text using the locator partial link text
	 * @author: Kalai
	 * @param: locatorPartialLinktext - PartialLinktext
	 */		
	public String getTextByPartialLinkText(String locatorPartialLinktext) {
		String getText = "";
		try {
			getText = driver.findElement(By.partialLinkText(locatorPartialLinktext)).getText();

		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed in get text using the locator '" + locatorPartialLinktext + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		} 
		return getText;		
	}	
	/**
	 * Get the text using the locator tag name
	 * @author: Kalai
	 * @param: locatorTagName - name
	 */		
	public String getTextByTagName(String locatorTagName) {
		String getText = "";
		try {
			getText = driver.findElement(By.tagName(locatorTagName)).getText();

		} catch (NoSuchElementException e) {
			Reporter.reportStep("Failed in get text using the locator '" + locatorTagName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return getText;		
	}	

	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Babu - TestLeaf
	 */
	public boolean selectById(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			Reporter.reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
		return bReturn;
	}
	

	/**
	 * Select Visible Text in a dropdown by Locator Name
	 * @param: locatorName - Name of the WebElement as String
	 * @param: dropdownVisibleText - Visible Text to be selected in dropdown as String
	 * @author: Srikumar
	 */
	public boolean selectVisibleTextByName(String locatorName, String dropdownVisibleText){
		boolean bReturn = false;
		try {
			WebElement dropDownWebElement = driver.findElement(By.name(locatorName));
			Select selectDropDown = new Select(dropDownWebElement);

			selectDropDown.selectByVisibleText(dropdownVisibleText);
			Reporter.reportStep("Visible Text '" + dropdownVisibleText + "' selected in dropdown with Name '" + locatorName + "'", "PASS" );
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with Name '" + locatorName + "'","FAIL" );
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;

	}	
	/**
	 * Select Visible Text in a dropdown by Locator Xpath
	 * @author: Srikumar
	 * @since 06 Feb 2016
	 * @param: locatorXpath - XPath of the WebElement as String
	 * @param: dropdownVisibleText - Visible Text to be selected in dropdown as String
	 */
	public boolean selectVisibleTextByXPath(String locatorXpath, String dropdownVisibleText){
		boolean bReturn = false;
		try {
			WebElement dropDownWebElement = driver.findElement(By.xpath(locatorXpath));
			Select selectDropDown = new Select(dropDownWebElement);

			selectDropDown.selectByVisibleText(dropdownVisibleText);
			Reporter.reportStep("Visible Text '" + dropdownVisibleText + "' selected in dropdown with XPath '" + locatorXpath + "'", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with XPath '" + locatorXpath + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.","FAIL");
		}
		return bReturn;
	}	
	/**
	 * Select Index in a dropdown by Locator ID
	 * @author: Srikumar
	 * @since 06 Feb 2016
	 * @param: locatorId - ID of the WebElement as String
	 * @param: dropDownIndex - Index to be selected in dropdown
	 */
	public boolean selectIndexById(String locatorId, int dropDownIndex){
		boolean bReturn = false;
		try {
			WebElement dropDownWebElement = driver.findElement(By.id(locatorId));
			Select selectDropDown = new Select(dropDownWebElement);

			selectDropDown.selectByIndex(dropDownIndex);
			Reporter.reportStep("Index '" + dropDownIndex + "' selected in dropdown with Id '" + locatorId + "'", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with ID '" + locatorId + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;

	}	
	/**
	 * Select Index in a dropdown by Locator Name
	 * @author: Srikumar	 * 
	 * @param: locatorName Name of the WebElement as String
	 * @param: dropDownIndex - Index to be selected in dropdown
	 */
	public boolean selectIndexByName(String locatorName, int dropDownIndex){
		boolean bReturn = false;
		try {
			WebElement dropDownWebElement = driver.findElement(By.name(locatorName));
			Select selectDropDown = new Select(dropDownWebElement);

			selectDropDown.selectByIndex(dropDownIndex);
			Reporter.reportStep("Index '" + dropDownIndex + "' selected in dropdown with Name '" + locatorName + "'","PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with Name '" + locatorName + "'", "FAIL" );
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}	
	/**
	 * Select Index in a dropdown by Locator XPath
	 * @author: Srikumar
	 * @param: locatorXpath - XPath of the WebElement as String
	 * @param: dropDownIndex Index to be selected in dropdown
	 */
	public boolean selectIndexByXpath(String locatorXpath, int dropDownIndex){
		boolean bReturn = false;
		try {
			WebElement dropDownWebElement = driver.findElement(By.xpath(locatorXpath));
			Select selectDropDown = new Select(dropDownWebElement);

			selectDropDown.selectByIndex(dropDownIndex);
			Reporter.reportStep("Index '" + dropDownIndex + "' selected in dropdown with XPath '" + locatorXpath + "'", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with XPath '" + locatorXpath + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;

	}	
	/**
	 * Select Value in a dropdown by Locator ID
	 * @author: Srikumar
	 * @param: locatorId - Id of the WebElement as String
	 * @param: dropDwonValue - Value to be selected in dropdown
	 */
	public boolean selectValueById(String locatorId, String dropDwonValue){
		boolean bReturn = false;
		try {
			WebElement dropDownWebElement = driver.findElement(By.id(locatorId));
			Select selectDropDown = new Select(dropDownWebElement);

			selectDropDown.selectByValue(dropDwonValue);
			Reporter.reportStep("Value '" + dropDwonValue + "' selected in dropdown with Id '" + locatorId + "'", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with id '" + locatorId + "'","FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;

	}

	/**
	 * Select Value in a dropdown by Locator Name
	 * @author: Srikumar
	 * @param: locatorName - Name of the WebElement as String
	 * @param: dropDwonValue - Value to be selected in dropdown
	 */
	public boolean selectValueByName(String locatorName, String dropDwonValue){
		boolean bReturn = false;
		try {
			WebElement dropDownWebElement = driver.findElement(By.name(locatorName));
			Select selectDropDown = new Select(dropDownWebElement);

			selectDropDown.selectByValue(dropDwonValue);
			Reporter.reportStep("Value '" + dropDwonValue + "' selected in dropdown with Name '" + locatorName + "'", "PASS" );
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with Name '" + locatorName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}
	/**
	 * Select Value in a dropdown by Locator XPath
	 * @author: Srikumar
	 * @param: locatorXpath - XPath of the WebElement as String
	 * @param: dropDwonValue - Value to be selected in dropdown
	 */
	public boolean selectValueByXpath(String locatorXpath, String dropDwonValue){
		boolean bReturn = false;
		try {
			WebElement dropDownWebElement = driver.findElement(By.xpath(locatorXpath));
			Select selectDropDown = new Select(dropDownWebElement);

			selectDropDown.selectByValue(dropDwonValue);
			Reporter.reportStep("Value '" + dropDwonValue + "' selected in dropdown with XPath '" + locatorXpath + "'", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("No Element found with XPath '" + locatorXpath + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}		
	
	/**
	 * Method to accept Alert
	 * @author: Karthik
	 * 
	 */
	public boolean acceptAlert(){
		boolean bReturn = false;
		try {
			driver.switchTo().alert().accept();
			bReturn = true;
		} catch (NoAlertPresentException e) {
			Reporter.reportStep("No Alert found", "FAIL");				
		}catch (Exception e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");			
		}
		return bReturn;
	}	
	/**
	 * Method to dismiss Alert
	 * @author: Karthik
	 * 
	 */
	public boolean dismissAlert(){
		boolean bReturn = false;
		try {
			driver.switchTo().alert().dismiss();
			bReturn = true;
		} catch (NoAlertPresentException e) {
			Reporter.reportStep("No Alert found", "FAIL");				
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}		
	/**
	 * Method to load object.propertie
	 * @author: Karthik
	 * 
	 */	
	public boolean loadObjects(){	
		boolean bReturn = false;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File("./object.properties")));
			bReturn = true;
		} catch (FileNotFoundException e) {
			Reporter.reportStep("File not found exception while loading object properties", "FAIL");
		}
		catch (IOException e) {
			Reporter.reportStep("IO exception while loading object properties", "FAIL");
		}
		return bReturn;
	}
	/**
	 * Method to navigate to given page url
	 * @param url The page URL
	 * @author: Karthik
	 * 
	 */	
	public boolean navigatePage(String url) {
		boolean bReturn = false;
		try {
			driver.navigate().to(url);
			Reporter.reportStep("The page navigated to " + url, "PASS");
			bReturn = true;
		} catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}	
	
	
	/**
	 * Switch to frame using the locator id
	 * @author: Anupam
	 * @param: locatorId -id
	 */	
	public boolean switchToFrameById(String locatorId){
		boolean bReturn = false;
		try {
			driver.switchTo().frame(locatorId);
			Reporter.reportStep("Switched to frame with id '" + locatorId + "'", "PASS"); 	
			bReturn = true;
		} catch (NoSuchFrameException e) {
			Reporter.reportStep("Frame not found with locator id '" + locatorId + "'", "FAIL");

		}catch (NoSuchElementException e) {
			Reporter.reportStep("Element not found with id '" + locatorId + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;

	}	
	/**
	 * Switch to frame using the locator name
	 * @author: Anupam
	 * @param: locatorName - name
	 */	
	public boolean switchToFrameByName(String locatorName){
		boolean bReturn = false;
		try {
			driver.switchTo().frame(locatorName);
			Reporter.reportStep("Switched to frame with name '" + locatorName + "'", "PASS"); 
			bReturn = true;
		} catch (NoSuchFrameException e) {
			Reporter.reportStep("Frame not found with locator name '" + locatorName + "'", "FAIL");

		}catch (NoSuchElementException e) {
			Reporter.reportStep("Element not found with name '" + locatorName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;

	}	

	/**
	 * Switch to frame using the class name
	 * @author: Anupam
	 * @param: locatorClassName - Classname
	 */	
	public boolean switchToFrameByClassName(String locatorClassName){
		boolean bReturn = false;
		try {
			driver.switchTo().frame(driver.findElement(By.className(locatorClassName)));
			Reporter.reportStep("Switched to frame with classname '" + locatorClassName + "'", "PASS"); 
			bReturn = true;
		} catch (NoSuchFrameException e) {
			Reporter.reportStep("Frame not found with locator class name '" + locatorClassName + "'", "FAIL");

		}catch (NoSuchElementException e) {
			Reporter.reportStep("Element not found with class name '" + locatorClassName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}		
	/**
	 * Switch to frame using the tag name
	 * @author: Anupam
	 * @param: locatorTagName - tagname
	 */	
	public boolean switchToFrameByTagName(String locatorTagName){
		boolean bReturn = false;
		try {
			driver.switchTo().frame(driver.findElement(By.tagName(locatorTagName)));
			Reporter.reportStep("Switched to frame with tagname '" + locatorTagName + "'", "PASS"); 
			bReturn = true;
		} catch (NoSuchFrameException e) {
			Reporter.reportStep("Frame not found with locator tag name '" + locatorTagName + "'", "FAIL");

		}catch (NoSuchElementException e) {
			Reporter.reportStep("Element not found with tag name '" + locatorTagName + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}	
	/**
	 * Switch to frame using the index
	 * @author: Anupam
	 * @param: locatorTagName - tagname
	 */	
	public boolean switchToFrameByIndex(int frameIndex){
		boolean bReturn = false;
		try {
			driver.switchTo().frame(frameIndex);
			Reporter.reportStep("Switched to frame with index '" + frameIndex + "'", "PASS"); 	
			bReturn = true;
		} catch (NoSuchFrameException e) {
			Reporter.reportStep("Frame not found with index '" + frameIndex + "'", "FAIL");
		}catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;

	}		
	/**
	 * Switch to default page
	 * @author: karthik
	 */	
	public boolean switchToDefaultContent(){
		boolean bReturn = false;
		try {
			driver.switchTo().defaultContent();
			Reporter.reportStep("Switched to default page", "PASS");
			bReturn = true;
		} catch (WebDriverException e) {
			Reporter.reportStep("The browser is not available for unknown reason.", "FAIL");
		}
		return bReturn;
	}	


}

