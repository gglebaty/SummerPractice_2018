package com.company.Graphic.Model;
import java.util.ArrayList;
import java.awt.Color;

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

    public int getPrimeDivisor() {
        return primeDivisor;
    }

    public ArrayList<Square> getSquares(){
        ArrayList<Square> result = new ArrayList<Square>();
        for(int i = squares.length - 1 ; i >= 0 ; i--)
        {
            //System.out.println("array lenght:" + num.getLenght());
            int n = numberOfSquares[i];
            for(int j = numberOfSquares[i] - 1 ; j >= 0 ; j--)
            {
                Square new_square = new Square(squares[i] * scale, n);
               // new_square.setColor();
                result.add(new_square);
                //result.add(new Square(squares[i] * scale, n));
                n--;
            }
        }
        return result;
    }

    public int getLenght() { return squares.length; }

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
//
}
