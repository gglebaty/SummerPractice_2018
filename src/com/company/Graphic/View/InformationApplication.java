
package com.company.Graphic.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationApplication implements Runnable {
    private View mainFrame;

    public InformationApplication(View mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {

        mainFrame.getContentPane().setBackground(new Color(173, 216, 230));
        Label label = new Label("Information about the program");
        label.setFont(new Font("TimesRoman",Font.PLAIN,50));

        Label label1 = new Label("The application solves the problem of squaring a square");
        label1.setFont(new Font("TimesRoman",Font.PLAIN,30));

        Label label2 = new Label("into a finite number of smaller squares.\n");
        label2.setFont(new Font("TimesRoman",Font.PLAIN,30));

        Label label3 = new Label("The user enters the size of the square and in result gets\n");
        label3.setFont(new Font("TimesRoman",Font.PLAIN,30));

        Label label4 = new Label("division of the square on the smallest squares.\n");
        label4.setFont(new Font("TimesRoman",Font.PLAIN,30));

        Label label5 = new Label("The number of the squares is minimal.\n");
        label5.setFont(new Font("TimesRoman",Font.PLAIN,30));

        JButton buttonMenu = new JButton("Menu");
        buttonMenu.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonMenu.setPreferredSize(new Dimension(500,50));
        buttonMenu.addActionListener(e -> mainFrame.initStartGui());


        GridBagLayout layout = new GridBagLayout();
        mainFrame.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;
        c.fill   = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth  = GridBagConstraints.REMAINDER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(10, 0, 0, 0);


        layout.addLayoutComponent(label,c);
        mainFrame.getContentPane().add(label);


        c.insets = new Insets(50, 0, 0, 0);
        layout.addLayoutComponent(label1,c);
        mainFrame.getContentPane().add(label1);

        c.insets = new Insets(10, 0, 0, 0);
        layout.addLayoutComponent(label2,c);
        mainFrame.getContentPane().add(label2);

        c.insets = new Insets(10, 0, 0, 0);
        layout.addLayoutComponent(label3,c);
        mainFrame.getContentPane().add(label3);

        c.insets = new Insets(10, 0, 0, 0);
        layout.addLayoutComponent(label4,c);
        mainFrame.getContentPane().add(label4);

        c.insets = new Insets(10, 0, 0, 0);
        layout.addLayoutComponent(label5,c);
        mainFrame.getContentPane().add(label5);

        c.insets = new Insets(50, 0, 0, 0);
        layout.addLayoutComponent(buttonMenu,c);
        mainFrame.add(buttonMenu);
        mainFrame.getContentPane().revalidate();
        mainFrame.getContentPane().repaint();
    }
}
