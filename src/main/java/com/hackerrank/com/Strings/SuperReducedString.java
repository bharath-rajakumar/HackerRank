package com.hackerrank.com.Strings;

import java.util.Scanner;

/**
 * Created by bharathrajakumar on 9/10/16.
 */
public class SuperReducedString {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Get the input STDIN
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder reduced = new StringBuilder(input);
        boolean isReduced = false;
        int count = 0; //keeps track of the iteration count
        while(!isReduced) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < reduced.length(); i++) {
                if(i == reduced.length() - 1) {
                    temp.append(reduced.charAt(i));
                } else if(reduced.charAt(i) == reduced.charAt(i+1)) {
                    //skip the i+1th iteration
                    i++;
                } else {
                    //append the non-pair character
                    temp.append(reduced.charAt(i));
                }
            }
            count++;
            //System.out.println("Iteration: " + count + ", Reduced String : " + temp);
            //check if the length of previous iteration and current iteration have the same length
            if(temp.length() == reduced.length()) {
                isReduced = true;
            } else {
                isReduced = false;
                if(temp.length() == 0) {
                    reduced.setLength(0);
                    isReduced = true;
                } else {
                    //update reduced string
                    reduced.setLength(0);
                    reduced = temp;
                }
            }
        }
        if(reduced.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println(reduced);
        }
    }
}
