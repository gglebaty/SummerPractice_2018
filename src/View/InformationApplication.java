package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InformationApplication implements Runnable {
    private View mainFrame;

    public InformationApplication(View mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {

        Label label = new Label("Information about program");
        label.setFont(new Font("TimesRoman",Font.PLAIN,30));

        JTextArea area = new JTextArea();
        area.setFont(new Font("TimesRoman",Font.PLAIN,30));
        area.setText("Данное приложение решает задачу о разбиении квадрата\n" +
                "на конечное число меньших по размеру квадратов.\n" +
                "Пользователь вводит размеры квадрата, а на выходе\n" +
                "получает его разбиение на меньшие квадраты.\n" +
                "При этом количество квадратов минимально.\n");
        area.setPreferredSize(new Dimension(850,200));

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


        c.insets = new Insets(10, 0, 0, 0);
        layout.addLayoutComponent(area,c);
        mainFrame.getContentPane().add(area);
    }
}
