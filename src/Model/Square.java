package Model;

import javax.swing.*;
import java.awt.*;

public class Square {
    private int size;
    private int xPosition;
    private int yPosition;
    private boolean inField;

    public Square(int size)
    {
        this.size = size;
    }
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//        //g2.
//    }
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

    public int getSize(){ return this.size; }

    public void print() { System.out.println(this.size); }
}
