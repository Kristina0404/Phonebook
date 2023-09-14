package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{

    // precondition: if user should be logged out
    @BeforeMethod

    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    // click on login link- a:nth-child(4) -css
        app.getUser().clickOnLoginLink();
    }

  /*  @Test
  //используем 1 раз при регистрации
    public void newUserRegistrationPositiveTest() {
        // enter email - [placeholder='Email']- css
        fillLoginRegistrationForm("haha@gmail.com", "Picacho123$");
        // click on Registration button -//button[text()='Registration'] -xpath
        clickOnRegistrationButton();
        // assert sign button displayed- //button[contains(.,'Sign Out')] -xpath
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));

    }*/

    @Test
    public void existedUserRegistrationPositiveTest() {
        // enter email - [placeholder='Email']- css
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("haha@gmail.com")
                .setPassword("Picacho123$"));
        // click on Registration button -//button[text()='Registration'] -xpath
        app.getUser().clickOnRegistrationButton();
        // assert alert is appeared
   Assert.assertTrue(app.getUser().isAlertPresent());

    }

}

