import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {
    LocalDate date = LocalDate.now();
    LocalDate toEstablish = date.plusDays(4);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String formatDate = toEstablish.format(formatter);

    @Test
    void shouldTestCardDelivery() throws InterruptedException {
        open("http://localhost:9999/");
        $("[class='input__control'][type='text']").setValue("Кострома");
        $("[class='input__control'][type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[class='input__control'][type='tel']").setValue(String.valueOf(formatDate));
        $("[class='input__control'][name='name']").setValue("Иванов Иван");
        $("[class='input__control'][name='phone']").setValue("+79998887766");
        $("[class='checkbox__box']").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(appear, Duration.ofSeconds(15));
    }
}