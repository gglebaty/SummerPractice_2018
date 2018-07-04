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
        //g.setColor(Color.red);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                graphics2D.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }

        for (Square s:conditions.get(currentCondition)
             ) {
            if(s.isInField())
                graphics2D.fill3DRect(s.getyPosition()*cellSize, s.getxPosition()*cellSize, cellSize*s.getsize(), cellSize*s.getsize(),true);
        }
    }

    public void prev()
    {
        if(currentCondition>0)
            currentCondition--;
    }
    public void next()
    {
        if(currentCondition<conditions.size()-1)
            currentCondition++;
    }

}
