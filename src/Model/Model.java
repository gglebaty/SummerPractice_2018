package Model;



import java.util.ArrayList;

public class Model {
    private ArrayList<Square> squares;
    private Field field;
    private boolean wasFound = false;


    public Model(int size)
    {
        Number num = new Number(size);
        squares = num.getSquares();
        field = new Field(size);
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public void go(Field table, int i, int j)
    {
        if (!wasFound)
        {
            System.out.println("\n");
            table.printField();
            System.out.println("\n");
            for (int k = 0 ; k < squares.size() ; k++)
            {
                Field condition = table;
                Square tmp = squares.get(k);

                if (!tmp.isInField())
                {

                    if(condition.isPossible(i,j,tmp))
                    {
                        condition.insertSquare(tmp, i, j);
                        if (condition.isFreeCell(i, j)) {
                            go(condition, condition.getNextI(i, j), condition.getNextJ(i, j));//go to free cell
                        }
                        else
                        {
                            //condition.printField();
                            wasFound = true; //to exit the recursive function
                            break;
                        }
                    }
                }
            }
        }
    }
}
