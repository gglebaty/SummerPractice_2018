package com.company.Graphic;

import java.util.ArrayList;

public class Model {
    private int size;
    private ArrayList<Square> squares;
    private Number num;
    private int [][] field;
    //private boolean wasFound = false;


    public Model(int size)
    {
        this.size = size;
        num = new Number(15);
        squares = new ArrayList<Square>();
        for(int i = 0; i < num.getLenght(); i++)
        {
            for(int j = 0; j < num.getAmount(i); j++)
            {
                squares.add(new Square(num.getSize(i)));
            }
        }
        field = new int [size][size];
    }
//
//    public boolean isWasFound() {
//        return wasFound;
//    }
//
//    public void setWasFound(boolean wasFound) {
//        this.wasFound = wasFound;
//    }

    public void printSquares(){
        for (Square a: squares
                ) {
            a.print();
        }
    }
    public void printField()
    {
        for (int[] a: field)
        {
            for (int j: a)
            {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    public void insertSquare(Square sq, int x, int y)
    {
        for (int i = x; i < x+sq.getSize(); i++)
        {
            for (int j = y; j < y+sq.getSize() ; j++)
            {
                field[j][i] = sq.getSize();
            }
        }
        sq.setInField(true);
    }

    public boolean isPossible(int i, int j, int k)
    {
        if ((i + num.getSquare(k)) > size || (j + num.getSquare(k)) > size)
            return false;
        for (int l = i; l < i + num.getSquare(k); l++)
            for (int m = j; m < j + num.getSquare(k); m++)
                if (field[l][m] != 0)
                    return false;
        return true;
    }

    public boolean isFreeCell(int i, int j)
    {
        for (int l = i; l < size; l++)
            for (int m = 0; m < size; m++)
                if (field[l][m] == 0)
                    return true;
        return false;
    }

    public int getNextI(int i, int j)
    {
        for (int l = i; l < size; l++)
            for (int m = 0; m < size; m++)
                if (field[l][m] == 0)
                    return l;
        return -1;
    }

    public int getNextJ(int i, int j)
    {
        for (int l = i; l < size; l++)
            for (int m = 0; m < size; m++)
                if (field[l][m] == 0)
                    return m;
        return -1;
    }

    public void go(Model table, int i, int j)
    {
        if (!Global.isWasFound())
        {
            for (int k = num.getLenght() - 1 ; i >= 0 ; i--)
            {
                Model condition = table;
                if(condition.isPossible(i,j,k))
                {
                    for (Square a: squares)
                    {
                        if(!a.isInField())
                            condition.insertSquare(a, i, j);
                    }
                    if (condition.isFreeCell(i, j))//check presence of free cells
                        condition.go(condition, condition.getNextI(i, j), condition.getNextJ(i, j));//go to free cell
                    else
                    {
                        condition.printField();// if there isn't possibility to put the square into the table, that means configuration was founded
                        Global.setWasFound(true); //to exit the recursive function
                        break;
                    }
                }
            }
        }
    }
}
