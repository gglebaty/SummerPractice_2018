package com.company.Graphic.View;
import com.company.Graphic.Controller;
import com.company.Graphic.Model.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame implements ActionListener {

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
        getContentPane().setBackground(new Color(173, 216, 230));
    }

    public void init() {
        initStartGui();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }


    public void initStartGui() {
        getContentPane().removeAll();
        SwingUtilities.invokeLater(new StartApplication(this));

    }

    public void initEnterGui()
    {
        getContentPane().removeAll();
        SwingUtilities.invokeLater(new EnterApplication(this));
    }

    public void initInformationGui()
    {
        getContentPane().removeAll();
        SwingUtilities.invokeLater(new InformationApplication(this));
    }

    public void initWorkPanel(Conditions field)
    {
        getContentPane().removeAll();
        SwingUtilities.invokeLater(new WorkApplication(this, field));
    }

    public void setSize(int size)
    {
        controller.setSize(size);
    }

    public void exit()
    {
        controller.exit();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

