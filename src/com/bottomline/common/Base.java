package com.bottomline.common;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

//BASE CLASS CONTAINS ALL NECCESSARY AND REPETITIVE ACTIONS NEEDED TO INTERACT WITH ANY PAGE
public class Base extends BaseObject {

	WebDriver driver;

	// CTOR
	public Base(WebDriver driver) {
		this.driver = driver;
	}

	// region driver stuff
	protected String GetCurrentURL() {
		return driver.getCurrentUrl();
	}
	// end region driver stuff

	// region get
	protected String GetText(By by) {
		return by.findElement(driver).getText();
	}

	protected String GetText(WebElement element) {
		return element.getText();
	}

	protected String GetValue(By by) {
		return by.findElement(driver).getAttribute("value");
	}

	protected String GetValue(WebElement element) {
		return element.getAttribute("value");
	}

	// end region get

	// region wait

	protected boolean WaitForLoad(int timeout) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.presenceOfElementLocated(txLoader));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(txLoader));
			return true;
		} catch (TimeoutException e) {
			return false;
		}

	}

	protected boolean WaitForElement(WebElement element, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return true;
	}

	protected boolean WaitForElement(By by, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(by));

		return true;
	}

	protected boolean WaitForInvisibility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));

		return true;
	}

	protected boolean WaitForInvisibility(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

		return true;
	}

	protected boolean WaitForVisibility(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return true;
	}

	protected boolean WaitForVisibility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}

	@SuppressWarnings("deprecation")
	protected boolean WaitForText_Value(By by, String value) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		wait.withTimeout(2, TimeUnit.SECONDS);
		wait.pollingEvery(3, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.textToBePresentInElementValue(by, value));

	}

	@SuppressWarnings("deprecation")
	protected boolean WaitForText_Value(WebElement element, String value, int timeout) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		wait.withTimeout(5, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.textToBePresentInElementValue(element, value));
	}

	@SuppressWarnings("deprecation")
	protected boolean WaitForText_Text(By by, String value) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		wait.withTimeout(2, TimeUnit.SECONDS);
		wait.pollingEvery(3, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, value));

	}

	@SuppressWarnings("deprecation")
	protected boolean WaitForText_Text(WebElement element, String value, int timeout) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		wait.withTimeout(5, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.textToBePresentInElement(element, value));
	}
	// end region wait

	// region check for elements
	protected boolean CheckElementExist(WebElement element) {
		if (element != null) {

			return element.isDisplayed();

		} else {
			return false;
		}

	}

	protected boolean CheckElementExist(By by) {

		try {
			return driver.findElement(by).isDisplayed();

		} catch (NoSuchElementException e) {
			return false;
		}

	}
	// end region check for elements

	// region Actions

	protected boolean Clear(WebElement element) {
		element.clear();
		return true;
	}

	protected boolean Clear(By by) {
		driver.findElement(by).clear();
		return true;
	}

	protected boolean Click(WebElement element, int timeout) {
		try {
			WaitForElement(element, timeout);
			element.click();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	protected boolean Click(By by, int timeout) {
		try {
			WaitForElement(by, timeout);
			driver.findElement(by).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected Boolean Write(WebElement element, String value, int timeout) {
		WaitForElement(element, timeout);
		element.sendKeys(value);
		return true;
	}

	protected boolean Write(WebElement element, Keys key, int timeout) {
		WaitForElement(element, timeout);
		element.sendKeys(key);
		return true;
	}

	protected boolean Write(By by, Keys key, int timeout) {
		WaitForElement(by, timeout);
		driver.findElement(by).sendKeys(key);
		return true;
	}

	protected boolean Write(By by, String value, int timeout) {
		WaitForElement(by, timeout);
		driver.findElement(by).sendKeys(value);
		return true;
	}

	protected boolean SelectFromPopupGrid(String gridTitle, String columnName, String searchValue, int timeout) {

		// getting list of all dialogs
		WebElement allDialogs = driver.findElement(dialogs);
		WebElement searchBar;

		boolean searchBarFound = false;

		try {
			// searching for the one we want, by grid title
			searchBar = allDialogs.findElement(GetSearchBar(gridTitle));

			if (searchBar != null) {
				searchBarFound = true;
			}

		} catch (NotFoundException e) {
			searchBarFound = false;
		}

		// if the search bar is found, meaning no need to click on the filter button
		// if not found, we click the filter button to show the search bar
		if (!searchBarFound) {
			WebElement filterButton = driver.findElement(GetFilterButton(gridTitle));
			Click(filterButton, timeout);
		}

		// wait for dialog to fully load by waiting for grid body to show
		WaitForVisibility(GetGridBody(gridTitle), timeout);

		// now that we are sure there is a displayed search bar, we grab all columns of
		// the grid
		List<WebElement> allColumns = driver.findElements(GetColumns(gridTitle));

		// iterate through columns to find the one we want to search in
		for (int j = 0; j < allColumns.size(); j++) {

			// if column found by column name
			if (allColumns.get(j).getText().equals(columnName)) {
				// clear filter text box, write your search value and hit TAB to allow grid to
				// load since hitting ENTER sometimes closes the dialog (bug)
				Clear(GetFilterTextBox(gridTitle, j));
				Write(GetFilterTextBox(gridTitle, j), searchValue, timeout);
				Write(GetFilterTextBox(gridTitle, j), Keys.TAB, timeout);
				break;
			}
		}

		// we select our row
		WaitForText_Text(GetAllRows(gridTitle), searchValue);
		WebElement row = driver.findElement(GetRow(gridTitle, searchValue));// to be fixed, always selecting first
																			// record

		if (row == null) {
			return false;
		}

		if (Click(row, timeout)) {
			Click(GetDoneButton(gridTitle), timeout);
		} else {
			return false;
		}

		return true;

	}

	protected boolean DropDown(String fieldName, String value, int timeout) {

		WebElement dropDown = driver.findElement(GetDropDownBox(fieldName));

		Write(dropDown, value, timeout);
		Write(dropDown, Keys.ARROW_DOWN, timeout);
		Write(dropDown, Keys.ENTER, timeout);

		return true;

	}

	protected boolean ConfirmDelete(boolean confirm) {
		boolean confirmed = false;

		if (confirm) {
			WaitForElement(yes, 5);
			confirmed = Click(yes, 5);
		} else {
			WaitForElement(no, 5);
			confirmed = Click(no, 5);
		}

		return confirmed;
	}

	// end Actions

	protected String GetToastMsg() {

		WaitForElement(toastBy, 20);
		String message = driver.findElement(toastBy).getText();

		WaitForInvisibility(toastBy, 10);

		return message;
	}

	protected Boolean Search(String columnName, String value, int timeout) {
		Boolean found = false;

		if (!CheckElementExist(searchBar)) {
			Click(filterButton, timeout);
		}

		List<WebElement> allColumns = driver.findElements(columns);

		for (int j = 0; j <= allColumns.size(); j++) {
			if (allColumns.get(j).getText().equals(columnName)) {
				Write(GetMainFilterTextBox(j), value, timeout);
				Write(GetMainFilterTextBox(j), Keys.TAB, timeout);

				// waiting some time to let the grid refresh, if you find another way contact
				// detollino
				WaitForLoad(3);
				found = Click(GetMainRow(j), timeout);
				break;
			}
		}

		return found;
	}

}
