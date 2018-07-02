package com.company.Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartApplication implements Runnable {
    private final Dimension dimension;
    private JFrame mainFrame;
    private JPanel panel;


    {
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
    }

    @Override
    public void run() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame = initFrame();

        //JTextField field = new JTextField();
        // field.setPreferredSize(new Dimension(250,250));

        //JLabel label = new JLabel();
        //label.setLocation(250,250);

        panel = createPanel();

        panel.setLayout(null);
        panel.add(createButtonEnter());
        panel.add(createButtonAboutProgram());
        panel.add(createButtonExit());
        mainFrame.setContentPane(panel);
    }
    private JFrame initFrame()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Bactracking");
        mainFrame.setPreferredSize(new Dimension(dimension.width,dimension.height));
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        return mainFrame;
    }

    private JButton createButtonEnter()
    {
        JButton enterData = new JButton("Ввод данных");
        enterData.setBackground(Color.green);
        enterData.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        enterData.setBounds(dimension.width/2-150,dimension.height/2-100,500,70);
        enterData.addActionListener(e -> {
            //String text = field.getText();
            enterData.setText("Ok");
            JPanel frame2 = createPanel();
            mainFrame.add(frame2);

        });
        return enterData;

    }

    private JPanel  createPanel()
    {
        JPanel panel1 = new JPanel(){
            @Override
            public void paint(Graphics g) {
                try {
                    BufferedImage image = ImageIO.read(new File("C:\\Users\\Ярослав\\Desktop\\УТЕБАААААА\\4 сем\\практика\\SummerPractice_2018\\617655_gallery.world.jpg"));
                    g.drawImage(image,0,0,dimension.width,dimension.height,null);
                    g.setColor(Color.white);
                    g.setFont(new Font("Blackadder ITC", Font.PLAIN, 200));
                    g.drawString("Squaring the square", dimension.width/6, 200);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        return panel1;
    }

    private JButton createButtonAboutProgram()
    {
        JButton aboutProgramm = new JButton("О программе");
        aboutProgramm.setBackground(Color.green);
        aboutProgramm.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        aboutProgramm.setBounds(dimension.width/2-150,dimension.height/2,500,70);
        aboutProgramm.addActionListener(e -> {
            //String text = field.getText();
            aboutProgramm.setText("About programm");
        });
        return aboutProgramm;
    }

    private JButton createButtonExit()
    {
        JButton exit = new JButton("Выход");
        exit.setBackground(Color.green);
        exit.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        exit.setBounds(dimension.width/2-150,dimension.height/2+100,500,70);
        exit.addActionListener(e -> {
            System.exit(1);
        });
        return exit;
    }

    private JFrame createFrameForButtonEnter()
    {
        JFrame form2 = new JFrame();
        form2.pack();
        form2.setVisible(true);
        return form2;
    }
}
