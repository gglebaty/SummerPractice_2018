package com.company.Graphic.Model;

import sun.security.krb5.internal.crypto.CksumType;

import javax.swing.*;
import java.awt.*;

public class Square extends JComponent {
    private int size;
    private int xPosition;
    private int yPosition;
    private boolean inField;
    private int amount;

    public Square(int size, int n)
    {
        this.size = size;
        this.amount = n;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
           Graphics2D g2 = (Graphics2D) g;
           g.setColor(Color.pink);
           g2.drawRect(xPosition,yPosition,size,size);
    }
//

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

    public void setInField(boolean i){ this.inField = i; }

    public boolean isInField() {
        return inField;
    }

    public int getsize() {
        return size;
    }

    public int getAmount() { return amount; }

    public Square makeCopy()
    {
        Square s = new Square(size, amount);
        s.setxPosition(xPosition);
        s.setyPosition(yPosition);
        s.setInField(inField);
        return s;
    }
    public void print() { System.out.println(this.size); }
}
