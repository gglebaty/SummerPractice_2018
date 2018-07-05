package com.company.Graphic.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnterApplication implements Runnable{
    private View mainFrame;

    public EnterApplication(View mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        mainFrame.getContentPane().setBackground(new Color(173, 216, 230));
        JLabel label = new JLabel("Enter the size of the square");
        label.setFont(new Font("TimesRoman",Font.PLAIN,50));

        JLabel moreThan = new JLabel("2<=");
        moreThan.setFont(new Font("TimesRoman",Font.PLAIN,30));


        JTextField field = new JTextField();
        field.setFont(new Font("TimesRoman",Font.PLAIN,30));
        field.setPreferredSize(new Dimension(45,50));
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (field.getText().length() == 2) {
                    e.consume();
                }
            }
        });

        JButton buttonOk = new JButton("Ok");
        buttonOk.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonOk.setPreferredSize(new Dimension(500,50));
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = field.getText();
                int size = 0;
                try {
                    size = Integer.parseInt(text);
                    if (size > 1 && size < 41) {
                            mainFrame.setSize(size);
                    }
                    else {
                        JOptionPane.showMessageDialog(mainFrame, "Вы ввели некорректные данные. Введите число от 1 до 40",
                                "Некорректный ввод", JOptionPane.PLAIN_MESSAGE);
                        field.setText("");
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog( mainFrame, "Вы ввели некорректные данные. Введите число от 1 до 40",
                            "Некорректный ввод", JOptionPane.PLAIN_MESSAGE);
                    field.setText("");
                }
            }
        });

        JButton buttonMenu = new JButton("Menu");
        buttonMenu.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonMenu.setPreferredSize(new Dimension(500,50));
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.initStartGui();
            }
        });

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

        //layout.addLayoutComponent(moreThan,c);
       // mainFrame.add(moreThan);

        c.gridwidth = GridBagConstraints.REMAINDER;;
        c.insets = new Insets(20, 0, 0, 0);
        layout.addLayoutComponent(field,c);
        mainFrame.add(field);

        c.insets = new Insets(40, 0, 0, 0);
        layout.addLayoutComponent(buttonOk,c);
        mainFrame.add(buttonOk);

        c.insets = new Insets(20, 0, 0, 0);
        layout.addLayoutComponent(buttonMenu,c);
        mainFrame.add(buttonMenu);

        mainFrame.getContentPane().revalidate();
        mainFrame.getContentPane().repaint();
    }
}
