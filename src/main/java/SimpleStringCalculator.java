public class SimpleStringCalculator {

    int add(String numbers){

        int sum = 0;
        int i = 0;
        String number  = "";
        boolean first = false;

        for (Character n: numbers.toCharArray()){
            i++;
            if (n.equals(',') && !first){
                sum += Integer.parseInt(number);
                number  = "";
                first = true;
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
