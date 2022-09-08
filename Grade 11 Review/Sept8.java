public class Sept8 {
    // Write a method that displays the 2-D array neatly in rows and columns. 
    public static void main(String[] args) {
        int [][] board = {
                            {3, 4, 2, 5, 2, 4, 4}, 
                            {2, 3, 2, -2}, 
                            {-2}, 
                            {2, 3, 4, 53343}
                        };
        arr(board);
    }

    public static int arr (int [][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int z = 0; z < board [i].length; z++) {
                System.out.print (board [i][z] + " ");
            }
            System.out.println("");
        }
        return 0;
    }
}
