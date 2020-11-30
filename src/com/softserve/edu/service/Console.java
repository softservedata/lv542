package com.softserve.edu.service;

import java.util.Scanner;

public class Console {
    private Scanner scanner = null;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public int read() {
        System.out.print("num = ");
        return scanner.nextInt();
    }
    
    public void write(String message, double result) {
        System.out.print(message + result);
    }
    
    public void close() {
        scanner.close();
    }
}
