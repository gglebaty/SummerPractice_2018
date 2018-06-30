package com.company.Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {
    private View view;

    public static void main(String[] args) {
        View view = new View();
        view.init();
    }

}
