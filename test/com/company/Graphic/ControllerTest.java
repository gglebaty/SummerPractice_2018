package com.company.Graphic;

import com.company.Graphic.Model.Field;
import com.company.Graphic.Model.Model;
import com.company.Graphic.Model.Square;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void setSize() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            new Model(-173);
        });
        assertNull(exception.getMessage());
    }

    @Test
    void setSize_2() {
        Model model = new Model(7);
        Field field = new Field(model,7);
        model.go(field,0,0);
        ArrayList<ArrayList<Square>> conditions = model.getConditions();
        double area = 0;
        for (Square s: conditions.get(0)
                ) {
            assertEquals(s.isInField(),false);
            area += Math.pow(s.getsize(),2);
        }

        assertEquals(49, area, 0.000001);

        for (Square s: conditions.get(conditions.size()-1)
                ) {
            assertEquals(s.isInField(),true);
        }
    }

    @Test
    void setSize_3(){
        Model model2 = new Model(2);
        Field field2 = new Field(model2,2);
        model2.go(field2,0,0);
        ArrayList<ArrayList<Square>> conditions2 = model2.getConditions();
        double area2 = 0;
        assertEquals(5, conditions2.size());
        for (Square s: conditions2.get(0)
                ) {
            assertEquals(s.isInField(),false);
            area2 += Math.pow(s.getsize(),2);
        }
        assertEquals(4, area2, 0.000001);
        for (Square s: conditions2.get(conditions2.size()-1)
                ) {
            assertEquals(s.isInField(),true);
        }
    }

    @Test
    void setSize_4(){
        Model model3 = new Model(40);
        Field field3 = new Field(model3,40);
        model3.go(field3,0,0);
        ArrayList<ArrayList<Square>> conditions3 = model3.getConditions();
        double area3 = 0;
        assertEquals(5, conditions3.size());
        for (Square s: conditions3.get(0)
                ) {
            assertEquals(s.isInField(),false);
            area3 += Math.pow(s.getsize(),2);
        }
        assertEquals(1600, area3, 0.000001);
        for (Square s: conditions3.get(conditions3.size()-1)
                ) {
            assertEquals(s.isInField(),true);
        }
    }

    @Test
    void setSize_5() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            new Model(89);
        });
        assertNull(exception.getMessage());
    }

}
