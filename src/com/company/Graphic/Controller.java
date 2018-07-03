package com.company.Graphic;

import com.company.Graphic.View.View;

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
