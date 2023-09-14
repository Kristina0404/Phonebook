package org.ait.phonebook.fw;

import org.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath(
                "//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[.='LOGIN']"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        // enter password- [placeholder='Password'] -css
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }
    public void fillLoginRegistrationFormForScreencast(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        pause(500);
        // enter password- [placeholder='Password'] -css
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
        pause(1000);
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Login']" ));
    }

    public void login() {
        clickOnLoginLink();
        fillLoginRegistrationForm(new User()
                .setEmail("haha@gmail.com")
                .setPassword("Picacho123$"));
        //click on login button
        clickOnLoginButton();
    }
}
