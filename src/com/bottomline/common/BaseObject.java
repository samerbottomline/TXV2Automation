package com.bottomline.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseObject {

	By dialogs = By.xpath("//h2[@class='mdc-dialog__title']");
	By toastBy = By.xpath("//div[@class='tx-toast-body']");

	// here we search inside dialogs(dialog found by dialog title) for the search
	// bar element
	public By GetSearchBar(String gridTitle) {
		String xpath = "//h2[@class='mdc-dialog__title'][contains(text(),'" + gridTitle
				+ "')]/parent::div//div[@class='card']//thead/tr[@class='dxbs-filter-row']";

		By searchBar = By.xpath(xpath);

		return searchBar;
	}

	public By GetFilterButton(String gridTitle) {
		String xpath = "//h2[@class='mdc-dialog__title'][contains(text(),'" + gridTitle
				+ "')]/parent::div//div[@role='toolbar']/div[@role='group']/button";

		By filterButton = By.xpath(xpath);

		return filterButton;
	}

	public By GetColumns(String gridTitle) {
		String xpath = "//h2[@class='mdc-dialog__title'][contains(text(),'" + gridTitle
				+ "')]/parent::div//div[@class='card']//thead/tr[1]/th";
		By columns = By.xpath(xpath);

		return columns;
	}

	public By GetFilterTextBox(String gridTitle, int index) {

		String xpath = "//h2[@class='mdc-dialog__title'][contains(text(),'" + gridTitle
				+ "')]/parent::div//div[@class='card']//thead/tr[1]/th//div[@class='dxbs-fixed-header-content']/../../../tr[@class='dxbs-filter-row']/td["
				+ index + "]//input";

		By filterTextBox = By.xpath(xpath);

		return filterTextBox;
	}

	public By GetAllRows(String gridTitle) {
		String xpath = "//h2[@class='mdc-dialog__title'][contains(text(),'" + gridTitle + "')]/parent::div//tbody/tr";
		By row = By.xpath(xpath);

		return row;
	}

	public By GetRow(String gridTitle, String value) {
		String xpath = "//h2[@class='mdc-dialog__title'][contains(text(),'" + gridTitle
				+ "')]/parent::div//tbody/tr[1]/td[contains(text(),'" + value + "')]";
		By row = By.xpath(xpath);

		return row;
	}

	public By GetDoneButton(String gridTitle) {
		String xpath = "//h2[@class='mdc-dialog__title'][contains(text(),'" + gridTitle
				+ "')]/parent::div//button[text() = 'Done']";

		By done = By.xpath(xpath);
		return done;
	}

	public By GetDropDownBox(String label) {
		String xpath = "//label[text()='" + label + "']/parent::div/div[@class='tx-textbox-input']//input";
		By dropDownBox = By.xpath(xpath);
		return dropDownBox;
	}

	@FindBy(className = "tx-loader")
	WebElement txLoader;

	@FindBy(xpath = "//div[@class='tx-toast-body']")
	WebElement toast;

}
