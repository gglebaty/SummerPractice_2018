package com.company.Graphic.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnterApplication implements Runnable{
    private View mainFrame;
    String text;

    public EnterApplication(View mainFrame) {
        this.mainFrame = mainFrame;
    }

    public EnterApplication(View mainFrame, String text) {
        this.mainFrame = mainFrame;
        this.text = text;
    }

    @Override
    public void run() {
        mainFrame.getContentPane().setBackground(new Color(173, 216, 230));
        JLabel label = new JLabel("Enter the size of the square");
        label.setFont(new Font("TimesRoman",Font.PLAIN,50));

        JLabel moreThan = new JLabel("2≤");
        moreThan.setFont(new Font("TimesRoman",Font.PLAIN,40));

        JLabel lessThan = new JLabel("≤40");
        lessThan.setFont(new Font("TimesRoman",Font.PLAIN,40));


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
        buttonOk.addActionListener(e -> {
            text = field.getText();
            int size = 0;
            try {
                size = Integer.parseInt(text);
                if (size > 1 && size < 41) {
                        mainFrame.setSize(size);
                }
                else {
                    JOptionPane.showMessageDialog(mainFrame, "You entered incorrect data. Please, enter the number between 2 and 40.",
                            "Incorrect input", JOptionPane.PLAIN_MESSAGE);
                    field.setText("");
                }
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog( mainFrame, "You entered incorrect data. Please, enter the number between 2 and 40.",
                        "Incorrect input", JOptionPane.PLAIN_MESSAGE);
                field.setText("");
            }
        });

        JButton buttonMenu = new JButton("Menu");
        buttonMenu.setFont(new Font("TimesRoman",Font.PLAIN,30));
        buttonMenu.setPreferredSize(new Dimension(500,50));
        buttonMenu.addActionListener(e -> mainFrame.initStartGui());

        GridBagLayout layout = new GridBagLayout();
        mainFrame.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.fill   = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth  = GridBagConstraints.REMAINDER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.insets = new Insets(10, 0, 0, 0);


        JPanel sizes = new JPanel();
        sizes.setBackground(new Color(173, 216, 230));
        sizes.setLayout(new BoxLayout(sizes, BoxLayout.X_AXIS));
        sizes.add(moreThan);
        sizes.add(field);
        sizes.add(lessThan);

        layout.addLayoutComponent(label,c);
        mainFrame.getContentPane().add(label);

        c.insets = new Insets(20, 0, 0, 0);
        layout.addLayoutComponent(sizes,c);
        mainFrame.add(sizes);

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
