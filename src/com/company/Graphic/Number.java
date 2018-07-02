package com.company.Graphic;

import java.util.ArrayList;
import java.util.Arrays;

public class Number {
    private int number;
    private int scale;
    private int primeDivisor;
    private int[] squares;
    private int[] numberOfSquares;

    public Number(int number) {
        this.number = number;
        this.primeDivisor = findPrimeDivisor(number);
        this.scale = number / primeDivisor;
        this.squares = PrimeNumbers.getSquares(primeDivisor);
        this.numberOfSquares = PrimeNumbers.getNumberOfSquares(primeDivisor);
    }
    private int findPrimeDivisor(int number)
    {
        int div = 0;
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        for (int i = 0; i < 12; i++)
            if (number%primeNumbers[i] == 0)
                return primeNumbers[i];
        return -1;
    }

    /* private int findScale(int primeDivisor)
    {
        return 0;
    }*/

    public int getNumber() {
        return number;
    }

    public int getScale() {
        return scale;
    }

    public int getPrimeDivisor() {
        return primeDivisor;
    }

    public int getLenght() { return squares.length; }

    public int getSize(int i){ return squares[i]*scale; }

    public int getAmount(int i) { return numberOfSquares[i]; }

    public int getSquare(int i) { return squares[i]; }

    public void print(){
        System.out.println(this.number + " " + this.primeDivisor + " " + this.scale);
        for (int a: squares
             ) {
            System.out.println(a);
        }
        for (int a: numberOfSquares
             ) {
            System.out.println(a);
        }
    }

}
