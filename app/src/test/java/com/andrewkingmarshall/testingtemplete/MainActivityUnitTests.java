package com.andrewkingmarshall.testingtemplete;

import android.content.Intent;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.robolectric.util.ActivityController;

/**
 * Tests the MainActivity.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 19)

public class MainActivityUnitTests extends TestBase {

    @Test
    public void testMainActivityOnClickListener() throws Exception {
        // arrange
        String expectedActivityName = OtherActivity.class.getCanonicalName();

        ActivityController controller = Robolectric.buildActivity(MainActivity.class).create().start();
        MainActivity activity = (MainActivity) controller.get();
        controller.resume();

        // act
        activity.findViewById(R.id.button).performClick();

        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Shadows.shadowOf(startedIntent);

        // assert
        // Make sure we were logged out and sent to the ManagerActivity
        Assert.assertEquals(expectedActivityName, shadowIntent.getComponent().getClassName());
    }

}
