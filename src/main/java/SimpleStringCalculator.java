public class SimpleStringCalculator {

    int add(String numbers){

        int sum = 0;
        int i = 0;
        String number  = "";
        boolean newLine = false;
        boolean newDelimiter = false;
        boolean newDelimiter2 = false;
        boolean error = false;
        char delimiter = ',';

        for (Character n: numbers.toCharArray()){
            i++;
            if (newDelimiter2){
                delimiter = n;
                newDelimiter2 = false;
                continue;
            }
            if (n.equals('/')) {
                if (newDelimiter) {
                    newDelimiter2 = true;
                    newDelimiter = false;
                    continue;
                }
                newDelimiter = true;
                continue;
            }
            if (n.equals('\\') || newLine){
                if (n.equals('n')){
                    if (error){
                        System.out.println("operation not allowed");
                        sum = 0;
                        break;
                    }
                    System.out.println();
                    sum += Integer.parseInt(number);
                    number  = "";
                    newLine = false;
                    error = true;
                    continue;
                }
                newLine = true;
                continue;
            }
            if (n.equals(delimiter)){
                if (error){
                    System.out.println("operation not allowed");
                    sum = 0;
                    break;
                }
                sum += Integer.parseInt(number);
                number  = "";
                error = true;
                continue;
            }
            number += Character.toString(n);
            error = false;
            if (i == numbers.length()){
                sum += Integer.parseInt(number);
                break;
            }
            newDelimiter = false;
            newLine = false;
        }
        return sum;
    }
}
