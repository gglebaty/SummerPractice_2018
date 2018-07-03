package com.company.Graphic.View;


import java.awt.*;
import java.awt.event.ActionListener;

public class StartApplication implements Runnable {
    private View mainFrame;

    public StartApplication(View mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {

        Button buttonEnter = new Button("Enter size");
        buttonEnter.setPreferredSize(new Dimension(400,50));
        buttonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                mainFrame.initEnterGui();
            }
        });

        Button buttonExit = new Button("Exit");
        buttonExit.setPreferredSize(new Dimension(400,50));
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                mainFrame.exit();
            }
        });

        Button buttonInformation = new Button("About Program");
        buttonInformation.setPreferredSize(new Dimension(400,50));
        buttonInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                mainFrame.initInformationGui();
            }
        });

        Label label = new Label("Menu");
        label.setFont(new Font("TimesRoman",Font.PLAIN,30));

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

        c.insets = new Insets(5, 0, 0, 0);
        layout.setConstraints(buttonEnter,c);
        mainFrame.getContentPane().add(buttonEnter);

        c.insets = new Insets(10, 0, 0, 0);
        layout.setConstraints(buttonInformation,c);
        mainFrame.getContentPane().add(buttonInformation);

        c.insets = new Insets(15, 0, 0, 0);
        layout.setConstraints(buttonExit,c);
        mainFrame.getContentPane().add(buttonExit);
        mainFrame.getContentPane().revalidate();
        mainFrame.getContentPane().repaint();
    }

}
