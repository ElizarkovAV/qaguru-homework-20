package tests;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class WikiAppSearchTests extends TestBase {

    @Test
    void successfulSearchTest() {
        //act
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        //assert
        step("Verify content found", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    void successfulOpenPageFromSearchResultsTest() {
        //act
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
           $(id("org.wikipedia.alpha:id/search_src_text")) .sendKeys("Appium");
        });

        step("Open first page from search results", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });

        //assert
        assertThat($(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                .getText()).isEqualTo("An error occurred");
    }
}
