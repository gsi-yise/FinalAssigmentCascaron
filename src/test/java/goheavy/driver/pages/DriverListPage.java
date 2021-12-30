package goheavy.driver.pages;

import general.PageObject;
import org.openqa.selenium.By;

public class DriverListPage extends PageObject {

	private final By menuDriversLinkLocator = By.xpath("//span[text()='Drivers']/ancestor::span[@class='ant-menu-title-content']");
	private final By driverListTitleLocator = By.xpath("//span[text()='Drivers List']/ancestor::div[@class='styles__HeadTitleStyled-sc-1qjgkf9-0 hAvgMj']");

	public DriverListPage() {
		super();
		this.urlpath = "/driver";
	}

	public boolean goToView() {
		waitForSpinningElementDissapear();
		clickOnElement(menuDriversLinkLocator);
		return true;
	}

	public boolean checkDriverListView() {
		waitForSpinningElementDissapear();
		return getWebElement(driverListTitleLocator).isDisplayed();
	}



}
