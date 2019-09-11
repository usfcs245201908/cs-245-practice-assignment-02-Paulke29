import java.util.IllegalFormatException;

public class NQueens {

    final int size;
    //int board[][];
    int board[][] = { { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 } };
    int row;
    int col;

    NQueens(int n) throws IllegalFormatException {


        size = n;
        row = n;
        col = n;
    }

    boolean isSafe() {
        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < size; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean placeNQueens() {

        if (size <= 0 || size ==2 || size ==3) {
            throw new IllegalArgumentException();
        }

        if (col >= size)
            return true;

        for (int i = 0; i < size; i++) {

            if (isSafe()) {

                board[i][col] = 1;


                if (placeNQueens() == true)
                    return true;


                board[i][col] = 0;
            }
        }


        return false;
    }

    public void printToConsole() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }


}