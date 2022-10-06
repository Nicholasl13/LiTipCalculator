import java.text.DecimalFormat;
import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        //Welcomes user and asks for tip percentage
        System.out.println("Welcome to the Tip Calculator!");
        System.out.println("How many people are in your group?");
        int totalGroup = scan.nextInt();
        scan.nextLine();

        //Tip percentage
        System.out.println("What is the tip percentage? (0-100)");
        int tipPercentage = scan.nextInt();
        if (tipPercentage < 0 || tipPercentage > 100) {
            System.out.println("Please input a number from 1-100.");
            System.out.println("What is the tip percentage? (0-100)");
            tipPercentage = scan.nextInt();
            scan.nextLine();
        }

        TipCalculatorRunner stats = new TipCalculatorRunner(totalGroup, tipPercentage);

        //declaring variables for the while loop
        double userInput = 0;

        while(userInput != -1) {
            System.out.println("Enter a cost in dollars and cents (Type -1 to End): ");
             stats.addMeal(userInput);
            userInput = scan.nextDouble();
        }

        //Begin printing out the code
        System.out.println("---------------------------------");
        System.out.println("Total Cost: $" + stats.getTotalBillBeforeTheTip()); //cost
        System.out.println("Tip Percentage: " + stats.getTipPercentage()); //tip percentage

        String formattedNum = formatter.format(stats.tipAmount());
        System.out.println("Total Tip: $" + formattedNum);
        String temp = formattedNum;

        formattedNum = formatter.format(stats.totalBill());

        System.out.println("Total Bill with Tip: $" + formattedNum);//total bill w/ tip

        formattedNum = formatter.format(stats.perPersonCostBeforeTip());
        System.out.println("Per Person Before Tip: $" + formattedNum);//total cost per person

        formattedNum = formatter.format(stats.perPersonTipAmount());
        System.out.println("Per Person Tip: $" + formattedNum);//total tip per person

        formattedNum = formatter.format(stats.perPersonTotalCost());
        System.out.println("Cost per Person $" + formattedNum);//total bill per person
    }
}
