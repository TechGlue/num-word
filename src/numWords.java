import java.util.Scanner;

public class numWords {

    //setting up numbers
    private String[] singleNumbers = {"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] teenNumbers = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen"
            ,"sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] tens = {"","", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private String[] misc = {"","thousand ", "million ", "billion "};

    public static void main (String[] args){

        numWords ref = new numWords();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter Number: ");
        String temp =  kb.nextLine();
        System.out.println("Successfully passed in: " + temp);

        String decimal = "";
        String decimalNum = "";
        String num = "";

        int index = 0;
        int numLength = temp.length();

        //grabbing the whole number
        while(index < numLength){
            if(temp.charAt(index) == '.'){
                break;
            }
            num += temp.charAt(index);
            index++;
        }
        //grabbing the remainder
        while (index < temp.length()){
            decimal += temp.charAt(index);
            decimalNum += temp.charAt(index);
            index++;
        }

        if(num.charAt(0) == '-'){
            System.out.println("Invalid value exiting program ...");
        }
        //printing num-words based on cases
        else if(decimal.isEmpty()){
            String target = ref.wordToNum(Integer.parseInt(num));
            target = Character.toUpperCase(target.charAt(0)) + target.substring(1,target.length());
            System.out.print(target + "and zero hundredths\n");
        }
        else{
            if(num.equals("")){
                num = "0";
            }
            //rounding to the hundredths
            double rightHalf = Double.parseDouble(decimalNum);
            rightHalf = rightHalf * 100;
            rightHalf = Math.round(rightHalf);

            String target = ref.wordToNum(Integer.parseInt(num));
            target = Character.toUpperCase(target.charAt(0)) + target.substring(1,target.length());
            System.out.print(target);
            System.out.print("and " + ref.wordToNum((int) rightHalf));
            System.out.print("hundredths\n");
        }
    }

    String wordToNum(int num){
        if(num == 0){
            return "zero ";
        }

        String word = "";
        int i = 0;

        while(num > 0){
            int tempNum = num % 1000;
            if(tempNum != 0){
                String str = lessThanThree(tempNum);
                word = str + " "+ misc[i] + word;
            }
            i++;
            num = num / 1000;
        }
        return word;
    }

    String lessThanThree (int number){
        String word = "";
        int num = number % 100;

        if(num < 10){
            word = word + singleNumbers[num];
        }
        else if( num < 20){
            word = word + teenNumbers[num % 10];
        }else{
            word = tens[num/10] + "-" +singleNumbers[num%10];
        }
        if(number/100 > 0){
            word = singleNumbers[number/100] + " hundred "+ word;
        }
        return word.trim();
    }
}
