package com.company.Graphic.Model;

import sun.security.krb5.internal.crypto.CksumType;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.Random;

public class Square extends JComponent {
    private int size;
    private int xPosition;
    private int yPosition;
    private boolean inField;
    private int amount;
    private Colors color;

    public enum Colors
    {
        THISTLE,//(216, 191, 216),
        ORCHID,//(218, 112, 214),
        MEDIUMPURPLE,//(147, 112, 219),
        LIGHTSTEELBLUE,//(176, 196, 222),
        DARKMAGENTA,//(139, 0, 139),
        PALETURQUOISE,//(175, 238, 238),
        LIGHTSLATEGREY,//(119, 136, 153),
        PEACHPUFF,//(255, 218, 185);
    };

    public void setColor()
    {
        int r = new Random().nextInt(Colors.values().length);
        color = Colors.values()[r];
    }

    public Color getColor()
    {
        switch (color)
        {
            case ORCHID:
                return new Color(218, 112, 214);
            case THISTLE:
                return new Color(216, 191, 216);
            case MEDIUMPURPLE:
                return new Color(147, 112, 219);
            case LIGHTSTEELBLUE:
                return new Color(176, 196, 222);
            case DARKMAGENTA:
                return new Color(139, 0, 139);
            case PALETURQUOISE:
                return new Color(175, 238, 238);
            case LIGHTSLATEGREY:
                return new Color(119, 136, 153);
            case PEACHPUFF:
                return new Color(255, 218, 185);
        }
        return null;
    }
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
