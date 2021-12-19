package goheavy.driver;

import io.cucumber.java.en.*;
import general.*;
import general.GeneralSteps;

@SuppressWarnings("unused")
public class DriverStepDefinition {
	private GeneralSteps generalSteps;
	private DriverStep driverSteps;

	public DriverStepDefinition() {
		generalSteps = new GeneralSteps();
		driverSteps = new DriverStep();
	}



}
