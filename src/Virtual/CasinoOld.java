/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.io.*;           //used for any type of input or output
import java.util.*;         //useful utilities like Scanner
import hsa.Console;
import hsa.*;
import java.awt.Font;
import java.text.DecimalFormat;

/**
 *
 * @author 335550372
 */
public class CasinoOld {

    /**
     * * MAIN METHOD
     *
     **
     * @param args
     */
    public static void main(String[] args) {
        int a,b;
        a = 1;
        b = a+4;
        a = b+5;
        for (int i=1; i<10; i++)
            b = b+a;
        
        System.out.println("Starting...");
        
        //FIRST WRITE YOUR PSEUDOCODE USING COMMENTS, THEN FILL IN WITH CODE
        System.out.println("Starting...");
        int i;
        Console c = new Console(20, "Casino2000");
        double[] sgt = new double[5];
        int indx = 0;
        Random rd = new Random();
        
        sgt[0] = 34;
        sgt[1] = 56;
        sgt[2] = -102;
        sgt[3] = 18;
        sgt[4] = 5;
        
        c.println(sgt[1]);
    }
}