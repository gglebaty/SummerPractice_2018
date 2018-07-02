package com.company.Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private View view;
    //private PrimeNumbers info;
//
    public static void main(String[] args) {
        View view = new View();
        //view.init();
        Model table = new Model(15);
        table.printSquares();
        table.go(table,0,0);
        table.printField();
    }

}
