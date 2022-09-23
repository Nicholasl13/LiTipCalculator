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
            totalGroup = scan.nextInt();
            scan.nextLine();
        }
        //declaring variables for the while loop
        double userInput = 0;
        double totalCost = 0;

        while(userInput != -1) {
            System.out.println("Enter a cost in dollars and cents (Type -1 to End): ");
            totalCost += userInput;
            userInput = scan.nextDouble();
        }

        //Begin printing out the code
        System.out.println("---------------------------------");
        System.out.println("Total Cost: $" + totalCost); //cost
        System.out.println("Tip Percentage: " + tipPercentage); //tip percentage

        double totalTip = ((totalCost*tipPercentage)/100); //total tip amount
        String formattedNum = formatter.format(totalTip);
        System.out.println("Total Tip: $" + formattedNum);
        String temp = formattedNum;

        double totalBill = (totalTip + totalCost);
        formattedNum = formatter.format(totalBill);

        System.out.println("Total Bill with Tip: $" + formattedNum);//total bill w/ tip

        double perPersonTotal = totalCost / totalGroup;
        formattedNum = formatter.format(perPersonTotal);
        System.out.println("Per Person Before Tip: $" + formattedNum);//total cost per person

        double tipPerPerson = totalTip / totalGroup;
        formattedNum = formatter.format(tipPerPerson);
        System.out.println("Per Person Tip: $" + formattedNum);//total tip per person

        double costPerPerson = (totalCost + totalTip) / 6;
        System.out.println("Cost per Person $" + costPerPerson);//total bill per person
    }
}
