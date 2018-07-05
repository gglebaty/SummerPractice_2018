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
        Label label = new Label("Введите размер квадрата");
        label.setFont(new Font("TimesRoman",Font.PLAIN,30));

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
        buttonOk.setPreferredSize(new Dimension(400,50));
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = field.getText();
                int size = 0;
                try {
                    size = Integer.parseInt(text);
                    if (size > 0 && size < 41) {
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
        buttonMenu.setPreferredSize(new Dimension(400,50));
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

        c.insets = new Insets(20, 0, 0, 0);
        layout.addLayoutComponent(field,c);
        mainFrame.add(field);

        c.insets = new Insets(30, 0, 0, 0);
        layout.addLayoutComponent(buttonOk,c);
        mainFrame.add(buttonOk);

        c.insets = new Insets(40, 0, 0, 0);
        layout.addLayoutComponent(buttonMenu,c);
        mainFrame.add(buttonMenu);

        mainFrame.getContentPane().revalidate();
        mainFrame.getContentPane().repaint();
    }
}
