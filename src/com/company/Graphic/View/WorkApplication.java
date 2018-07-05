package com.company.Graphic.View;

import com.company.Graphic.Model.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        field.setPreferredSize(new Dimension(1000,1000));

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        buttons.add(buttonPrev);
        buttons.add(buttonNext);
        panel.add(buttons);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));
        rootPanel.add(panel);
        rootPanel.add(squareArray);
        mainFrame.setContentPane(rootPanel);

        mainFrame.revalidate();
        mainFrame.repaint();


    }

    public class managerPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
        /*super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        setLayout(new FlowLayout(FlowLayout.CENTER));

        for (Square s:conditions.get(currentCondition)
                ) {
            if(!s.isInField())
                add(s);
        }
        revalidate();
        repaint();*/
            super.paintComponent(g);

            JLabel label = new JLabel("Work panel");

            JButton buttonMenu = new JButton("Menu");

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


            layout.addLayoutComponent(label,c);
            add(label);

            c.insets = new Insets(20, 0, 0, 0);
            layout.addLayoutComponent(field,c);
            add(field);

            c.insets = new Insets(30, 0, 0, 0);
            layout.addLayoutComponent(buttonPrev,c);
            add(buttonPrev);

            c.insets = new Insets(30, 30, 0, 0);
            layout.addLayoutComponent(buttonNext,c);
            add(buttonNext);

            c.insets = new Insets(40, 0, 0, 0);
            layout.addLayoutComponent(buttonMenu,c);
            add(buttonMenu);
        }
    }
}
