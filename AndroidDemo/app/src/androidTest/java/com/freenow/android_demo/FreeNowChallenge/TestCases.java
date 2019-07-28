package com.freenow.android_demo.FreeNowChallenge;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.freenow.android_demo.R;
import com.freenow.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringEndsWith.endsWith;

public class TestCases {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void allowAcess(){
//        onView(withText(endsWith("ALLOW"))).perform(click());
    }


    @Test
    public void ValidateLoginFields(){
        // onView(withId(R.id.permission_allow_button)).perform(click());
        onView(ViewMatchers.withId(R.id.edt_username)).check(matches(isDisplayed()));
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
        onView(withId(R.id.edt_username)).perform(typeText("luiz"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.edt_password)).perform(typeText("fischer"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
    }

    @Test
    public void LoginAndLogout() throws InterruptedException {
       // onView(withId(R.id.permission_allow_button)).perform(click());
        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.edt_password)).perform(typeText("venture"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.design_menu_item_text)).perform(click());
    }

    @Test
    public void SeeDriverProfile(){
        // onView(withId(R.id.permission_allow_button)).perform(click());
        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.edt_password)).perform(typeText("venture"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.textSearch)).perform(typeText("Am"));
        onView(withText(endsWith("Amelia Claire"))).perform(click());
    }




}
