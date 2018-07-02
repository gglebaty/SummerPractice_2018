package Model;


public class Field {
    private int [][] field;
    private int size;

    public Field(int size) {
        this.size = size;
        field = new int [size][size];
    }

    public int getSize() {
        return size;
    }

    public boolean isPossible(int i, int j, Square square)
    {
        if ((i + square.getSize()) > size || (j + square.getSize()) > size)
            return false;
        for (int l = i; l < i + square.getSize(); l++)
            for (int m = j; m < j + square.getSize(); m++)
                if (field[l][m] != 0)
                    return false;
        return true;
    }

    public void insertSquare(Square sq, int x, int y)
    {
        for (int i = x; i < x+sq.getSize(); i++)
        {
            for (int j = y; j < y+sq.getSize() ; j++)
            {
                field[i][j] = sq.getSize();

            }
        }

    }

    public boolean isFreeCell(int i, int j)
    {
        for (int l = i; l < size; l++)
            for (int m = 0; m < size; m++)
                if (field[l][m] == 0)
                    return true;
        return false;
    }

    public int getNextI(int i, int j)
    {
        for (int l = i; l < size; l++)
            for (int m = 0; m < size; m++)
                if (field[l][m] == 0)
                    return l;
        return -1;
    }

    public int getNextJ(int i, int j)
    {
        for (int l = i; l < size; l++)
            for (int m = 0; m < size; m++)
                if (field[l][m] == 0)
                    return m;
        return -1;
    }

    public void printField()
    {
        for (int i = 0 ; i < field.length ; i++)
        {
            for (int j = 0 ; j < field[i].length ; j++)
            {
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }
    }
}
