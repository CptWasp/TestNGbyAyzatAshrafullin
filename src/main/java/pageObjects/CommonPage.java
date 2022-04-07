package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class CommonPage extends AbstractPage {

    public CommonPage(WebDriver driver){
        super(driver);
    }

    // region Поиск

    //------------------------------------------------------------------------------------------------------------------
    // поле [Поиск]
    private final String SEARCH_INPUT_XPATH  = "//input[@aria-label='Найти']";
    //------------------------------------------------------------------------------------------------------------------

    // end region

    // region Калькулятор

    //------------------------------------------------------------------------------------------------------------------
    // [Дисплей калькулятора]
    private final String CALCULATOR_INPUT_DISPLAY_XPATH = "//div[@jsname='a1lrmb']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [=] (равно)
    private final String CALCULATOR_EQUALS_BUTTON_XPATH = "//div[@jsname='Pt8tGc']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [÷] (деление)
    private final String CALCULATOR_DIV_BUTTON_XPATH = "//div[text()='÷' or @aria-label='деление']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [*] (умножение)
    private final String CALCULATOR_MULTIPLY_BUTTON_XPATH = "//div[text()='*' or @aria-label='умножение']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [+] (сложение)
    private final String CALCULATOR_SUMM_BUTTON_XPATH = "//div[text()='+' or @aria-label='сложение']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [-] (вычитание)
    private final String CALCULATOR_MINUS_BUTTON_XPATH = "//div[text()='-' or @aria-label='вычитание']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [)] (закрывающая скобка)
    private final String CALCULATOR_CLOSE_BRACKETS_BUTTON_XPATH = "//div[text()=')' or @aria-label='закрывающая скобка']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [(] (открывающая скобка)
    private final String CALCULATOR_OPEN_BRACKETS_BUTTON_XPATH = "//div[text()='(' or @aria-label='открывающая скобка']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [4]
    private final String CALCULATOR_FOUR_BUTTON_XPATH = "//div[@role='button' and text()='4']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [5]
    private final String CALCULATOR_FIVE_BUTTON_XPATH = "//div[@role='button' and text()='5']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [6]
    private final String CALCULATOR_SIX_BUTTON_XPATH = "//div[@role='button' and text()='6']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [2]
    private final String CALCULATOR_TWO_BUTTON_XPATH = "//div[@role='button' and text()='2']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [8]
    private final String CALCULATOR_EIGHT_BUTTON_XPATH = "//div[@role='button' and text()='8']";
    //------------------------------------------------------------------------------------------------------------------
    // Поле [Ответ]
    private final String RESULT_XPATH = "//span[@id='cwos']";
    //------------------------------------------------------------------------------------------------------------------

    // end region


    /**
     * Открываем страницу в браузере
     *
     * @param url требуемая страница для перехода
     */
    public void openPage(String url){
        String errorMessage = String.format("[ОШИБКА]: url страницы не совпадает с ожидаемым, ожидаемый результат -" +
                " [%s], фактический результат - [%s]", url, driver.getCurrentUrl());

        driver.get(url);
        Assert.assertTrue(driver.getCurrentUrl().equals(url), errorMessage);
    }

    /**
     * Вводим слово и ищем, проверяем, что в поиске то слово, которое мы ищем
     *
     * @param theSearchWord вводимое слово (в нашем случае "калькулятор")
     */
    public void searchingTheWord(String theSearchWord){
        String errorElementIsEqualTexts = "[ОШИБКА]: Вводимый текст и отображаемый текст не отличаются";

        WebElement searchInput = findByXpath(SEARCH_INPUT_XPATH, Duration.ofSeconds(10));
        WebElement searchInputKendo = findByXpath(SEARCH_INPUT_XPATH, Duration.ofSeconds(10));

        searchInputKendo.click();

        searchInput.sendKeys(theSearchWord);
        searchInput.sendKeys(Keys.ENTER);

        // новый элемент на странице
        String searchInputLabelTest = findByXpath(SEARCH_INPUT_XPATH, Duration.ofSeconds(10)).getAttribute("value");
        Assert.assertTrue(searchInputLabelTest.equals(theSearchWord), errorElementIsEqualTexts);
    }

    /**
     * Проверяем наличие калькулятора на странице
     * Проверка наличия калькулятора подразумевает, что отображаются необходимые элементы управления
     */
    public void checkCalculator(){
        String errorElementIsNotInPage = "[ОШИБКА]: элемент [Калькулятор] не отображается на странице";

        WebElement calculatorDisplay = findByXpath(CALCULATOR_INPUT_DISPLAY_XPATH, Duration.ofSeconds(10));
        WebElement calculatorSummButton = findByXpath(CALCULATOR_SUMM_BUTTON_XPATH, Duration.ofSeconds(10));
        WebElement calculatorDivButton = findByXpath(CALCULATOR_DIV_BUTTON_XPATH, Duration.ofSeconds(10));
        WebElement calculatorMultiplyButton = findByXpath(CALCULATOR_MULTIPLY_BUTTON_XPATH, Duration.ofSeconds(10));
        WebElement calculatorMinusButton = findByXpath(CALCULATOR_MINUS_BUTTON_XPATH, Duration.ofSeconds(10));
        WebElement calculatorEqualsButton = findByXpath(CALCULATOR_EQUALS_BUTTON_XPATH, Duration.ofSeconds(10));

        Assert.assertTrue(calculatorSummButton.isDisplayed(), errorElementIsNotInPage);
        Assert.assertTrue(calculatorDivButton.isDisplayed(), errorElementIsNotInPage);
        Assert.assertTrue(calculatorMultiplyButton.isDisplayed(), errorElementIsNotInPage);
        Assert.assertTrue(calculatorMinusButton.isDisplayed(), errorElementIsNotInPage);
        Assert.assertTrue(calculatorEqualsButton.isDisplayed(), errorElementIsNotInPage);
        Assert.assertTrue(calculatorDisplay.isDisplayed(), errorElementIsNotInPage);

    }

    /**
     * Выполняем выражение 4 × (5 + 6) ÷ 2 + 8
     * нажимаем (равно), ожидаем ответ
     */
    public void doRequiredExpression(){
        findByXpath(CALCULATOR_FOUR_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_MULTIPLY_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_OPEN_BRACKETS_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_FIVE_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_SUMM_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_SIX_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_CLOSE_BRACKETS_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_DIV_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_TWO_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_SUMM_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_EIGHT_BUTTON_XPATH, Duration.ofSeconds(10)).click();
        findByXpath(CALCULATOR_EQUALS_BUTTON_XPATH, Duration.ofSeconds(10)).click();
    }

    /**
     * Проверяем ожидаемый результат с фактическим
     *
     * @param expectedResult ожидаемый результат
     */
    public void validateResult(int expectedResult){
        WebElement result = findByXpath(RESULT_XPATH, Duration.ofSeconds(10));

        String errorMessage = String.format("[ОШИБКА]: Ожидаемый результат не совпадает с фактическим, " +
                "ожидалось - [%s], фактический результат - [%s]", expectedResult, result.getText());

        String errorMessageResultNotFind = String.format("[ОШИБКА]: Ожидаемое поле по локатору [%s] не было найдено",
                RESULT_XPATH);

        Assert.assertTrue(result.isDisplayed(), errorMessageResultNotFind);
        Assert.assertTrue(result.getText().equals(String.valueOf(expectedResult)), errorMessage);
    }

}
