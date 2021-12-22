package goheavy.driver;

import io.cucumber.java.en.*;
import general.*;
import general.GeneralSteps;
import org.junit.Assert;

public class DriverStepDefinition {
		private final DriverStep driverSteps;

	public DriverStepDefinition() {
		GeneralSteps generalSteps = new GeneralSteps();
		driverSteps = new DriverStep();
	}


	@Given("the user is on the \"Driver List\" view")
	public void the_user_is_on_the_driver_list_view() {
		try {
			driverSteps.goToView();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("clicks on the \"Add Driver\" button")
	public void clicks_on_the_add_driver_button() {
		try {
			driverSteps.clickOnAddDriver();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}


	@And("User hover overs a Driver image component with an image loaded")
	public void userHoverOversADriverImageComponentWithAnImageLoaded() {
		try {
			driverSteps.hoverOverImageComponent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@And("inserts valid data for {string}")
	public void insertsValidDataFor(String update) {
		boolean is_update = false;
		if (update.equals("Update"))
			is_update = true;
		try {
			driverSteps.addDriver(is_update);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@And("clicks on the \"Add\" button")
	public void clicks_on_button() {
		try {
			driverSteps.clickOnAddButton();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}


	@Then("will redirect to the \"Driver List\" view")
	public void willRedirectToDriverListView() {
		try {
			driverSteps.checkDriverListView();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@And("the system will add the new driver into the Driver List")
	public void the_system_will_add_the_new_driver_into_the_driver_list() {
		try {
			driverSteps.checkDriverCreated();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	//escenario Edit

/*	@When("clicks on the \"Edit\" icon")
	public void clicks_on_the_edit_icon(){
		try {
			driverSteps.clickEditIcon();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}


	@Then("system displays the \"Edit Driver\" view with the data preloaded.")
	public void system_displays_the_edit_driver_view_with_the_data_preloaded(){

	}


	@When("inserts valid data And clicks on the \"Update\" button")
	public void inserts_valid_data_clicks_on_the_edit_button(){
		try {
			driverSteps.addDriver();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}


	@And("will clicks on the Document icon")
	public void will_Clicks_On_The_Document_Icon() {
		try{
			driverSteps.clickDriverDocument();
		}  catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}


	@And("insert valid data and press on tye \"Update\" button")
	public void insert_valid_data_and_press_on_tye_update_button(){

	}*/










}
