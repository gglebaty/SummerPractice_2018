package com.company.Graphic.View;

import javax.swing.*;
import java.awt.*;

public class WorkApplication implements Runnable {
    private View mainFrame;
    private JPanel field;
    private JPanel array;

    WorkApplication(View mainFrame, JPanel field) {
        this.mainFrame = mainFrame;
        this.field = field;
        //this.array = array;
    }

    @Override
    public void run() {

        JPanel squaresPanel = new JPanel();
        squaresPanel.setBackground(Color.YELLOW);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));
        rootPanel.add(field);
        rootPanel.add(squaresPanel, BorderLayout.SOUTH);
        mainFrame.setContentPane(rootPanel);

        mainFrame.revalidate();
        mainFrame.repaint();


    }
}
