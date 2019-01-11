package com.noname.helper;

import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class AttachmentHelper {

    @Attachment(value = "{fileName}", type = "image/png")
    public static byte[] attachImage(final String fileName) {
        return readAllBytes(fileName);
    }

    @SneakyThrows(IOException.class)
    public static byte[] readAllBytes(String fileName) {
        return Files.readAllBytes(Paths.get("src/main/resources", fileName));
    }
}
