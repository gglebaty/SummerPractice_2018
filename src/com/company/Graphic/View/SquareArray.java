package com.company.Graphic.View;

import com.company.Graphic.Model.Square;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SquareArray extends JPanel {

    private ArrayList<ArrayList<Square>> conditions;
    private int currentCondition;
    private int cellSize ;

    public SquareArray(ArrayList<ArrayList<Square>> conditions, int size) {
        this.conditions = conditions;
        this.currentCondition = 0;
        this.cellSize = 900/size;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        //setPreferredSize(new Dimension(900,900));
        setLayout(new FlowLayout(FlowLayout.CENTER));

        for (Square s:conditions.get(currentCondition)
                ) {
            if(!s.isInField())
                add(s);
        }
        revalidate();
        repaint();
    }
}
