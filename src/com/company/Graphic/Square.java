package com.company.Graphic;

import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {
    private int size;
    private int xPosition;
    private int yPosition;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //g2.
    }

    public Square(int size) {
        this.size = size;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
