package com.noname.helper;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestResultsListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult testResult) {
        AttachmentHelper.attachImage("passed.jpeg");
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        AttachmentHelper.attachImage("failed.jpeg");
    }
}