package com.noname.retry;

import com.noname.helper.RetryAnalyzer;
import io.qameta.allure.Flaky;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
To show how allure processes and shows retries
 */
public class ExampleWithRetry {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Flaky
    public void matchBoolean() {
        assertThat(new Random().nextBoolean(), is(true));
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Flaky
    public void matchInt() {
        assertThat(new Random().nextInt(4), is(5));
    }
}