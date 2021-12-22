#Author: yisel.nino@generalsoftwareinc.com

Feature: Add Driver 2.3
  As a: GoHeavy Administrator / Fleet Owner
  I Want To: add a Driver
  So That: a new Driver is registered in the system.

  Background:
    Given Any "GoHeavy Administrator / Fleet Owner" is logged
    And the user is on the "Driver List" view

  Scenario: Add driver 2.3 -- Successfully create a new Driver
    When clicks on the "Add Driver" button
    And User hover overs a Driver image component with an image loaded
    And inserts valid data for "Create"
    And clicks on the "Add" button
    Then will redirect to the "Driver List" view
    And the system will add the new driver into the Driver List


    #As a GoHeavy Admin / Fleet Owner/ Document Approver
	#I want to edit the personal information of a Driver
	#So that I can update the Driver's data allowed for the role and his Status.

 # Scenario: Add driver 2.3 -- Edit a driver
  #  When clicks on the "Edit" icon
  #  Then system displays the "Edit Driver" view with the data preloaded.
  #  And inserts valid data And clicks on the "Update" button
