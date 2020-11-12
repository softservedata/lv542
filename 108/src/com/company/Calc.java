package com.company;

public class Calc  {
    public int calculate(int n)
    {
        int p=1;
        int r=0;
        do {
            r++;
            p=(int)Math.pow(2,r);

        }
        while (p<=n);
        return p;
    }
}