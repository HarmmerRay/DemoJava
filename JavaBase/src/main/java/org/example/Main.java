package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.ceil(-11.3));
        String s = "abcde";
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(stringBuilder.reverse().toString());
        System.out.println(s.substring(0,5));
        String s2 = "fghij";
        System.out.println(s.concat(s2));
        System.out.println(new String("1111") + new String("22222"));

        String s3 = "1,2,3,4,5,6,7";
        String [] strings= s3.split(",");
        for(String a : strings){
            System.out.println(a);
        }
    }
}