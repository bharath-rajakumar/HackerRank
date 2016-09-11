package com.hackerrank.com.Strings;

import java.util.*;

/**
 * Created by bharathrajakumar on 9/10/16.
 */
public class TwoStrings {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        int p = Integer.parseInt(in.next());
        for(int i = 0; i < p; i++) {
//            System.out.println("Enter pair of words");
            String a = in.next();
            String b = in.next();
            pairs.add(new Pair(a, b));
        }

        for(int i = 0; i < p; i++) {
            if (pairs.get(i).hasCommonsubstrings()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }



    }

    static class Pair {
        String a;
        String b;
        public Pair(String a, String b) {
            this.a = convertToSet(a);
            this.b = convertToSet(b);
//            System.out.println("String A : " + this.a);
//            System.out.println("String B : " + this.b);
        }

        private String convertToSet(String input) {
            Set<Character> mySet = new TreeSet<Character>();
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < input.length(); i++) {
                mySet.add(input.charAt(i));
            }
//            System.out.println("Set : " + mySet.toString());
            Iterator<Character> itr = mySet.iterator();
            while(itr.hasNext()) {
                output.append(itr.next());
            }
            return output.toString();
        }

        public boolean hasCommonsubstrings() {
            for(int i = 0; i < a.length(); i++) {
                for(int j = 0; j < b.length(); j++) {
                    if(a.charAt(i) == b.charAt(j)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
