import java.util.Scanner;

public class numWords {

    //setting up numbers
    private String[] singleNumbers = {" ","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] teenNumbers = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen"
            ,"sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] tens = {"","", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private String[] misc = {"","thousand", "million", "billion"};

    public static void main (String[] args){
        numWords ref = new numWords();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int temp =  kb.nextInt();
        System.out.println("Successfully passed in: " + temp);
        System.out.println(ref.wordToNum(temp));



    }

    String wordToNum(int num){
        String word = " ";
        int i = 0;

        while(num > 0){
            int tempNum = num % 1000;
            if(tempNum != 0){
                String str = lessThanThree(tempNum);
                word = str + " "+ misc[i] +" "+ word + " ";
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
        return word;
    }
}
