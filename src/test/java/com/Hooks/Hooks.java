
package com.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.BaseClass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    @After
    public void takeScreenshot(Scenario scenario) {

        if (scenario.isFailed() && driver != null) {

            try {

                byte[] screenshot =
                    ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                    screenshot,
                    "image/png",
                    "Failed Screenshot"
                );

                System.out.println(
                    "Screenshot captured for: "
                    + scenario.getName()
                );

            } catch (Exception e) {

                System.out.println(
                    "Screenshot failed: " + e.getMessage()
                );
            }
        }
    }
}
