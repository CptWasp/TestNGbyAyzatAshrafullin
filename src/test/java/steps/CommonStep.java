package steps;

import org.testng.annotations.Test;
import pageObjects.CommonPage;

public class CommonStep extends Hooks {

    CommonPage commonPage = new CommonPage(driver);

     @Test(description = "Переходим по ссылке google.com", groups = "google.com calculator", priority = 1)
     public void userGoToUrl(){
         String url = "https://www.google.com/";
         String stepName = String.format("[ИНФОРМАЦИЯ]: 'Пользователь' открывает страницу '%s'", url);
         System.out.println(stepName);

         commonPage.openPage(url);
     }

     @Test(description = "В строке поиска ввести слово 'калькулятор'",  groups = "google.com calculator", priority = 2)
     public void typingCalcWordInSearchInput(){
         String theSearchWord = "калькулятор";
         String stepName = String.format("[ИНФОРМАЦИЯ]: В строке поиска ввести слово '%s'", theSearchWord);
         System.out.println(stepName);

         commonPage.searchingTheWord(theSearchWord);
     }

     @Test(description = "Проверить наличие калькулятора на экране", groups = "google.com calculator", priority = 3)
     public void checkCalculatorInPage(){
         String stepName = "[ИНФОРМАЦИЯ]: На странице проверяем наличие калькулятора";
         System.out.println(stepName);

         commonPage.checkCalculator();
     }

     @Test(description = "Используя нажатия клавиш калькулятора ввести требуемое выражение",
             groups = "google.com calculator", priority = 4)
     public void doRequiredExpressionOnCalculator(){
         String stepName = "[ИНФОРМАЦИЯ]: Используя нажатия клавиш калькулятора ввести требуемое выражение";
         System.out.println(stepName);

         commonPage.doRequiredExpression();
     }

}
