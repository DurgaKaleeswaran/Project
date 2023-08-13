package org.base;


	

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.junit.Assert;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

	
	public class Baseclasses {		
	public static WebDriver driver;
		
		public static WebDriver lanuchChrome() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			return driver;
		}
		
		public static void refresh() {
			driver.navigate().refresh();
		}
		public static void Launch(String url) {
			driver.get(url);
 			driver.manage().window().maximize();
		}
		
		public static void switchUrl() {
			String windowHandle = driver.getWindowHandle();
			
		}
		
		public static void swithNewUrl() {

			Set<String> windowHandles = driver.getWindowHandles();
			
			for (String allPage : windowHandles) {
				driver.switchTo().window(allPage);

			
			}
		}
		public static String readExcel(String file,String sh,int r,int c) throws IOException {
			File f=new File("C:\\Users\\durga\\eclipse-workspace\\Project\\Excel\\Bookq.xlsx"+file+".xlsx");
			FileInputStream fd=new FileInputStream(f);
			Workbook wb=new XSSFWorkbook(fd);
			Sheet sheet = wb.getSheet(sh);
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(c);
			CellType cellType = cell.getCellType();
			String value=null;
			
			if(cellType==cellType.STRING){
				 value = cell.getStringCellValue();
				
			}else {
				if(DateUtil.isCellDateFormatted(cell)) {
					Date Dcv = cell.getDateCellValue();
					SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
					value = sdf.format(Dcv);
				}else {
					double Ncv = cell.getNumericCellValue();
					long cv=(long)Ncv;
					value = String.valueOf(cv);
				}
			}
			return value;	
		}
		
		 
		public static void time(int a) {
			driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
		
		}
		
		
		public static void explicitWait(int a,WebElement e) {
			WebDriverWait wait=new WebDriverWait(driver, a);
			wait.until(ExpectedConditions.visibilityOf(e));
		
		}
		
		
		
		public static void setDriver(WebDriver driver) {
			Baseclasss.driver = driver;
		}
		public static WebDriver getDriver() {
			return driver;
		}
		public static void jsValue(WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", e);	
		} 
		
		public static void jsValues(WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false)", e);

		}
		
		public static void jsSet(String Value,WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAtrribute('value',"+Value+")", e);

		}
		
		public static void roUp() throws AWTException {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		public static void roDown() throws AWTException {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		public static void roPageDown() throws AWTException {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		public static void roPageUp() throws AWTException {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
		}
		public static Alert Ok() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return alert;
		}
		public static Alert alDismiss() {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			return alert;
		}
		public static void moveToElements(WebElement e) {
			Actions a=new Actions(driver);
			a.moveToElement(e).perform();
		}
		public static void clickTarget(WebElement e) {
			Actions a=new Actions(driver);
			a.click(e).perform();
		}
		public static void selectByIndex(WebElement e,int a) {
			Select s=new Select(e);
			s.selectByIndex(a);
		}
		public static void selectByText(WebElement e,String string) {
			Select s=new Select(e);
			s.selectByVisibleText(string);
		}
		
		
		
		public static String urlCurrrent() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
			
		}
		
		public static String title() {
			String title = driver.getTitle();
			return title;	
		}
		
		public static String text(WebElement e) {
			String text = e.getText();
			return text;
		}
		public static void sendKey(WebElement f,String value) {
			f.sendKeys(value);
		}
		public static void click(WebElement e) {
			e.click();
		}
		
		public static String valueAttribute(WebElement e) {
			String attribute = e.getAttribute("value");
			return attribute;	
		}
		public static String innerText(WebElement e) {
			String attribute = e.getAttribute("innerText");
			return attribute;
		}	
		public static boolean  getPageSources(String text) {
			boolean contains = driver.getPageSource().contains(text);
			if(contains) {
				System.out.println("Present");
			}
			else {
				System.out.println("Not Preent");
			}
			return contains;
		}	
		public static void  linkClick(String s) {
			driver.findElement(By.linkText(s)).click();
		}
		
		public static void  linkEnable(String s) {
			WebElement link = driver.findElement(By.linkText(s)); {
				if(link.isEnabled()) {
					System.out.println("Enabled");
				} else {
					System.out.println("Disabled");
				}
			}
		}
		
		
		
		public static void quit() {
			driver.quit();
		}
		

	}


