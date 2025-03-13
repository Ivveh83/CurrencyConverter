import java.util.Locale;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

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

        final int EXITNUMBER = 0;
        final int MAXINPUTNUMBER = 4;
        final int EXCEEDSMAXINPUTNUMBER = 5;

        int userChoice = EXCEEDSMAXINPUTNUMBER;;
        double amountToConvert = -1;
        String convertedAmountMessage = "", formattedDateTimeMessage = "";

        Scanner scanner = new Scanner(System.in);
        CurrencyConverter currencyConverter = new CurrencyConverter();


        do {
            if (userChoice > EXITNUMBER && userChoice <= MAXINPUTNUMBER) {
                do {
                    System.out.print("Enter an amount: ");
                    try{
                        amountToConvert = scanner.nextDouble();
                        if (amountToConvert > 0){
                            convertedAmountMessage = currencyConverter.convertCurrency(userChoice, amountToConvert);
                            formattedDateTimeMessage = DateTime.getDateAndTime();
                            System.out.printf("""
                            ***************************
                            %s
                            %s
                            ***************************
                            """, formattedDateTimeMessage, convertedAmountMessage);
                        }else {
                            System.out.println("Enter a non negative amount");
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Enter a valid amount");
                    }catch (Exception e){
                        System.out.println("Something went wrong");
                    }finally {
                        scanner.nextLine();
                    }
                }while (amountToConvert < 0);
                userChoice = EXCEEDSMAXINPUTNUMBER;

            }else {
                MenuDisplay.displayMenu();
                try{
                    System.out.print("Enter a Number of Choice: ");
                    userChoice = scanner.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Enter a number from the Menu Display");
                }catch (Exception e){
                    System.out.println("Something went wrong");
                }finally {
                    scanner.nextLine();
                }
            }
        }while (userChoice != EXITNUMBER);
        System.out.println("Exiting Currency Converter");
        scanner.close();




    }
}
