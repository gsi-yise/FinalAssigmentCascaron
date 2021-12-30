package goheavy.vehicles.page;

import goheavy.vehicles.invalidDataMessages;
import org.junit.Assert;
import org.openqa.selenium.By;
import general.Setup;

public abstract class TabsPage extends VehiclePage {

    public abstract void insertValidData();

    public abstract void insertInvalidData();

    public abstract void checkErrorSMS();

    public abstract void userInsertsValidDataAndGoesToNextPage();

    public abstract void pressPreviousButton();

    public abstract void checkPreviousPageAndDataSaved();


    public String getInvalidErrorSms(invalidDataMessages sms) {
        try {
            switch (sms) {
                case VIN:
                    return "Please, enter a valid VIN";
                case numbers:
                    return "Only numbers. Maximum two digits after the decimal point";
                case letters:
                    return "Only letters and the special character \'-\' are allowed. 50 characters maximum";
                case year:
                    return "Please, enter a valid year value";
                case numbersAndLetters:
                    return "Only letters, numbers and the special character \'-\' are allowed. 50 characters maximum";
                case color:
                    return "Please, enter letters only. 10 characters maximum";
                case trim:
                    return "Only letters and the special character '-' are allowed. 250 characters maximum";
                case insurance:
                    return "Only letters, numbers and the special character \'-\' are allowed. 15 characters maximum";
                case license:
                    return "Only letters, numbers and the special character \'-\' are allowed. 10 characters maximum";
                case policy:
                    return "Only letters and the special character \'-\' are allowed. 15 characters maximum";
                case plate:
                    return "Only letters and the special character \'-\' are allowed. 10 characters maximum";
            }

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        return null;
    }

    public void checkSMSAndClear(String fieldName, By fieldErrorSMS, invalidDataMessages ExpectedSMS, By fieldElement) {
        Assert.assertEquals("The invalid error message in the " + fieldName +
                " field is not the same as the expected one",getWebElement(fieldErrorSMS).getText(),getInvalidErrorSms(ExpectedSMS));
        Setup.getActions().moveToElement(getWebElement(fieldElement));
        clear_element_text(getWebElement(fieldElement));
    }

}
