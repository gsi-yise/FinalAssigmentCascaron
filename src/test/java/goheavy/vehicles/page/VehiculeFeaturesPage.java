package goheavy.vehicles.page;

import goheavy.vehicles.invalidDataMessages;
import org.junit.Assert;
import org.openqa.selenium.By;
import general.PageObject;
import general.Setup;

import java.util.concurrent.ThreadLocalRandom;

public class VehiculeFeaturesPage extends TabsPage {
    private String stepTwoFormScroll = "//*[@id='step-one-form']/ancestor::div["
            + "@class='templateStyles__ContentDiv-sc-144t9h2-1 bcVeZj']";;
    private String vehiclePhotoImageXpath;

    By vehicleModelLocator = By.id("model");
    By vehicleColorLocator = By.id("color");
    By vehicleTrimLocator = By.id("trim");
    By vehicleTransmissionLocator = By.id("transmission");
    String path = "/ancestor::div[contains(@class,'ant-form-item')]/descendant::div[@role='alert']";
    By vehicleModelErrorSMSLocator = By.xpath("//input[@id='model']"+path);
    By vehicleColorErrorSMSLocator = By.xpath("//input[@id='color']"+path);
    By vehicleTrimErrorSMSLocator = By.xpath("//input[@id='trim']"+path);
    By vehicleTransmissionErrorSMSLocator = By.xpath("//input[@id='transmission']"+path);
    DrivingRequirementsPage drivingRequirementsPage;

    public VehiculeFeaturesPage() {
        super();
        drivingRequirementsPage = new DrivingRequirementsPage();
        setVehiclePhotoImageXpath("//input[@type='file']");
        setStepTwoFormScroll("//*[@id='step-two-form']/ancestor::div[@class='templateStyles__ContentDiv-sc-144t9h2-1 bcVeZj']");
    }

    private String getStepTwoFormScroll() {
        return stepTwoFormScroll;
    }

    private void setStepTwoFormScroll(String stepTwoFormScroll) {
        this.stepTwoFormScroll = stepTwoFormScroll;
    }

    private String getVehiclePhotoImageXpath() {
        return vehiclePhotoImageXpath;
    }

    private void setVehiclePhotoImageXpath(String vehiclePhotoImageXpath) {
        this.vehiclePhotoImageXpath = vehiclePhotoImageXpath;
    }

    public void insertValidData() {
        int min_val = 1995;
        int max_val = 2018;

        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int randomNum = tlr.nextInt(min_val, max_val + 1);
        sendDataToInput(getWebElement(By.id("model")),
                getFaker().artist().name(), null, getStepTwoFormScroll());

        sendDataToInput(getWebElement(By.id("color")),
                getFaker().color().name().toUpperCase(), null, getStepTwoFormScroll());

        sendDataToInput(getWebElement(By.id("trim")),
                getFaker().name().firstName(), null, getStepTwoFormScroll());

        sendDataToInput(getWebElement(By.id("transmission")),
                getFaker().name().firstName(), null, getStepTwoFormScroll());

        if (min_val < 145)
            clickOn(getWebElement(By.xpath("//label[@title='Towing Kit Installed']/ancestor::" +
                    "div[@class='ant-row ant-form-item']/descendant::button[@type='button']")));

        if (randomNum % 2 == 0)
            clickOn(getWebElement(By.xpath("//label[@title='Liftgate Installed']/ancestor::" +
                    "div[@class='ant-row ant-form-item']/descendant::button[@type='button']")));

        scrollToWebElement(null, getStepTwoFormScroll());
        setImage(getWebElement(By.xpath(getVehiclePhotoImageXpath())));

        clickOn(getWebElement(By.xpath("//button[@type='submit']/descendant::span[text()='Next']")));
        waitForSpinningElementDissapear();
        Setup.getWait().thread(1500);

        //ONLY ADDED FOR SCENARIO 3
        drivingRequirementsPage.insertInvalidData();
    }
    public boolean systemOpensAddVehicleView() {
        return true;
    }

    //escenario 3
    public void insertInvalidData() {
        waitForSpinningElementDissapear();
        sendDataToInput(getWebElement(vehicleModelLocator),getFaker().regexify("[a-z1-9._%+-]{10}"), null,getStepTwoFormScroll());
        sendDataToInput(getWebElement(vehicleColorLocator),getFaker().regexify("[a-z1-9._%+-]{10}"), null,getStepTwoFormScroll());
        sendDataToInput(getWebElement(vehicleTrimLocator),getFaker().regexify("[a-z1-9._%+-]{10}"), null,getStepTwoFormScroll());
        sendDataToInput(getWebElement(vehicleTransmissionLocator),getFaker().regexify("[a-z1-9._%+-]{10}"), null,getStepTwoFormScroll());
        clicks_button_done();
        checkErrorSMS();
    }

    public void checkErrorSMS() {
        checkSMSAndClear("Vehicle Model",vehicleModelErrorSMSLocator, invalidDataMessages.numbersAndLetters,vehicleModelLocator);
        checkSMSAndClear("Vehicle Color",vehicleColorErrorSMSLocator,invalidDataMessages.letters,vehicleColorLocator);
        checkSMSAndClear("Vehicle Trim",vehicleTrimErrorSMSLocator,invalidDataMessages.trim,vehicleTrimLocator);
        checkSMSAndClear("Vehicle Transmission",vehicleTransmissionErrorSMSLocator,invalidDataMessages.letters,vehicleTrimLocator);

        insertValidData();
    }
//escenario 8

    public void userInsertsValidDataAndGoesToNextPage() {
        int min_val = 1995;
        int max_val = 2018;

        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int randomNum = tlr.nextInt(min_val, max_val + 1);

        String modelValue = getFaker().artist().name();
        sendDataToInput(getWebElement(By.id("model")), modelValue, null, getStepTwoFormScroll());
        Setup.setKeyValueStore("model", modelValue);

        String colorValue = getFaker().color().name().toUpperCase();
        sendDataToInput(getWebElement(By.id("color")), colorValue, null, getStepTwoFormScroll());
        Setup.setKeyValueStore("color", colorValue);

        sendDataToInput(getWebElement(By.id("trim")), getFaker().name().firstName(), null, getStepTwoFormScroll());

        sendDataToInput(getWebElement(By.id("transmission")), getFaker().name().firstName(), null, getStepTwoFormScroll());

        if (min_val < 145)
            clickOn(getWebElement(By.xpath("//label[@title='Towing Kit Installed']/ancestor::" +
                    "div[@class='ant-row ant-form-item']/descendant::button[@type='button']")));

        if (randomNum % 2 == 0)
            clickOn(getWebElement(By.xpath("//label[@title='Liftgate Installed']/ancestor::" +
                    "div[@class='ant-row ant-form-item']/descendant::button[@type='button']")));

        setImage(getWebElement(By.xpath(getVehiclePhotoImageXpath())));

        scrollToWebElement(null, getStepTwoFormScroll());

        clickOn(getWebElement(By.xpath("//button[@type='submit']/descendant::span[text()='Next']")));
        waitForSpinningElementDissapear();
        Setup.getWait().thread(1500);

        //insert data in the next tab page
        drivingRequirementsPage.userInsertsValidDataAndGoesToNextPage();

    }

    public void pressPreviousButton(){
        scrollToWebElement(null, getStepTwoFormScroll());

        clickOn(getWebElement(By.xpath("//span[text()='Previous']/ancestor::button")));
        waitForSpinningElementDissapear();
    }

    public void returnPreviousPage(){
        waitForSpinningElementDissapear();
        Setup.getWait().thread(500);
        try {
            getWebElement(vehicleModelLocator).isDisplayed();

        }catch (Exception e){
            System.out.println("Expected Vehicle Feature Page view page wasn't found");
        }
    }

    public void checkPreviousPageAndDataSaved() {
        Assert.assertEquals("Values of Vehicle Model field are not equals", getWebElement(vehicleModelLocator).getAttribute("value"), Setup.getValueStore("model"));
        Assert.assertEquals("Values of Vehicle color field are not equals", getWebElement(vehicleColorLocator).getAttribute("value"), Setup.getValueStore("color"));
    }

}
