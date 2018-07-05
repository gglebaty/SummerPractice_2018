package com.company.Graphic.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WorkApplication implements Runnable {
    private View mainFrame;
    private Conditions field;

    WorkApplication(View mainFrame, Conditions field) {
        this.mainFrame = mainFrame;
        this.field = field;
    }

    @Override
    public void run() {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));
        rootPanel.add(field);
        rootPanel.add(createWorkPanel());
        mainFrame.setContentPane(rootPanel);

        mainFrame.revalidate();
        mainFrame.repaint();

    }

    private JPanel createWorkPanel()
    {
        JPanel workPanel = new JPanel();
        workPanel.setLayout(null);

        JLabel text = new JLabel("Work panel");
        text.setFont(new Font("TimesRoman",Font.PLAIN,70));
        text.setBounds(280, 300, 600, 100);

        JButton buttonNext = new JButton("→");
        buttonNext.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonNext.setBounds(550,500,350,50);
        buttonNext.addActionListener(e -> {
            field.next();
            field.revalidate();
            field.repaint();
        });
        workPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()== KeyEvent.VK_RIGHT) {
                    buttonNext.doClick();
                }
            }
        });

        JButton buttonPrev = new JButton("←");
        buttonPrev.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonPrev.setBounds(50,500,350,50);
        buttonPrev.addActionListener(e -> {
            field.prev();
            field.revalidate();
            field.repaint();
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
        buttonResult.addActionListener(e -> {
            field.result();
            field.revalidate();
            field.repaint();
        });


        JButton buttonMenu = new JButton("Menu");
        buttonMenu.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonMenu.setBounds(220,700,500,50);
        buttonMenu.addActionListener(e -> mainFrame.initStartGui());

        workPanel.setBackground(new Color(173, 216, 230));
        workPanel.add(text);
        workPanel.add(buttonNext);
        workPanel.add(buttonPrev);
        workPanel.add(buttonResult);
        workPanel.add(buttonMenu);


        return workPanel;

    }
}
