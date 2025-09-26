package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
        //Scanner!
        Scanner keyboard = new Scanner(System.in);

        //Welcome, start here:
        System.out.println("Welcome to your Friendly Neighborhood Financial Calculator!\nTo get started, I will need a bit of information from you.\nWhat is your name?");
        String name = keyboard.nextLine();
        //Bring in the menu
        System.out.printf("What would you like to do today %s?",name);
        calcOptions();
        int option = keyboard.nextInt();
        keyboard.nextLine();//CRLF

        //menu options below
        if (option == 1) { // Mortgage calculation, variables noted with M
            //calculation gets:
            //Get principal
            System.out.printf("You would like to calculate your mortgage's monthly payment?\nOkay %s, please input the principal amount your loan is for. ", name);
            double principalM = keyboard.nextDouble();
            keyboard.nextLine();//CRLF

            //Get interest
            System.out.println("What is the interest rate? ");
            double interestRateM = keyboard.nextDouble();
            keyboard.nextLine();//CRLF

            //Get length
            System.out.println("How many years is the loan for? ");
            double lengthYearsM = keyboard.nextDouble();
            keyboard.nextLine();//CRLF
            double lengthM = lengthYearsM*12;

            //Pause for calculation
            thankYou(name);

            //deliver results for mortgage monthly payment and total interest
            double monthlyPaymentM = calculateMonthlyMortgage(principalM, interestRateM, lengthM);
            double totalInterestM = (monthlyPaymentM * lengthM) - principalM;
            System.out.printf("Your monthly payment is:\n$%.2f for %.0f months\nYour total interest is:\n$%.2f", monthlyPaymentM, lengthM, totalInterestM);


        }else if (option == 2){ //Option 2, CD future value calculation, variables notated with C
            //Get deposit amount
            System.out.printf("You would like to calculate the future value of your CD? Sure thing, %s!\nWhat is your deposit amount?",name);
            double depositC = keyboard.nextDouble();
            keyboard.nextLine();//CRLF

            //Get interest
            System.out.println("Okay! Now, what is the interest rate for this account?\nPlease enter the interest rate as a decimal.");
            double interestRateC = keyboard.nextDouble();
            keyboard.nextLine();//CRLF

            //Get account length
            System.out.println("How many years did you want the account open for?");
            double timeOpenC = keyboard.nextDouble();
            keyboard.nextLine();//CRLF

            //Pause for calculation
            thankYou(name);

            //Math!
            double futureValueC = calculateCDValue(depositC,interestRateC,timeOpenC);
            double totalInterestC = futureValueC - depositC;
            System.out.printf("Good news, %s! The future value of your CD will be: $%.2f\nThe total interest you will have accrued is: $%.2f",name,futureValueC,totalInterestC);


        }else if (option == 3){ //present value of Annuity, variables noted with A

            //Get monthly payment
            System.out.printf("You would like to calculate how much to invest in an annuity account? Sure, %s.\nWhat is the monthly payment you would like in the future?",name);
            double monthlyPaymentA = keyboard.nextDouble();
            keyboard.nextLine();//CRLF

            //Get interest rate
            System.out.println("What is the expected interest rate for the account? Please use decimals.");
            double interestRateA = keyboard.nextDouble();
            keyboard.nextLine();//CRLF

            //Get payment period length
            System.out.println("How many years would you need payments to be made for?");
            double paymentPeriodA = keyboard.nextDouble();
            keyboard.nextLine();//CRLF

            //Please hold!
            thankYou(name);
            double annuityPresentA = calculateAnnuity(monthlyPaymentA,interestRateA,paymentPeriodA);

            //Results!
            System.out.printf("To have monthly payments of $%.2f over %.0f months, your annuity account will need: $%.2f",monthlyPaymentA,paymentPeriodA,annuityPresentA);



        } else{
            System.out.printf("The option you selected is not listed! Please try again %s.",name);
        }


    }

    public static void calcOptions() {
        System.out.println("\n==== Calculator Options ====\n1. Monthly Mortgage Payment\n2. CD Future Value\n3. Annuity Present Value\n\nPlease input the corresponding number.");

    }

    //Time to use: M = P × (i * (1 + i )^n / ( (1 + i)^n ) - 1) for mortgages
    public static double calculateMonthlyMortgage(double principalM,double interestRateM,double lengthM){
        return principalM * (interestRateM * (Math.pow((1 + interestRateM), lengthM) / (Math.pow((1 + interestRateM), lengthM) - 1)));

    }
    //CD use: FV = P × (1 + (r / 365) )^(365 × t)
    public static double calculateCDValue(double depositC,double interestRateC,double timeOpenC){
        return depositC*Math.pow((1+(interestRateC/365)),(365*timeOpenC));
    }

    public static double calculateAnnuity(double monthlyPaymentA, double interestRateA, double paymentPeriodA) {
        return monthlyPaymentA * ((1 - Math.pow((1 + interestRateA), -paymentPeriodA)) / interestRateA);
    }

    public static void thankYou(String name){
    System.out.printf("Thank you for sharing %s! Give me one moment to calculate.\n\n",name);
    }
}
