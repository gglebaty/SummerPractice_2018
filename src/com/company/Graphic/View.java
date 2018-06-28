package com.company.Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private com.company.Graphic.Controller controller;

    public void init() {
        initGui();
        //addWindowListener(new FrameListener(this));
        setTitle("Welcom!");
        setSize(new Dimension(800, 700));
        setVisible(true);
    }

    public void initMenuBar() {

    }

    public void initGui() {
        initMenuBar();
        pack();
    }

    public void exit() {
        controller.exit();
    }

    public com.company.Graphic.Controller getController() {
        return controller;
    }

    public void setController(com.company.Graphic.Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

