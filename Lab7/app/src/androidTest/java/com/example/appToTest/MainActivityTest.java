package com.example.appToTest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import android.support.test.annotation.UiThreadTest;
import android.widget.TextView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity = null;
    private TextView text;

    @Test
    @UiThreadTest
    public void checkFirstName() throws Exception{
        mActivityTestRule.getScenario().onActivity(activity -> {
            mActivity = activity;
            assertNotNull(mActivity.findViewById(R.id.textView));
            text = mActivity.findViewById(R.id.textView);
            text.setText("user1");
            assertNotEquals("user",text.getText().toString());
        });


    }
}
