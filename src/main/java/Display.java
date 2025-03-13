public class Display {

    static void displayMenu(){
        System.out.println("""
                ***************************
                Currency Converter App Menu
                ***************************
                  1. Convert SEK to USD
                  2. Convert USD to SEK
                  3. Convert SEK to Euro
                  4. Convert Euro to SEK
                  0. Exit
                ***************************""");
    }
    static void displayResult(String formattedDateTimeMessage, String convertedAmountMessage){
        System.out.printf("""
                            ***************************
                            %s
                            %s
                            ***************************
                            """, formattedDateTimeMessage, convertedAmountMessage);
    }
    static void displayError(int errorNumber){
        switch (errorNumber){
            case 1 ->
                System.out.println("""
                        ***************************
                        Enter a non negative amount
                        ***************************""");
            case 2 ->
                System.out.println("""
                        ***************************
                          Input must be of numbers
                        ***************************""");
            case 3 ->
                System.out.println("""
                ***************************
                Enter a number from the –
                menu display
                ***************************""");
            case 4 ->
                System.out.println("""
                ***************************
                Enter a NUMBER from the –
                menu display
                ***************************""");
        }
    }
    static void displayGoodBye(){
        System.out.println("""
        
        ***************************
               Welcome back!
        ***************************""");
    }

}

