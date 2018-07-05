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
    private int header = 50;

    public Conditions(ArrayList<ArrayList<Square>> conditions, int size) {
        this.conditions = conditions;
        this.cellSize = 860/size;
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
        g.setFont(new Font("TimesRoman",Font.PLAIN,80));
        graphics2D.drawString("Field", 430,70);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                graphics2D.drawRect(x * cellSize+header, y * cellSize+2*header, cellSize, cellSize);
            }
        }

        for (Square s:conditions.get(currentCondition)
             ) {
            if(s.isInField()) {
                graphics2D.setColor(s.getColor());
                graphics2D.fill3DRect(s.getyPosition() * cellSize + header, s.getxPosition() * cellSize + 2*header, cellSize * s.getsize(), cellSize * s.getsize(), true);
                graphics2D.setColor(Color.BLACK);
                graphics2D.setFont(new Font("TimesRoman",Font.PLAIN,cellSize*s.getsize()/8));
                graphics2D.drawString(s.getsize()+"",(int)(s.getyPosition() * cellSize + cellSize* s.getsize()/2 + header),(int)(s.getxPosition() *cellSize + cellSize* s.getsize()/2 + 2*header));
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
        if(currentCondition<conditions.size()-1)
            currentCondition++;
    }
    public void result()
    {
        currentCondition = conditions.size() -1;
    }

}
