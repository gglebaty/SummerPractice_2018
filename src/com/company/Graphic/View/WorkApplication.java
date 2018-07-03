package com.company.Graphic.View;

import javax.swing.*;
import java.awt.*;

public class WorkApplication implements Runnable {
    private View mainFrame;
    private JPanel field;
    private JPanel array;

    public WorkApplication(View mainFrame, JPanel field, JPanel array) {
        this.mainFrame = mainFrame;
        this.field = field;
        this.array = array;
    }

    @Override
    public void run() {

        /*mainFrame.setLayout(null);
        field.setSize(new Dimension(1000,1000));
        mainFrame.add(field);*/

        JPanel workPanel = new JPanel();
        workPanel.setPreferredSize(new Dimension(1000,500));
        //workPanel.setBackground(Color.RED);


        JPanel squaresPanel = new JPanel();
        squaresPanel.setPreferredSize(new Dimension(1000,500));
        squaresPanel.setBackground(Color.YELLOW);

        mainFrame.getContentPane().setLayout(new BorderLayout());
        //mainFrame.setLayout(new FlowLayout());
        mainFrame.getContentPane().add(field);
        mainFrame.getContentPane().add(array, BorderLayout.EAST);
        //field.setLayout(null);
        mainFrame.revalidate();
        mainFrame.repaint();


    }
}
