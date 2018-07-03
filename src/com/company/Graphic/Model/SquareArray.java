package com.company.Graphic.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SquareArray extends JPanel {

    private ArrayList<Square> squares;

    public SquareArray(ArrayList<Square> squares) throws HeadlessException {
        this.squares = squares;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics2D = (Graphics2D) g;

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.fill   = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth  = GridBagConstraints.REMAINDER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(10, 0, 0, 0);

        for (Square s:squares) {
            layout.addLayoutComponent(s,c);
            add(s);
        }
        revalidate();
        repaint();
    }
}
