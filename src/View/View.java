package View;

import com.company.Graphic.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
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


    private void initStartGui() {
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

