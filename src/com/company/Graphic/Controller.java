package com.company.Graphic;

import View.View;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
    }

    public void setSize(int size)
    {
        // создать Model
    }

    public void exit()
    {
        System.exit(0);
    }

}
