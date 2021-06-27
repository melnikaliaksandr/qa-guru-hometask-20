package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Check settings menu")
    void settingsTest() {
        step("Click menu button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Open settings", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });
        step("Verify settings menu", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/action_bar"))
                    .$(MobileBy.className("android.widget.TextView"))
                        .shouldHave(text("Settings")));
    }

}