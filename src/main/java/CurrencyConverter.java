

class CurrencyConverter {

    double oneDollarToSek = 10.13;
    double oneSekToDollar = 0.099;
    double oneEuroToSek = 11.03;
    double oneSekToEuro = 0.091;
    double result;
    char dollarSign = '$';
    char euroSign = '€';
    String sekSign = "SEK";




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

}
