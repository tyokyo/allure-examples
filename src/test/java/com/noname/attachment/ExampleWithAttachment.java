package com.noname.attachment;

import com.noname.helper.AttachmentHelper;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/*
To show how to attach something with allure features
 */
public class ExampleWithAttachment {

    @Test
    public void matchImages() {
        assertThat(getBytes("smile.jpg").length, equalTo(getBytes("grumpycat.jpg").length));
    }

    @Test
    public void matchString() {
        String expected = "qwertyu";
        String actual = "qqwertyu";
        String jsonContent = String.format("{\"expected\": \"%s\", \"actual\": \"%s\"}", expected, actual);
        Allure.addAttachment("testData.json", "application/json", jsonContent, ".txt");
        assertThat(actual, is(not(equalTo(expected))));
    }

    @Attachment(value = "{resource}", type = "image/png")
    public static byte[] getBytes(String resource) {
        return AttachmentHelper.readAllBytes(resource);
    }
}
