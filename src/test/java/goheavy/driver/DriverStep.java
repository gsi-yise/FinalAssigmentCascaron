package goheavy.driver;

import goheavy.driver.pages.DriverListPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import general.PageObject;
import general.Setup;
import general.Steps;
import goheavy.driver.pages.DriverPage;

public class DriverStep extends Steps{
	public final DriverListPage driverListPage;
	public final DriverPage driverPage;
	public final PageObject po;

	public DriverStep() {
		driverListPage = new DriverListPage();
		driverPage = new DriverPage();
		po = new PageObject();
	}

	public void checkPage() {
		String path = driverPage.getPagePath().toLowerCase();
		Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
				driverPage.getCurrentUrl().toLowerCase().contains(path));
	}

	public void goToView() {
		Assert.assertTrue(driverListPage.goToView());
	}

	public void clickOnAddDriver() {
		driverPage.clicksOnAddDriverButton();
	}

	public void addDriver(boolean update) {
		Assert.assertTrue(driverPage.insertValidData(update));
	}

	public void hoverOverImageComponent() {
		try {
			Assert.assertTrue(driverPage.hoverOverImageComponent());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void clickOnAddButton() {
		po.clicks_button_done();
	}

	public void checkDriverCreated() {
		Assert.assertTrue(driverPage.checkDriverCreation());
	}


	public void checkDriverListView() {
		Assert.assertTrue(driverListPage.checkDriverListView());
	}

	/*public void clickDriverDocument() {
		String path = "//td[text()='"+ driverPage.getFullName() +"']/ancestor::tr/descendant::span[@class='anticon anticon-file-text']";
		WebElement doc = po.getWebElement(By.xpath(path));
		Setup.getActions().click(doc).build().perform();
		Assert.assertTrue("Driver Documents page not found",
				po.getWebElement(By.xpath("//span[contains(@class,'iaAGQP')]")).getAttribute("value").contains("Documents for "+ driverPage.getFullName()));
	}

	public void clickEditIcon() {
		Assert.assertTrue("Edit icon not found",driverPage.clicksOnEdit());
	}

	public void showEdit() {
		driverPage.showEditView();
	}	*/
}
