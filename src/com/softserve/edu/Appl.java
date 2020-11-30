package com.softserve.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Appl {

    // NOT Testability
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int result = 0;
        System.out.println("Hello");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("a = ");
            a = Integer.parseInt(br.readLine());
            System.out.print("b = ");
            b = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("Integer.parseInt() Error");
            throw new RuntimeException("Integer.parseInt() Error");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("br.readLine() Error");
        } finally {
            try {
                System.out.println("Now is br.close()");
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                System.out.println("br.close() Error");
            }
        }
        result = a + b;
        System.out.println("result = " + result);
    }
}
