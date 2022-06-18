public class SimpleStringCalculator {

    int add(String numbers){

        int sum = 0;
        int i = 0;
        String number  = "";

        for (Character n: numbers.toCharArray()){
            i++;
            if (n.equals(',')){
                sum += Integer.parseInt(number);
                number  = "";
                continue;
            }
            number += Character.toString(n);
            if (i == numbers.length()){
                sum += Integer.parseInt(number);
                break;
            }
        }
        return sum;
    }
}
