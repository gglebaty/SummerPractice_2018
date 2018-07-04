package com.company.Graphic.Model;


import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private int [][] field;
    private int cellSize ;
    private int size;

    public Field(int size) {
        this.size = size;
        field = new int [size][size];
        cellSize = 900/size;
    }


    @Override
    protected void paintComponent(Graphics g) {
        setLayout(null);
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                graphics2D.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
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
        square.setxPosition(x);
        square.setyPosition(y);
       // add(square);
        //revalidate();
        //repaint();
        for (int i = x; i < x+square.getsize(); i++)
        {
            for (int j = y; j < y+square.getsize() ; j++)
            {
                field[i][j] = square.getsize();

            }
        }
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
        Field field1 = new Field(size);
        field1.setField(field);
        return field1;
    }
}
