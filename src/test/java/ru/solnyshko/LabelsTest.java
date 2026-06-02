package ru.solnyshko;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

@Test
@Feature("Issue в репозитории")
@Story("Создание Issue")
@Owner("LatushkinAL")
@DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels(){

}

@Test
    public void testDynamicLabels(){

    Allure.getLifecycle().updateTestCase(
            t -> t.setName("Создание Issue для авторизованного пользователя")
    );
    Allure.feature("Issue в репозитории");
    Allure.story("Создание Issue");
    Allure.label("owner", "LatushkinAL");
}

}
