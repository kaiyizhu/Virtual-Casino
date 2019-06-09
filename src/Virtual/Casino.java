/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Casino;
package Virtual;

/**
 * Author: 335550372 Class: ICS3U
 *
 * Program: Assignment X Question Y Input: (explain what is being input into the
 * program) Processing: (explain what is being done) Output: (Result of the
 * program)
 *
 */
//Import Statements Listed Alphabetically

import hsa.*;
import hsa.Console;
import java.io.*;           //used for any type of input or ouAtput
import java.util.*;         //useful utilities like Scanner
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

/**
 *
 * @author 335550372
 */
public class Casino
{

    /**
     * * MAIN METHOD
     *
     **
     * @param args
     */
    static double money;
    static String name;

    public static void main(String[] args)
    {

        /*Ask the user to enter name
         Welcome them to the casino and show them 3 choices: Dice, Roulette and Cash out
         Make a method for each choice
         */
        
        System.out.println("Starting...");
           
        Console c = new Console(20, "Casino2000");
        Random r = new Random();
        money = 1000;
        skillTest(c, r);
        c.println("Please enter your name: ");
        name = c.readLine();
        c.clear();
        c.println("Welcome to Casino2000 " + name + "!");
        wait(c, 3000);
        c.clear();
        menu(c, r);
    }

    public static void menu(Console c, Random r)
    {
        c.drawRect(10, 100, 940, 140);
        c.drawRect(10, 250, 940, 140);
        c.drawRect(10, 400, 940, 140);
        c.setFont(new Font("Arial", Font.BOLD, 30));
        c.println("Enter your number here: ");
        c.setColor(Color.green);
        c.drawString("Bal: " + money, 750, 70);
        c.setColor(Color.black);
        c.drawString("1. Dice", 450, 180);
        c.drawString("2. Roulette", 425, 330);
        c.drawString("3. Cash Out", 420, 480);
        c.drawString("Please choose an option", 335, 600);
        int choice = c.readInt();
        switch (choice)
        {
            case 1:
                c.clear();
                c.println("Welcome to: Dice");
                dice(c, r);
                wait(c, 2000);
                break;
            case 2:
                c.clear();
                c.println("Welcome to: Roulette!");
                roulette(c, r);
                wait(c, 2000);
                break;
            case 3:
                cashOut(c);
                break;
            default:
                c.println("Invalid number, please choose again: ");
                c.clear();
                menu(c, r);
        }
    }

    public static void dice(Console c, Random r)
    {
        c.println("Please enter the amount you would like to bet: ");
        double bet = c.readDouble();
                while(true){
        if (bet > money){
            c.println("Invalid balance, please choose again: ");
            bet = c.readDouble();
        }
        else if(bet <= 0){
            c.println("Invalid number, please choose again: ");
            bet = c.readDouble();
        }
        else{
            break;
        }
        }
        money = money - bet;
        c.println("Please choose a random number from 3-12: ");
        c.setColor(Color.green);
        c.drawString("Bal: " + money, 750, 70);
        c.setColor(Color.black);
        int numChoose = c.readInt();
        while (true)
        {
            //if number is from 3-12
            if (numChoose == 3 || numChoose == 4 || numChoose == 5 || numChoose == 6 || numChoose == 7 || numChoose == 8 || numChoose == 9 || numChoose == 10 || numChoose == 11 || numChoose == 12)
            {
                c.println("Rolling dice #1: ");
                wait(c, 2000);
                //prints a random number from 1-6
                int diceOne = r.nextInt(6) + 1;
                c.println("The 1st number is: " + diceOne);
                wait(c, 1000);
                c.println("Rolling dice #2: ");
                wait(c, 2000);
                //prints a random number from 1-6
                int diceTwo = r.nextInt(6) + 1;
                c.println("The 2nd number is: " + diceTwo);
                wait(c, 1000);
                //adds the two numbers together
                int totalDice = diceOne + diceTwo;
                c.println("The winning number is: " + totalDice);
                //prints "You won!" if the guess was equal to the combined sum of the 2 dices
                if (totalDice == numChoose)
                {
                    money = money + bet * 6;
                    c.println("You won! Your new balance is :" + money);
                    playAgain1(c, r);
                } //if both dices are 1, print snake-eyes and rerolls dice
                else if (totalDice == 2)
                {
                    c.println("Snake-eyes\nRerolling:");
                    wait(c, 2000);
                } //if guess does not equal to the combined sum of the 2 dices
                else
                {
                    c.println("You lose.");
                    if (money == 0)
                        {   
                            wait(c, 3000);
                            c.clear();
                            c.println("Oh dear, seems like you have ran out of cash! Better luck next time!");
                            wait(c, 5000);
                            c.close();
                        }
                    playAgain1(c, r);
                }
            } //if user does not enter a number from 3-12, ask them to re-enter their number
            else
            {
                c.println("Invalid number, please choose a number from 3-12: ");
                numChoose = c.readInt();
            }
        }
    }

    public static void roulette(Console c, Random r)
    {
        c.println("Please enter the amount you would like to bet: ");
        double bet = c.readDouble();
        while(true){
        if (bet > money){
            c.println("Invalid balance, please choose again: ");
            bet = c.readDouble();
        }
        else if(bet <= 0){
            c.println("Invalid number, please choose again: ");
            bet = c.readDouble();
        }
        else{
            break;
        }
        }
        money = money - bet;
        c.println("Please choose a colour: \"red\" \"black\" or \"green\"");
        String choice = c.readString();
        choice = choice.toLowerCase();
        c.setColor(Color.green);
        c.drawString("Bal: " + money, 750, 70);
        c.setColor(Color.black);
        while (true)
        {
            if (choice.equals("red") || choice.equals("black") || choice.equals("green"))
            {
                c.println("Rolling...");
                wait(c, 3000);
                int rouletteSpin = r.nextInt(26);
                String colour;
                if (rouletteSpin == 0)
                {
                    colour = "green";
                    if (colour.equals(choice))
                    {
                        money = money + bet * 14;
                        c.println("The winning number is: " + rouletteSpin + ", " + colour + ". You won! Your new balance is :" + money);
                        playAgain2(c, r);
                    } else if (!colour.equals(choice))
                    {
                        c.println("The winning number is: " + rouletteSpin + ", " + colour + ". You lost!");
                        if (money == 0)
                        {   
                            wait(c, 3000);
                            c.clear();
                            c.println("Oh dear, seems like you have ran out of cash! Better luck next time!");
                            wait(c, 5000);
                            c.close();
                        }
                        playAgain2(c, r);
                    }
                } else if (rouletteSpin == 1 || rouletteSpin == 2 || rouletteSpin == 3 || rouletteSpin == 4 || rouletteSpin == 5 || rouletteSpin == 6 || rouletteSpin == 7)
                {
                    colour = "red";
                    if (colour.equals(choice))
                    {
                        money = money + bet * 2;
                        c.println("The winning number is: " + rouletteSpin + ", " + colour + ". You won!  Your new balance is :" + money);
                        playAgain2(c, r);
                    } else if (!colour.equals(choice))
                    {
                        c.println("The winning number is: " + rouletteSpin + ", " + colour + ". You lost!");
                        if (money == 0)
                        {   
                            wait(c, 3000);
                            c.clear();
                            c.println("Oh dear, seems like you have ran out of cash! Better luck next time!");
                            wait(c, 5000);
                            c.close();
                        }
                        playAgain2(c, r);
                    }
                } else if (rouletteSpin == 8 || rouletteSpin == 9 || rouletteSpin == 10 || rouletteSpin == 11 || rouletteSpin == 12 || rouletteSpin == 13 || rouletteSpin == 14)
                {
                    colour = "black";
                    if (colour.equals(choice))
                    {
                        money = money + bet * 2;
                        c.println("The winning number is: " + rouletteSpin + ", " + colour + ". You won! Your new balance is :" + money);
                        playAgain2(c, r);
                    } else if (!colour.equals(choice))
                    {
                        c.println("The winning number is: " + rouletteSpin + ", " + colour + ". You lost!");
                        if (money == 0)
                        {   
                            wait(c, 3000);
                            c.clear();
                            c.println("Oh dear, seems like you have ran out of cash! Better luck next time!");
                            wait(c, 5000);
                            c.close();
                        }
                        playAgain2(c, r);
                    }
                }
            } else
            {
                c.println("Invalid choice, please choose a correct colour: ");
                choice = c.readString();
            }
        }
    }
    public static void cashOut(Console c)
    {
        c.clear();
        c.println("You have cashed out: " + money + "! Good work " + name + "!");
        wait(c, 5000);
        c.close();
    }
    
    //method asks if the user wants to play again. If yes, it will go back to the start of the method

    public static void playAgain1(Console c, Random r)
    {
        c.println("Would you like to play again?");
        while (true)
        {
            String yesno = c.readString();
            if (yesno.equalsIgnoreCase("Yes"))
            {
                c.println("Loading...");
                wait(c, 5000);
                c.clear();
                dice(c, r);
                break;
            } else if (yesno.equalsIgnoreCase("No"))
            {
                c.println("Would you like to return to the main menu?");
                while (true)
                {
                    String returnToMenu = c.readString();
                    if (returnToMenu.equalsIgnoreCase("Yes"))
                    {
                        c.println("Returning to menu...");
                        wait(c, 5000);
                        c.clear();
                        menu(c, r);
                        break;
                    } else if (returnToMenu.equalsIgnoreCase("No"))
                    {
                        c.close();
                    } else
                    {
                        c.println("Please say \"Yes\" or \"No\"");
                    }
                }
            } else
            {
                c.println("Please say \"Yes\" or \"No\"");
            }
        }
    }

    public static void playAgain2(Console c, Random r)
    {
        c.println("Would you like to play again?");
        while (true)
        {
            String yesno = c.readString();
            if (yesno.equalsIgnoreCase("Yes"))
            {
                c.println("Loading...");
                wait(c, 5000);
                c.clear();
                roulette(c, r);
                break;
            } else if (yesno.equalsIgnoreCase("No"))
            {
                c.println("Would you like to return to the main menu?");
                while (true)
                {
                    String returnToMenu = c.readString();
                    if (returnToMenu.equalsIgnoreCase("Yes"))
                    {
                        c.println("Returning to menu...");
                        wait(c, 5000);
                        c.clear();
                        menu(c, r);
                        break;
                    } else if (returnToMenu.equalsIgnoreCase("No"))
                    {
                        c.close();
                    } else
                    {
                        c.println("Please say \"Yes\" or \"No\"");
                    }
                }
            } else
            {
                c.println("Please say \"Yes\" or \"No\"");
            }
        }
    }

    public static void skillTest(Console c, Random r)
    {
        c.println("Please enter the following question in order to unlock the casino: ");
        //chooses two random numbers from 0 to 10
        int number1 = r.nextInt(10);
        int number2 = r.nextInt(10);
        //prints out a multiplication equation using the two random numbers
        c.println(number1 + " x " + number2 + " =");
        for (int i = 2; i >= 0; i--)
        {
            //gets input
            int userAnswer = c.readInt();
            //calculates the total of the 1st number multiplied by the 2nd number
            int total = number1 * number2;
            //if the answer is correct, allow the person to enter the casino
            if (userAnswer == total)
            {
                c.println("Good job! You passed!");
                wait(c, 2000);
                c.clear();
                c.println("Loading the Casino...");
                wait(c, 3000);
                c.clear();
                break;
                //if the person gets an incorrect answer 3 times, the program will exit
            } else if (i == 0)
            {
                c.println("Sorry, you have ran out of chance(s). Program will now exit.");
                wait(c, 3000);
                c.close();
                //if the person is wrong, it will print out "incorrect" and also print out the remaining chances. Loops back and re-asks for the answer.
            } else
            {
                c.println("Incorrect. You have " + i + " chance(s) remaining. Please try again: ");
            }

        }
    }

    public static void wait(Console c, int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
