package com.company.Graphic.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkApplication implements Runnable {
    private View mainFrame;
    private Conditions field;
    private SquareArray squareArray;

    WorkApplication(View mainFrame, Conditions field, SquareArray squareArray) {
        this.mainFrame = mainFrame;
        this.field = field;
        this.squareArray = squareArray;
    }

    @Override
    public void run() {

        //JPanel squaresPanel = new JPanel();
        //squareArray.setPreferredSize(new Dimension(1000,1000));
        JButton buttonNext = new JButton("Next");
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.next();
                field.revalidate();
                field.repaint();
            }
        });

        JButton buttonPrev = new JButton("Prev");
        buttonPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.prev();
                field.revalidate();
                field.repaint();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(field);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        buttons.add(buttonPrev);
        buttons.add(buttonNext);
        panel.add(buttons);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));
        rootPanel.add(panel);
        rootPanel.add(squareArray, BorderLayout.SOUTH);
        mainFrame.setContentPane(rootPanel);

        mainFrame.revalidate();
        mainFrame.repaint();


    }
}
