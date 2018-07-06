package com.company.Graphic;

import com.company.Graphic.Model.Field;
import com.company.Graphic.Model.Model;
import com.company.Graphic.View.Conditions;
import com.company.Graphic.View.View;

public class Controller {
    private View view;

    private Controller(View view) {
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
        Model model = new Model(size);
        Field field = new Field(size);
        model.go(field,0,0);
        Conditions conditions = new Conditions(model.getConditions(), size);
        view.initWorkPanel(conditions);
    }

    public void exit()
    {
        System.exit(0);
    }

}
