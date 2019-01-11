package com.noname.helper;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationHelper {

    @Step("Run application instance")
    public static void setUpApplication(String url, int port, int liveTimeInSeconds) {
        log.info("running application");
    }

    @Step("Shut down current application instance")
    public static void tearDownApplication() {
        log.info("shutting application down");
    }
}
