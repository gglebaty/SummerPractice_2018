package com.company.Graphic;

import java.util.ArrayList;
import java.util.Vector;

public final class PrimeNumbers {
    static int[][] squares = {
            { 1 },
            { 1 , 2 },
            { 1, 2 ,3 },
            { 1, 2, 3, 4 },
            { 1, 2, 3, 5, 6 },
            { 1, 2, 3, 4, 6, 7 },
            { 1, 2, 3, 4, 5, 8, 9 },
            { 1, 3, 4, 5, 6, 9, 10 },
            { 1, 2, 3, 4, 6, 7, 10, 13 },
            { 1, 3, 4, 5, 6, 7, 13, 16 },
            { 1, 2, 4, 8, 15, 16 },
            { 2, 3, 4, 5, 9, 11, 17, 20 }};
    static int[][] numberOfSquares = {
            { 4 },
            { 5, 1 },
            { 4, 3, 1 },
            { 3, 3, 2, 1 },
            { 4, 1, 3, 2, 1 },
            { 2, 3, 2, 1, 2, 1 },
            { 2, 3, 1, 2, 1, 2, 1 },
            { 1, 4, 2, 3, 1, 1, 1 },
            { 2, 3, 1, 1, 2, 1, 2, 1 },
            { 1, 2, 2, 3, 2, 1, 2, 1 },
            { 3, 3, 3, 3, 2, 1 },
            { 2, 3, 3, 1, 2, 1, 2, 1 }
    };
    static int lenght;

    public static int[] getSquares(int primeNumber)
    {
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        for (int i = 0; i < 12; i++)
            if (primeNumber == primeNumbers[i])
                return squares[i];
        return null;
    }

    public static int[] getNumberOfSquares(int primeNumber)
    {
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        for (int i = 0; i < 12; i++)
            if (primeNumber == primeNumbers[i])
                return numberOfSquares[i];
        return null;
    }


}
