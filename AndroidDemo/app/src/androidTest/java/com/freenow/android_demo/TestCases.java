package com.freenow.android_demo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;

import com.freenow.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class TestCases {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void ValidateLoginFields(){
        // onView(withId(R.id.permission_allow_button)).perform(click());
        onView(withText("Login")).check(matches(isDisplayed()));
        onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    public void LoginUntyped(){
        // onView(withId(R.id.permission_allow_button)).perform(click());
        onView(withId(R.id.btn_login)).perform(click());
    }

    @Test
    public void LoginUnsucessful(){
        // onView(withId(R.id.permission_allow_button)).perform(click());
        onView(withId(R.id.edt_username)).perform(typeText("luiz"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.edt_password)).perform(typeText("fischer"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
    }

    @Test
    public void LoginSucessful(){
       // onView(withId(R.id.permission_allow_button)).perform(click());
        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.edt_password)).perform(typeText("venture"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
    }




}
