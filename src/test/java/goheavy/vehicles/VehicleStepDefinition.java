package goheavy.vehicles;

import io.cucumber.java.en.*;
import general.GeneralSteps;

    public class VehicleStepDefinition {
    private VehicleStep vehicleStep;
    @SuppressWarnings("unused")
    private GeneralSteps generalSteps;

    public VehicleStepDefinition() {
        vehicleStep = new VehicleStep();
        generalSteps = new GeneralSteps();
    }

    @When("User clicks on \"Add Vehicle\" button.")
    public void the_user_clicks_on_add_vehicle_button() {
        try {
            vehicleStep.userClicksOnAddVehicleButton();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Given("The system opens the \"Add Vehicle\" view.")
    public void the_system_opens_the_add_vehicle_view() {
        try {
            vehicleStep.theSystemOpensTheAddVehicleView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("User hover overs a Vehicle document image component with an image loaded")
    public void hover_over_image_component_with_image() {
        try {
            vehicleStep.hoverOverImageComponent();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("The user inserts valid data")
    public void the_user_inserts_valid_data_and_clicks_done_button() {
        try {
            vehicleStep.userInsertsValidDataAndClicksDone();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("User clicks on the \"Done\" button.")
    public void clicks_button() {
        vehicleStep.clicks_button_done();
    }

    //Improve this to meet the other NF requirement
    @Then("The System Creates a new Vehicle in {string} status.")
    public void the_system_creates_vahicle_and_registers_date(String status) {
        try {
            vehicleStep.systemCreatesVehicleOnStatus(status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @And("The System registers the creation date.")
    public void the_system_registers_the_creation_date() {
        try {
            vehicleStep.systemRegistersCreationDate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("System returns to the \"Vehicles & Insurance List\" view")
    public void returns_to_view() {
        vehicleStep.returnToMainView();
    }

    @Then("System displays message {string}")
    public void system_displays_message(String message) {
        vehicleStep.systemDisplaysMessage(message);
    }

    @Then("The system displays \"Assign Vehicle\" view.")
    public void system_dsiplays_assign_view() {
        try {
            vehicleStep.systemDisplaysAssignView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @When("User assigns the vehicle.")
    public void user_assigns_the_vehicle() {
        try {
            vehicleStep.userAssignsTheVehicle();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        //escenario 3

        @When("The user sets invalid data to fields")
        public void the_user_sets_invalid_data_to_fields() {
            try {
                vehicleStep.userIntroduceInvalidData();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        @Then("The system displays an error message for each input field")
        public void the_system_displays_an_error_message_for_each_input_field() {
            try {
                vehicleStep.verifyErrorSMS();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //escenario 8

        @And("The user inserts valid data and goes to next page")
        public void theUserInsertsValidDataAndGoesToNextPage() {
            vehicleStep.userInsertsValidDataAndGoesToNextPage();
        }

        @And("User clicks on \"Previous\" button.")
        public void user_clicks_on_previous_button(){
            vehicleStep.userClicksOnThePreviousButton();
        }

        @Then("The system returns to the previous view without lost of data previously inserted")
        public void theSystemReturnsToThePreviousViewWithoutLostOfDataPreviouslyInserted() {
            vehicleStep.SystemReturnsToThePreviousViewWithoutLostOfDataPreviouslyInserted();
        }


    }
