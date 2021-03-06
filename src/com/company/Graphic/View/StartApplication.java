package com.company.Graphic.View;


import javax.swing.*;
import java.awt.*;

public class StartApplication implements Runnable {
    private View mainFrame;

    public StartApplication(View mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        mainFrame.getContentPane().setBackground(new Color(173, 216, 230));
        JButton buttonEnter = new JButton("Enter the size");
        buttonEnter.setPreferredSize(new Dimension(500,50));
        buttonEnter.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonEnter.addActionListener(e -> mainFrame.initEnterGui());

        JButton buttonExit = new JButton("Exit");
        buttonExit.setPreferredSize(new Dimension(500,50));
        buttonExit.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonExit.addActionListener(e -> mainFrame.exit());

        JButton buttonInformation = new JButton("About the program");
        buttonInformation.setPreferredSize(new Dimension(500,50));
        buttonInformation.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonInformation.addActionListener(e -> mainFrame.initInformationGui());

        JLabel label = new JLabel("Menu");
        label.setFont(new Font("TimesRoman",Font.PLAIN,50));

        GridBagLayout layout = new GridBagLayout();
        mainFrame.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.fill   = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth  = GridBagConstraints.REMAINDER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(20, 0, 0, 0);
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0;
        c.weighty = 0;

        layout.addLayoutComponent(label,c);
        mainFrame.getContentPane().add(label);

        c.insets = new Insets(50, 0, 0, 0);
        layout.setConstraints(buttonEnter,c);
        mainFrame.getContentPane().add(buttonEnter);

        c.insets = new Insets(20, 0, 0, 0);
        layout.setConstraints(buttonInformation,c);
        mainFrame.getContentPane().add(buttonInformation);

        c.insets = new Insets(20, 0, 0, 0);
        layout.setConstraints(buttonExit,c);
        mainFrame.getContentPane().add(buttonExit);
        mainFrame.getContentPane().revalidate();
        mainFrame.getContentPane().repaint();
    }

}
