import java.util.Locale;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        Locale.setDefault(Locale.US);

        final int EXITNUMBER = 0;
        final int MAXINPUTNUMBER = 4;
        final int EXCEEDSMAXINPUTNUMBER = 5;

        int userChoice = EXCEEDSMAXINPUTNUMBER;
        double amountToConvert = -1;
        String convertedAmountMessage, formattedDateTimeMessage, displayMenu = "yes";

        Scanner scanner = new Scanner(System.in);
        CurrencyConverter currencyConverter = new CurrencyConverter();


        do {
            if (userChoice > EXITNUMBER && userChoice <= MAXINPUTNUMBER) {
                do {
                    System.out.print("Enter an amount: ");
                    try{
                        amountToConvert = scanner.nextDouble();
                        scanner.nextLine();
                        if (amountToConvert > 0){
                            convertedAmountMessage = currencyConverter.convertCurrency(userChoice, amountToConvert);
                            formattedDateTimeMessage = DateTime.getDateAndTime();
                            Display.displayResult(formattedDateTimeMessage, convertedAmountMessage);
                            amountToConvert = -1;
                            userChoice = EXCEEDSMAXINPUTNUMBER;
                            System.out.print("Show Display Menu? Type (yes/no): ");
                            try {
                                displayMenu = scanner.nextLine().toLowerCase();
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        }else {
                            Display.displayError(1);
                        }
                    }catch (InputMismatchException e){
                        Display.displayError(2);
                        scanner.nextLine();
                    }catch (Exception e){
                        System.out.println("Something went wrong");
                        scanner.nextLine();
                    }
                }while (amountToConvert < 0);
                userChoice = EXCEEDSMAXINPUTNUMBER;
            }else {
                if (displayMenu.equals("yes")){
                    Display.displayMenu();
                    displayMenu = "no";
                }
                System.out.print("Enter number of choice: ");
                try{
                    userChoice = scanner.nextInt();
                    if (userChoice >= EXCEEDSMAXINPUTNUMBER){
                        Display.displayError(3);
                    }
                }catch (InputMismatchException e){
                    Display.displayError(4);
                }catch (Exception e){
                    System.out.println("Something went wrong with Number of Choice");
                }finally {
                    scanner.nextLine();
                }
            }
        }while (userChoice != EXITNUMBER);
        Display.displayGoodBye();
        scanner.close();
    }
}