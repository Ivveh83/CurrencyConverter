import java.util.InputMismatchException;
import java.util.Scanner;

class CurrencyConverter {

    final int EXCEEDSMAXINPUTNUMBER = 5;
    final int EXITNUMBER = 0;
    int userChoice = EXCEEDSMAXINPUTNUMBER;
    double oneDollarToSek = 10.13;
    double oneSekToDollar = 0.099;
    double oneEuroToSek = 11.03;
    double oneSekToEuro = 0.091;
    double result, amountToConvert;
    char dollarSign = '$';
    char euroSign = '€';
    String sekSign = "SEK";
    String displayMenu;


    int makeChoice(Scanner scanner){
        do {
            System.out.print("Enter number of choice: ");
            try{
                userChoice = scanner.nextInt();
                if (userChoice >= EXCEEDSMAXINPUTNUMBER || userChoice < EXITNUMBER){
                    Display.displayError(3);
                }else {
                    return userChoice;
                }
            }catch (InputMismatchException e){
                Display.displayError(4);
            }catch (Exception e){
                System.out.println("Something went wrong with Number of Choice");
            }finally {
                scanner.nextLine();
            }
        }while (true);
    }

    double enterAmount(Scanner scanner, int userChoice){
        do {
            System.out.print("Enter an amount: ");
            try{
                amountToConvert = scanner.nextDouble();
                scanner.nextLine();
                if (amountToConvert >= 0){
                    return amountToConvert;
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
        }while (true);
    }

    String convertCurrency(int userChoice, double amountToChange){
        switch (userChoice){
            case 1 -> {
                result = amountToChange * oneSekToDollar;
                return String.format("%s%.2f = %s%.2f", sekSign, amountToChange, dollarSign, result);
            }
            case 2 -> {
                result = amountToChange * oneDollarToSek;
                return String.format("%s%.2f = %s%.2f", dollarSign, amountToChange, sekSign, result);
            }
            case 3 -> {
                result = amountToChange * oneSekToEuro;
                return String.format("%s%.2f = %s%.2f", sekSign, amountToChange, euroSign, result);
            }
            case 4 -> {
                result = amountToChange * oneEuroToSek;
                return String.format("%s%.2f = %s%.2f", euroSign, amountToChange, sekSign, result);
            }
        }
        return "Something went wrong with Currency Converting";
    }

    void shouldDisplayMenu(Scanner scanner){
        System.out.print("Show Display Menu? Type (yes/no): ");
        try {
            displayMenu = scanner.nextLine().toLowerCase();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (displayMenu.equals("yes")){
            Display.displayMenu();
        }
    }
}
