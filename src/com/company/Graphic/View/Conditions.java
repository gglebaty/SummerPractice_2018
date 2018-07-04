package com.company.Graphic.View;

import com.company.Graphic.Model.Square;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Conditions extends JPanel{
    private ArrayList<ArrayList<Square>> conditions;
    private int currentCondition;
    private int cellSize ;
    private int size;

    public Conditions(ArrayList<ArrayList<Square>> conditions, int size) {
        this.conditions = conditions;
        this.cellSize = 900/size;
        this.size = size;
        this.currentCondition = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLayout(null);
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g.fillRect(0,0,200,200);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                graphics2D.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
    }

    public void prev()
    {
        if(currentCondition>0)
            currentCondition--;
    }
    public void next()
    {
        if(currentCondition<conditions.size())
            currentCondition++;
    }

}
