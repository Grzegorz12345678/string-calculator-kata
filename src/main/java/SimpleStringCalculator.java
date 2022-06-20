import java.util.ArrayList;
import java.util.List;

public class SimpleStringCalculator {

    int add(String numbers) throws NegativesNotAllowedException {

        int sum = 0;
        int i = 0;
        String number  = "";
        boolean newLine = false;
        boolean newDelimiter = false;
        boolean newDelimiter2 = false;
        boolean error = false;
        char delimiter = ',';
        boolean negative = false;
        boolean negative2 = false;
        boolean negative3 = false;
        List<Integer> negatives = new ArrayList<>();

        for (Character n: numbers.toCharArray()){
            i++;
            if (negative){
                String addToList = Character.toString(n);
                addToList = "-" + addToList;
                int add = Integer.parseInt(addToList);
                negatives.add(add);
                negative = false;
                negative2 = true;
                if (i == numbers.length() && negative3){
                    throw new NegativesNotAllowedException("negatives not allowed" + negatives);
                }
                continue;
            }
            if (isNegative(n)){
                negative = true;
                negative3 = true;
                continue;
            }
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
            if ((n.equals('\\') || newLine) && !negative2){
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
            if (n.equals(delimiter) && !negative2){
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
            if (number.contains(",")){
                String newNumber = "";
                for (char num : number.toCharArray()){
                    if (num != ','){
                        newNumber += Character.toString(num);
                    }
                }
                number = newNumber;
            }
            number += Character.toString(n);
            error = false;
            if (i == numbers.length() && !negative2){
                if (!negatives.isEmpty()){
                    if (negative3){
                        throw new NegativesNotAllowedException("negatives not allowed" + negatives);
                    }
                }
                    sum += Integer.parseInt(number);
                break;
            }
            newDelimiter = false;
            newLine = false;
            negative2 = false;
        }
        return sum;
    }

    public static boolean isNegative(char n){
        return n == '-';
    }
}
