package com.andrewkingmarshall.testingtemplete;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * The Base for all Activity Instrumentation tests.
 */
public abstract class ActivityInstrumentationTestBase<T extends Activity> extends ActivityInstrumentationTestCase2<T> {

    public ActivityInstrumentationTestBase(Class activityClass) {
        super(activityClass);
    }

    /**
     * Stuff you should do before every test.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getInstrumentation().waitForIdleSync(); //wait for the system to stabilize
    }

    /**
     * Stuff you should do after every test.
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
