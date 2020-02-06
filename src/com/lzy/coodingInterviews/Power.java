package com.lzy.coodingInterviews;
/**
 * 剑指offer 面试题16  数值的整数次方
 * 常规解法，注意指数为负数的时候需要取倒数，以及对0求倒数可能抛异常的问题
 * */
public class Power {

    public double Power(double base, int exponent) {

        if (base == 0 && exponent < 0) return 0;

        if (exponent < 0) return 1.0 / powerWithUnsigendExponent(base, Math.abs(exponent));

        return powerWithUnsigendExponent(base,exponent);
    }

    private double powerWithUnsigendExponent(double base, int exponent){
        double resulst = 1.0;
        for (int i = 1; i <= exponent; i++){
            resulst *= base;
        }
        return resulst;
    }

    public static void main(String[] args) {
        System.out.println(new Power().Power(0,-3));
    }

}
