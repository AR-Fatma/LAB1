package com.example.appToTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest2 {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void emailIsInvalid(){

        onView(withId(R.id.textView)).perform(typeText("user"),closeSoftKeyboard());
        onView(withId(R.id.textView2)).perform(typeText("test"),closeSoftKeyboard());
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("email@"),closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withText("Invalid login!")).check(matches(isDisplayed()));

    }
}
