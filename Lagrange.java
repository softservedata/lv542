package com.softserve.academy.task88D;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.pow;

/**
 * Lagrange theorem n = a^2 + b^2 + c^2 + d^2
 * @author ACER
 *
 */
public class Lagrange {
    public List<LagrangeFifth> lang(int n) {
    	isNaturalDigit(n);
        List<LagrangeFifth> lagrangeList = new ArrayList<>();
        double squareRootN = Math.sqrt(n);
        for (int i =0; i <squareRootN; i++) {
            for (int j = 0; j < squareRootN; j++) {
                for (int k = 0; k < squareRootN; k++) {
                    for (int l = 0; l < squareRootN; l++) {
                        if (powSum(i, j, k, l, n) && unique(i, j, k, l)) {
                        	lagrangeList.add(new LagrangeFifth(i, j, k, l));
                        }
                    }
                }
            }
        }
        return lagrangeList;
    }
    
    public boolean powSum(int i, int j, int k, int l, int n) {
        return (int) (pow(i, 2) + pow(j, 2) + pow(k, 2) + pow(l, 2)) == n;
    }

    public boolean unique(int i, int j, int k, int l) {
        return i <= j && j <= k && k <= l;
    }
    
    public boolean isNaturalDigit(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Please enter n > 0");
		}
		return true;
	}
} 

