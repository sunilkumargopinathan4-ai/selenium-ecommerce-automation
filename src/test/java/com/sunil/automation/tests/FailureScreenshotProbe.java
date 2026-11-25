
package com.sunil.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;

public class FailureScreenshotProbe extends BaseTest {

    @Test
    public void verifyFailureScreenshot() {

        Assert.fail(
                "Intentional failure to verify screenshot capture");
    }
}

