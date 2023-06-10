/*************************************************************************
 *  Compilation:  javac CheckDigit.java
 *  Execution:    java CheckDigit 020131452
 *
 *  @author: Sammy Chopra sammy.chopra@rutgers.edu sc2364
 *
 *  Takes a 12 or 13 digit integer as a command line argument, then computes
 *  and displays the check digit
 *
 *  java CheckDigit 048231312622
 *  0
 *
 *  java CheckDigit 9780470458310
 *  0
 * 
 *  java CheckDigit 9780470454310
 *  8
 * 
 *  Print only the check digit character, nothing else.
 *
 *************************************************************************/

public class CheckDigit {

    public static void main (String[] args) {

        // WRITE YOUR CODE HERE
        //integer parse into long variable 

        long num = Long.parseLong(args[0]); 

        //create a while loop until the number equals 0 after divison 
        //in the loop add every other digit starting from the right most spot into 
        //firstSum. then add every other digit starting from the second to last into 
        //secondSum. 

        int firstSum = 0;
        int secondSum = 0;

        //boolean isFirst determines whether to add the digit to firstSum or secondSum
        boolean isFirst = true;

        while (num > 0){ 
            if (isFirst) {
            firstSum += num % 10;
            isFirst = false;
        }
            else {
            secondSum += num % 10;
            isFirst = true;
            }
            
            num/=10;
        }
        //discard the tens digit using mod from firstSum and secondSum
        firstSum %= 10; 
        secondSum %= 10;

        //multiply second sum by 3 and then take mod 10
        secondSum *= 3; 
        secondSum %= 10;

        //add the first sum and secodn sum then take mod 10
        System.out.println((firstSum + secondSum) % 10);

    }
}