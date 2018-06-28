package com.company.Graphic;

import java.util.ArrayList;

public class Number {
    private int number;
    private int scale;
    private int primeDivisor;
    private ArrayList<Integer> squares;
    private ArrayList<Integer> numberOfSquares;

    public Number(int number) {
        this.number = number;
        this.primeDivisor = findPrimeDivisor(number);
        this.scale = findScale(primeDivisor);
        this.squares = PrimeNumbers.getSquares(primeDivisor);
        this.numberOfSquares = PrimeNumbers.getNumberOfSquares(primeDivisor);
    }
    private int findPrimeDivisor(int number)
    {
        return 1;
    }
    private int findScale(int primeDivisor)
    {
        return 0;
    }

    public int getNumber() {
        return number;
    }

    public int getScale() {
        return scale;
    }

    public int getPrimeDivisor() {
        return primeDivisor;
    }
}
