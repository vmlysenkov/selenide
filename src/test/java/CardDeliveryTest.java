import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {

    @Test
    void shouldTestCardDelivery() {
        EstablishedDate date = new EstablishedDate();
        date.setBankVisitDate(4);
        String formattedBankVisitDate = date.getBankVisitDate();
        open("http://localhost:9999/");
        $("[class='input__control'][type='text']").setValue("Кострома");
        $("[class='input__control'][type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[class='input__control'][type='tel']").setValue(String.valueOf(formattedBankVisitDate));
        $("[class='input__control'][name='name']").setValue("Иванов Иван");
        $("[class='input__control'][name='phone']").setValue("+79998887766");
        $("[class='checkbox__box']").click();
        $(withText("Забронировать")).click();
        $(withText("Встреча успешно")).shouldBe(appear, Duration.ofSeconds(15)).shouldHave(text(formattedBankVisitDate));
    }
}