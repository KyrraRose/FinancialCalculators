package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
        //Scanner!
        Scanner keyboard = new Scanner(System.in);

        //Welcome, start here:
        System.out.println("Welcome to your Friendly Neighborhood Financial Calculator!\nTo get started, I will need a bit of information from you.\nWhat is your name? ");
        String name = keyboard.nextLine();

        //Mortgage monthly payment calculation gets:
        //Get principal
        System.out.printf("Okay %s, please input the principal amount your loan is for. ", name);
        double principal = keyboard.nextDouble();
        keyboard.nextLine();//CRLF

        //Get interest
        System.out.println("What is the interest rate? ");
        double interestRate = keyboard.nextDouble();
        keyboard.nextLine();//CRLF

        //Get length
        System.out.println("How many months is the loan for? ");
        double length = keyboard.nextDouble();
        keyboard.nextLine();//CRLF

        //Pause for calculation
        System.out.printf("Thank you for sharing %s! Give me one moment to calculate.\n", name);

        //deliver results for mortgage monthly payment and total interest
        double monthlyPayment = calculateMonthlyMortgage(principal,interestRate,length);
        double totalInterest = (monthlyPayment * length) - principal;
        System.out.printf("Your monthly payment is:\n$%.2f for %.0f months\nYour total interest is:\n$%.2f", monthlyPayment, length, totalInterest);



    }
    //Time to use: M = P × (i * (1 + i )^n / ( (1 + i)^n ) - 1)
public static double calculateMonthlyMortgage(double principal,double interestRate,double length){
        return principal * (interestRate * (Math.pow((1 + interestRate), length) / (Math.pow((1 + interestRate), length) - 1)));

}
    
}
