package com.softserve.edu;

import com.softserve.edu.service.Calc;
import com.softserve.edu.service.Console;

public class ApplCalc {
    public static void main(String[] args) {
        Console con = new Console();
        Calc calc = new Calc();
        con.write("sum = ", calc.add(con.read(), con.read()));
        con.close();
    }
}
