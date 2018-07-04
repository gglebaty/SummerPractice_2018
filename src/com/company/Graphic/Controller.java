package com.company.Graphic;

import com.company.Graphic.Model.Field;
import com.company.Graphic.Model.Model;
import com.company.Graphic.Model.SquareArray;
import com.company.Graphic.View.View;

public class Controller {
    private View view;
    private Model model;

    private Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        //Model model = new Model(7);
        //model.go(new Field(7),0,0);
        view.init();
    }

    public void setSize(int size)
    {
        this.model = new Model(size);
        Field field = new Field(size);
        SquareArray array = new SquareArray(model.getSquares());
        view.initWorkPanel(field, array);
        model.go(field,0,0);
    }

    public void exit()
    {
        System.exit(0);
    }

}
