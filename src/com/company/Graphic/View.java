package com.company.Graphic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    public void init() {
        Runnable task;
        SwingUtilities.invokeLater(new StartApplication());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

