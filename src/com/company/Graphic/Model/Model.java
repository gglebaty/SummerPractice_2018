package com.company.Graphic.Model;

import java.util.ArrayList;

public class Model {
    private ArrayList<Square> squares;
    private ArrayList<ArrayList<Square>> conditions = new ArrayList<>();
    //private Field field;
    private boolean wasFound = false;


    public Model(int size)
    {
        Number num = new Number(size);
        squares = num.getSquares();
        addNewCondition(squares);
       // field = new Field(size);
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public void go(Field table, int i, int j)
    {
        if (!wasFound)
        {
           //System.out.println("\n");
            //table.printField();
            //System.out.println("\n");
            for (int k = 0 ; k < squares.size() ; k++)
            {
                Field condition = table.makeCopy();
                Square tmp = squares.get(k);
                if (!tmp.isInField())
                {
                    if(condition.isPossible(i,j,tmp))
                    {
                        condition.insertSquare(tmp, i, j);
                        tmp.setInField(true);
                        addNewCondition(squares);
                        if (condition.isFreeCell(i, j)) {
                            go(condition, condition.getNextI(i, j), condition.getNextJ(i, j));//go to free cell
                        }
                        else
                        {
                            //condition.printField();
                            wasFound = true; //to exit the recursive function
                            break;
                        }
                        tmp.setInField(false);
                    }
                    k = k + squares.get(k).getAmount() - 1;
                }
            }
        }
    }
    private void addNewCondition(ArrayList<Square> squares)
    {
        ArrayList<Square> list = new ArrayList<>();
        for (Square s: squares
             ) {
            list.add(s.makeCopy());
        }
        conditions.add(list);
    }

    public ArrayList<ArrayList<Square>> getConditions() {
        return conditions;
    }
}
