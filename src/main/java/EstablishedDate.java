import java.time.format.DateTimeFormatter;

public class EstablishedDate {
    private String formattedBankVisitDate;

    public void setBankVisitDate(int daysAfterCurrentDate) {
        java.time.LocalDate date = java.time.LocalDate.now();
        java.time.LocalDate bankVisitDate = date.plusDays(daysAfterCurrentDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        formattedBankVisitDate = bankVisitDate.format(formatter);
    }

    public String getBankVisitDate() {
        return formattedBankVisitDate;
    }
}

