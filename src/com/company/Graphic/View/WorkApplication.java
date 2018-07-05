package com.company.Graphic.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

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



        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));
        rootPanel.add(field);
        rootPanel.add(createWorkPanel());
        mainFrame.setContentPane(rootPanel);

        mainFrame.revalidate();
        mainFrame.repaint();

    }

    public JPanel createWorkPanel()
    {
        JPanel workPanel = new JPanel();
        //workPanel.setMaximumSize(new Dimension(900,900));
        //workPanel.setBackground(Color.RED);
        workPanel.setLayout(null);

        JLabel text = new JLabel("Work panel");
        text.setFont(new Font("TimesRoman",Font.PLAIN,70));
        text.setBounds(280, 300, 600, 100);

        JButton buttonNext = new JButton("Next");
        buttonNext.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonNext.setBounds(500,500,300,50);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.next();
                field.revalidate();
                field.repaint();
            }
        });

        JButton buttonPrev = new JButton("Prev");
        buttonPrev.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonPrev.setBounds(100,500,300,50);
        buttonPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.prev();
                field.revalidate();
                field.repaint();
            }
        });

        JButton buttonResult = new JButton("Result");
        buttonResult.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonResult.setBounds(325,600,300,50);
        buttonResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.result();
                field.revalidate();
                field.repaint();
            }
        });

        JButton buttonMenu = new JButton("Menu");
        buttonMenu.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonMenu.setBounds(325,700,300,50);
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.initStartGui();
            }
        });

        workPanel.add(text);
        workPanel.add(buttonNext);
        workPanel.add(buttonPrev);
        workPanel.add(buttonResult);
        workPanel.add(buttonMenu);


        return workPanel;

    }
}
