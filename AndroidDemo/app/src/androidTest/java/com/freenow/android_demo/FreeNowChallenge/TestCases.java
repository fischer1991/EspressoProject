package com.freenow.android_demo.FreeNowChallenge;

import android.support.test.rule.ActivityTestRule;
import com.freenow.android_demo.FreeNowChallenge.robots.robots;
import com.freenow.android_demo.activities.MainActivity;
import org.junit.Rule;
import org.junit.Test;

public class TestCases {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ValidateLoginFields(){
        new robots()
            .checkUsernameField()
            .checkPasswordField()
            .checkLoginButton();
    }

    @Test
    public void LoginUntyped() throws InterruptedException {
        new robots()
                .clickLoginButton();
    }

    @Test
    public void LoginUnsucessful() throws InterruptedException {
        new robots()
                .typeWrongUsername()
                .typeWrongPassword()
                .clickLoginButton();
    }

    @Test
    public void LoginAndLogout() throws InterruptedException {
        new robots()
                .typeUsername()
                .typePassword()
                .clickLoginButton()
                .clickOnMenu()
                .clickLogoutButton();
    }

    @Test
    public void SeeDriverName() throws InterruptedException {
        new robots()
                .typeUsername()
                .typePassword()
                .clickLoginButton()
                .typeDriverSearch()
                .pressBack()
                .clickOnMenu()
                .clickLogoutButton();
    }
}
