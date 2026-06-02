package ru.solnyshko;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueTest {

    private static final String REPOSITORY = "alexCarwin/qa_guru_project_git";
    private static final String ISSUE_NAME = "Test_issue_1";

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @Test
    @Feature("Репозиторий в github")
    @Story("Раздел Issue")
    @Owner("LatushkinAl")
    @DisplayName("Проверка названия Issue в репозитории, используя чистый Selenide")
    public void testIssueNameWithSelenide() {

        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(ISSUE_NAME)).should(Condition.exist);
    }


    @Test
    @Feature("Репозиторий в github")
    @Story("Раздел Issue")
    @Owner("LatushkinAl")
    @DisplayName("Проверка названия Issue в репозитори, используя лямбда шаги через step")
    public void testIssueNameWithLambda() {

        step("Открываем github.com",
                () -> open("https://github.com"));
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY,
                () -> $(linkText(REPOSITORY)).click());
        step("Кликаеп по разделу issues",
                () -> $("#issues-tab").click());
        step("Проверяем наличие issue с именем " + ISSUE_NAME,
                () -> $(withText(ISSUE_NAME)).should(Condition.exist));
    }


    @Test
    @Feature("Репозиторий в github")
    @Story("Раздел Issue")
    @Owner("LatushkinAl")
    @DisplayName("Проверка названия Issue в репозитории, используя шаги с аннотацией @Step")
    public void testIssueNameWithAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.clickOnIssuesTab();
        steps.shouldSeeIssueName(ISSUE_NAME);
    }
}

