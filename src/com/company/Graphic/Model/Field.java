package com.company.Graphic.Model;


public class Field {
    private int [][] field;
    private int size;
    private Model model;

    public Field(Model model, int size) {
        this.model = model;
        this.size = size;
        field = new int [size][size];
    }

    public boolean isPossible(int i, int j, Square square)
    {
        if ((i + square.getsize()) > size || (j + square.getsize()) > size)
            return false;
        for (int l = i; l < i + square.getsize(); l++)
            for (int m = j; m < j + square.getsize(); m++)
                if (field[l][m] != 0)
                    return false;
        return true;
    }

    public void insertSquare(Square square, int x, int y)
    {
        for (int i = x; i < x+square.getsize(); i++)
        {
            for (int j = y; j < y+square.getsize() ; j++)
            {
                field[i][j] = square.getsize();

            }
        }
        square.setxPosition(x);
        square.setyPosition(y);


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

    public void printField()
    {
        for (int i = 0 ; i < field.length ; i++)
        {
            for (int j = 0 ; j < field[i].length ; j++)
            {
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }
    }

    public void setField(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                this.field[i][j] = field[i][j];
            }
        }
    }

    public Field makeCopy()
    {
        Field field1 = new Field(model,size);
        field1.setField(field);
        return field1;
    }
}
