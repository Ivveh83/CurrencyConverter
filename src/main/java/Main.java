import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        final int EXITNUMBER = 0;
        final int MAXINPUTNUMBER = 4;
        final int EXCEEDSMAXINPUTNUMBER = 5;

        int userChoice;
        double amountToConvert;
        String convertedAmountMessage, formattedDateTimeMessage;

        Scanner scanner = new Scanner(System.in);
        CurrencyConverter currencyConverter = new CurrencyConverter();

        Display.displayMenu();
        do {
            userChoice = currencyConverter.makeChoice(scanner);
            if (userChoice > EXITNUMBER && userChoice <= MAXINPUTNUMBER) {
                amountToConvert = currencyConverter.enterAmount(scanner, userChoice);
                convertedAmountMessage = currencyConverter.convertCurrency(userChoice, amountToConvert);
                formattedDateTimeMessage = DateTime.getDateAndTime();
                Display.displayResult(formattedDateTimeMessage, convertedAmountMessage);
                currencyConverter.shouldDisplayMenu(scanner);
                userChoice = EXCEEDSMAXINPUTNUMBER;
            }
        }while (userChoice != EXITNUMBER);
        Display.displayGoodBye();
        scanner.close();
    }
}

 /*
TODO 1 Menu Display: The application should display a menu to the user with options to convert between
  different currencies or exit the program.
TODO 2 User Input Handling: The application should capture user input for menu choices and currency
 amounts.
 TODO 3 Currency Conversion: The application should accurately convert amounts between SEK, USD, and
  Euro using predefined exchange rates.
  TODO 4 Formatted Output: The application should display conversion results in a formatted manner
   along with the current date and time.
   TODO 5 Data Validation: The application should handle invalid inputs gracefully (e.g., non-numeric
    values, negative amounts).

Code Structure: The application should be well-structured using classes and methods for clarity and
maintainability.
 */