package ru.solnyshko;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Кликаеп по разделу issues")
    public void clickOnIssuesTab(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие issue с именем {name}")
    public void shouldSeeIssueName(String name) {
        $(withText(name)).should(Condition.exist);
    }

    @Step("Проверяем наличие .gitignore")
    public void shouldSeeGitignore() {
        $(withText(".gitignore")).should(Condition.exist);
    }

}
