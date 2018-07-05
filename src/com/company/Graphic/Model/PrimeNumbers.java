package com.company.Graphic.Model;

import java.util.HashMap;
import java.util.Map;

public final class PrimeNumbers {
       private Map<Integer,int []> numberOfSquares = new HashMap<>();
       private Map<Integer, int []> squares = new HashMap<>();

    PrimeNumbers()
    {
        squares.put(2,new int[]{1});
        squares.put(3,new int[]{ 1 , 2 });
        squares.put(5,new int[]{ 1, 2 ,3 });
        squares.put(7,new int[]{ 1, 2, 3, 4 });
        squares.put(11,new int[]{ 1, 2, 3, 5, 6 });
        squares.put(13,new int[]{ 1, 2, 3, 4, 6, 7 });
        squares.put(17,new int[]{ 1, 2, 3, 4, 5, 8, 9 });
        squares.put(19,new int[]{ 1, 3, 4, 5, 6, 9, 10 });
        squares.put(23,new int[]{ 1, 2, 3, 4, 6, 7, 10, 13 });
        squares.put(29,new int[]{ 1, 3, 4, 5, 6, 7, 13, 16 });
        squares.put(31,new int[]{ 1, 2, 4, 8, 15, 16 });
        squares.put(37,new int[]{ 2, 3, 4, 5, 9, 11, 17, 20 });
        squares.put(41, new int[]{1,2,3,4,5,7,11,12,18,23});
        squares.put(43, new int[]{1,4,5,6,7,11,13,19,24});
        squares.put(47, new int[]{1,3,6,7,8,9,10,22,25});
        squares.put(53, new int[]{1,3,4,5,6,7,13,16,24,29});
        squares.put(59, new int[]{1,2,4,6,8,10,11,12,14,16,18,19,29,30});
        squares.put(61, new int[]{3,4,6,8,9,11,15,17,29,32});

        numberOfSquares.put(2,new int[]{4});
        numberOfSquares.put(3,new int[]{ 5, 1 });
        numberOfSquares.put(5,new int[]{ 4, 3, 1 });
        numberOfSquares.put(7,new int[]{ 3, 3, 2, 1 });
        numberOfSquares.put(11,new int[]{ 4, 1, 3, 2, 1 });
        numberOfSquares.put(13,new int[]{ 2, 3, 2, 1, 2, 1 });
        numberOfSquares.put(17,new int[]{ 2, 3, 1, 2, 1, 2, 1 });
        numberOfSquares.put(19,new int[]{ 1, 4, 2, 3, 1, 1, 1 });
        numberOfSquares.put(23,new int[]{ 2, 3, 1, 1, 2, 1, 2, 1 });
        numberOfSquares.put(29,new int[]{ 1, 2, 2, 3, 2, 1, 2, 1 });
        numberOfSquares.put(31,new int[]{ 3, 3, 3, 3, 2, 1 });
        numberOfSquares.put(37,new int[]{ 2, 3, 3, 1, 2, 1, 2, 1 });
        numberOfSquares.put(41, new int[]{2,2,2,1,1,1,2,1,2,1});
        numberOfSquares.put(43, new int[]{2,4,1,2,2,1,1,2,1});
        numberOfSquares.put(47, new int[]{1,3,1,2,3,2,1,2,1});
        numberOfSquares.put(53, new int[]{1,2,2,2,2,1,2,1,2,1});
        numberOfSquares.put(59, new int[]{2,1,2,1,1,2,1,1,1,1,1,1,1,1});
        numberOfSquares.put(61,new int[]{2,4,2,1,2,1,1,1,2,1});

    }

    public int[] getSquares(int primeNumber)
    {
        return squares.get(primeNumber);
    }

    public int[] getNumberOfSquares(int primeNumber)
    {
        return numberOfSquares.get(primeNumber);
    }


}
