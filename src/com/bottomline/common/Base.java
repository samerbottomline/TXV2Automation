package com.bottomline.common;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

//BASE CLASS CONTAINS ALL NECCESSARY AND REPETITIVE ACTIONS NEEDED TO INTERACT WITH ANY PAGE
public class Base extends BaseObject {

	WebDriver driver;

	// CTOR
	public Base(WebDriver driver) {
		this.driver = driver;
	}

	// region wait

	@SuppressWarnings({ "deprecation" })
	protected boolean WaitForLoad(int timeout, int polling) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(5, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.SECONDS);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(By.className("tx-loader"));
			}
		});

		return true;

	}

	protected boolean WaitForElement(WebElement element) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		wait.withTimeout(5, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		return true;
	}

	protected boolean WaitForElement(By by) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		wait.withTimeout(5, TimeUnit.SECONDS);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));

		return true;
	}

	// end region wait

	// region check for elements
	protected boolean CheckElementExist(WebElement element) {
		return element.isDisplayed();
	}
	// end region check for elements

	// region Actions

	protected boolean Clear(WebElement element) {
		// to be implemented
		return true;
	}

	protected boolean Clear(By by) {
		driver.findElement(by).clear();
		return true;
	}

	protected boolean Click(WebElement element) {
		try {
			WaitForElement(element);
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean Click(By by) {
		try {
			WaitForElement(by);
			driver.findElement(by).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean Write(WebElement element, String value) {
		WaitForElement(element);
		element.sendKeys(value);
		return true;
	}

	protected boolean Write(WebElement element, Keys key) {
		WaitForElement(element);
		element.sendKeys(key);
		return true;
	}

	protected boolean Write(By by, String value) {
		WaitForElement(by);
		driver.findElement(by).sendKeys(value);
		return true;
	}

	protected boolean SelectFromPopupGrid(String gridTitle, String columnName, String searchValue) {

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
			Click(filterButton);
		}

		// now that we are sure there is a displayed search bar, we grab all columns of
		// the grid
		List<WebElement> allColumns = driver.findElements(GetColumns(gridTitle));

		// iterate through columns to find the one we want to search in
		for (int j = 0; j < allColumns.size(); j++) {

			// if column found by column name
			if (allColumns.get(j).getText().equals(columnName)) {

				WebElement filterBox = driver.findElement(GetFilterTextBox(gridTitle, j));

				// clear filter text box, write your search value and hit TAB to allow grid to
				// load since hitting ENTER sometimes closes the dialog (bug)
				Clear(filterBox);
				Write(filterBox, searchValue);
				Write(filterBox, Keys.TAB);
				break;
			}
		}

		// we select our row
		WebElement row = driver.findElement(GetRow(gridTitle, 1));

		if (row == null) {
			return false;
		}

		Click(row);
		Click(GetDoneButton(gridTitle));

		return true;

	}
	// end Actions

}
