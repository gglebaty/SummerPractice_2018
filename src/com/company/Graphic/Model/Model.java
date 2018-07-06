package com.company.Graphic.Model;

import java.util.ArrayList;

public class Model {
    private ArrayList<Square> squares;
    private ArrayList<ArrayList<Square>> conditions = new ArrayList<>();
    private boolean wasFound = false;


    public Model(int size)
    {
        Number num = new Number(size);
        squares = num.getSquares();
        addNewCondition(squares);
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public void go(Field table, int i, int j) {
        if (!wasFound) {
            for (int k = 0; k < squares.size(); k++) {
                Field condition = table.makeCopy();
                Square tmp = squares.get(k);
                if (!tmp.isInField() && !wasFound)
                {
                    if(condition.isPossible(i,j,tmp))
                    {
                        condition.insertSquare(tmp, i, j);
                        tmp.setInField(true);
                        addNewCondition(squares);
                        if (condition.isFreeCell(i, j)) {
                            go(condition, condition.getNextI(i, j), condition.getNextJ(i, j));//go to free cell
                        } else {
                            wasFound = true; //to exit the recursive function
                            break;
                        }
                        tmp.setInField(false);
                        if (!wasFound) {
                            addNewCondition(squares);
                        }
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
