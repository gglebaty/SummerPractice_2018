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

    WorkApplication(View mainFrame, Conditions field) {
        this.mainFrame = mainFrame;
        this.field = field;
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

        JButton buttonNext = new JButton("→");
        buttonNext.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonNext.setBounds(550,500,350,50);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.next();
                field.revalidate();
                field.repaint();
            }
        });
        workPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e);
                if (e.getKeyCode()== KeyEvent.VK_RIGHT) {
                    buttonNext.doClick();
                }
            }
        });

        JButton buttonPrev = new JButton("←");
        buttonPrev.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonPrev.setBounds(50,500,350,50);
        buttonPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.prev();
                field.revalidate();
                field.repaint();
            }
        });
       workPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e);
                if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                    buttonPrev.doClick();
                }
            }
        });

        JButton buttonResult = new JButton("Result");
        buttonResult.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonResult.setBounds(220,600,500,50);
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
        buttonMenu.setBounds(220,700,500,50);
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.initStartGui();
            }
        });

        workPanel.setBackground(new Color(173, 216, 230));
        workPanel.add(text);
        workPanel.add(buttonNext);
        workPanel.add(buttonPrev);
        workPanel.add(buttonResult);
        workPanel.add(buttonMenu);


        return workPanel;

    }
}
