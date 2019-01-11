package com.noname.attachment;

import com.noname.helper.AttachmentHelper;
import com.noname.helper.TestResultsListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/*
To show how to attach something with allure features inside listener
 */
@Listeners({TestResultsListener.class})
public class ExampleWithAttachmentAndListener {

    @Test
    public void compareImages() {
        assertEquals(getBytes("smile.jpg"), getBytes("grumpycat.jpg"));
    }

    @Test
    public void comparePictures() {
        assertNotEquals(getBytes("smile.jpg"), getBytes("grumpycat.jpg"));
    }

    public static byte[] getBytes(String resource) {
        return AttachmentHelper.readAllBytes(resource);
    }
}
