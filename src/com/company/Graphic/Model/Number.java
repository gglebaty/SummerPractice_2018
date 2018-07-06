package com.company.Graphic.Model;
import java.util.ArrayList;
import java.awt.Color;

public class Number {
    private int scale;
    private int[] squares;
    private int[] numberOfSquares;

    Number(int number) {
        int primeDivisor = findPrimeDivisor(number);
        this.scale = number / findPrimeDivisor(number);
        PrimeNumbers primeNumbers = new PrimeNumbers();
        this.squares = primeNumbers.getSquares(primeDivisor);
        this.numberOfSquares = primeNumbers.getNumberOfSquares(primeDivisor);
    }
    private int findPrimeDivisor(int number)
    {
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        for (int i = 0; i < primeNumbers.length; i++)
            if (number%primeNumbers[i] == 0)
                return primeNumbers[i];
        return -1;
    }

    public ArrayList<Square> getSquares(){
        ArrayList<Square> result = new ArrayList<Square>();
        for(int i = squares.length - 1 ; i >= 0 ; i--)
        {
            int n = numberOfSquares[i];
            for(int j = numberOfSquares[i] - 1 ; j >= 0 ; j--)
            {
                Square new_square = new Square(squares[i] * scale, n);
                result.add(new_square);
                n--;
            }
        }
        return result;
    }
}
