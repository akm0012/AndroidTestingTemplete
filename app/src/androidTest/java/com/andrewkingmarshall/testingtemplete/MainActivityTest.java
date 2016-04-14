package com.andrewkingmarshall.testingtemplete;

import android.app.Instrumentation;
import android.widget.Button;

/**
 * Tests the main activity.
 */
public class MainActivityTest extends ActivityInstrumentationTestBase<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    /**
     * Test if that activity is created.
     */
    public void testMainActivity_NotNull() throws Exception {
        // arrange

        // act
        MainActivity mainActivity = getActivity();

        // assert
        assertNotNull(mainActivity);
    }

    /**
     * Testing opening a new Intent.
     */
    public void testMainActivity_ButtonClick() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(OtherActivity.class.getName(), null, false);
        MainActivity mainActivity = getActivity();
        final Button button2 = (Button) mainActivity.findViewById(R.id.button2);
        long waitForMonitorTimeoutMillis = 5000; // 5 seconds

        // act
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button2.performClick();
            }
        });

        OtherActivity otherActivity = (OtherActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, waitForMonitorTimeoutMillis);

        // assert
        assertNotNull(otherActivity);

        // Test specific clean up
        otherActivity.finish();
    }

}
