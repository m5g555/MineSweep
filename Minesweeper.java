package MineSweeper; 
/**
 * Minesweeper.java
 *
 */
//
import java.awt.*;
public class Minesweeper 
{
        final  int MINES = 20;  // the total number of mines to be assigned in the game
        static boolean isFlagOn = true; // start true because button starts by negating it
                                // keep it global because it cannot easily be returned

    /**
     * PlaceMines - add MINES mines to theMines 2D array.
     *            - Designate a mine by assigning the value -1.
     *            - The mines should be added in random locations
     * Preconditions:  theMines is defined with no values assigned
     * Postconditions: There are MINES values of -1 assigned in the 2D array
     * @param theMines The 2D array of integers containing the location of mines and counts of mines in adjacent cells.
     */
    public static void placeMines(int[][] theMines)
    {
        /*
         * TO BE IMPLEMENTED
         * MINES - global variable listing the total number of mines
         * Randomly select a row & column
         * If it does not already contain a mine, add one to that location
         * Designate a mine by assigning the value -1 in theMines.
         * Do this MINES times.
         */

    }

    /**
     * initializeTheMines 
     *  - Call placeMines to add mines to theMines 2D array using -1 to designate a mine.
     *  - Calculate the adjacent mines:
     *       If a cell does not contain a mine then calculate the number of adjacent cells 
     *       that contain a mine and store that value in the theMines 2D array.
     * Preconditions:  theMines is defined with no values assigned
     * Postconditions: The mines and count of neighboring mines values have been assinged to theMines
     * @param theMines The 2D array of integers containing the location of mines and counts of mines in adjacent cells.
     */
    public static void initializeTheMines(int[][] theMines)
    {
        /*
         * TO BE IMPLEMENTED
         * call placeMines to add the mines
         * For each cell in the theMines 2D array,
         *      if it does not contain a mine, calculate the number of neighboring cells contain a mine
         * Careful about not checking cells that are out-of-bounds (causing an IndexOutOfBounds exception). 
         */
    }
    /**
     * button - Toggles the Flag button on the screen and negates the global variable isFlagOn.
     *    @param board the 2D array of booleans indicating whether a cell has been played(selected)
     */
    private static void button(boolean[][] board){
        ///
        //   DO NOT CHANGE THIS METHOD
        ///
        isFlagOn = !isFlagOn;
        String buttonText = "FLAG ON";
        if (isFlagOn)
        {
            StdDraw.setPenColor(StdDraw.MAGENTA);
        }
        else{
            StdDraw.setPenColor(StdDraw.GRAY);
            buttonText = "FLAG OFF";
        }   
        int size = Math.max(board.length, board[0].length);
        StdDraw.filledRectangle(0, size +.4, size, .4);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(size/2-2, size+.2, buttonText);
    }


    /**
     * setup    - initializes the graphics and 2D arrays for the game.
     * Preconditions:  theMines and board are defined with no values assigned
     * Postconditions: The two 2D arrays have been initialized
     * @param theMines The 2D array of integers containing the location of mines and counts of mines in adjacent cells.
     * @param board the 2D array of booleans indicating whether a cell has been played(selected)
     */
    public static void setup(boolean[][] board, int[][] theMines)
    {
        //  TO BE IMPLEMENTED BY YOU:
        //  you must find the values for the number of rows and the number of columns. 
        //  the values of 10 are only there as placeholders.  YOUR ASSIGNMENT WILL NOT BE AN ACTUAL NUMBER.
        int num_rows = 10;
        int num_cols = 10;
        
        /*
         * Graphics commands.  Strongly recommend that you not change them.
         */
        StdDraw.setCanvasSize(700, 750);
        int size = Math.max(num_rows, num_cols);
        StdDraw.setScale(0, size+.5);
        int fontSize = 28;
        if (size > 20)
            fontSize = 16;
        else if (size < 9)
            fontSize = 36;
        Font font = new Font("Arial", Font.BOLD, fontSize);
        StdDraw.setFont(font);
        /*
         * TO BE IMPLEMENTED
         * Set each cell in the board 2D array to false, indicating that it has
         * not been clicked.
         */
        int[] location = {-1, -1};
        initializeTheMines(theMines);
        draw_board(board, theMines, false, location);
        button(board);
    }

    /**
     * gameIsOver    - determines if the game should be ended.
     * @param board the 2D array of booleans indicating whether a cell has been played(selected)
     * @param theMines The 2D array of integers containing the location of mines and counts of mines in adjacent cells.
     * @param   location  contains the {row, col} where the mouse was clicked
     * @return  int status value:  -1 means a mine has been hit, game over - LOSS
     *                              0 means there are more cells so the game is not over
     *                              1 means all the non-mine cells have been selected, game over - WIN
     */
    public static int gameIsOver(boolean[][] board, int[][] theMines, int[] location)
    {
        /*
         * TO BE IMPLEMENTED
         * If the clicked location contain a mine, return a -1
         * Check all the cells to see if any of cells that do not contain a mine are unclicked.
         * If so, return a 0. (game continues)
         * If none of the cells that do not contain a mine remain open, return a 1 (game over)
         */
        return -1;  // PLACEHOLDER so the code will compile.  Will be replaced by your code.
    }

    /**
     * handleMouseClick    - returns the row/col of the cell that was clicked.
     * @param board the 2D array of booleans indicating whether a cell has been played(selected)
     * @return  location    updated global int array of {row, col}
     */
    public static int[] handleMouseClick(boolean[][] board) {
        while (!StdDraw.mousePressed()) {
            // Wait for mouse press
        }
        double x = StdDraw.mouseX();
        double y = StdDraw.mouseY();
        while (StdDraw.mousePressed()) {
            // Wait for mouse release
        }

        int col = (int) x;
        // this definition of row is because the graphics package considers the BOTTOM row to be
        // row 0.  This line helps handle that difference.  Location[0] will contain a 0 for the
        // top row in the board.
        int row = board.length - 1 - (int) y;

        System.out.println("row: "+row+"\tcol: "+col);  //  comment this out once you are confident in your code
        /*
         * TO BE IMPLEMENTED
         * If the clicked location is the flag button  (Use the println above to help you figure out how you'll know)
         *      call button
         *      return handleMouseClick(board);  // use this line exactly
         * else:
         *      - set the cell in board to show it has been selected
         *      - create the location array (length 2 of ints)
         *      - assign (row, col) to location
         *      - return the location array.
         */
        int[] temp = {-1,-1}; // this and the return are a place holder so that 
        return temp;          // the code will compile.  You will replace them.
    }

    /**
     * endBanner    - Displays the message indicating how the game ended 
     *              - calls gameIsOver to determine this.
     * @param board the 2D array of booleans indicating whether a cell has been played(selected)
     * @param theMines The 2D array of integers containing the location of mines and counts of mines in adjacent cells.
     * @param   location  contains the row, col where the mouse was clicked
     */
    public static void endBanner(boolean[][] board, int[][] theMines, int[] location) {
        ///
        //   DO NOT CHANGE THIS METHOD
        ///
        String bannerText = "Congratulations!!!";;
        if (gameIsOver(board, theMines,  location) == -1)   
        {
            bannerText = "That was a mine!!!";
        }
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledRectangle(4, 4, 2.7, .4);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(3.5, 4, bannerText);
    }
    /**
     * addFlag - change the color of the cell to ORANGE
     * @param   numRows   The number of rows in the board
     * @param   location  contains the row, col where the mouse was clicked
     * @param   CENTER    the distanc e to the center of a square.  Value is set in draw_board.
     */
    public static void addFlag(int numRows, int[] location, double CENTER){
        ///
        //   DO NOT CHANGE THIS METHOD
        ///
        int draw_row = numRows - 1 - location[0];
        int c = location[1];
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledSquare(c + CENTER, draw_row + CENTER, CENTER);
    }

    /**
     * draw_board    - Draws the current state of the game 
     * @param board the 2D array of booleans indicating whether a cell has been played(selected)
     * @param theMines The 2D array of integers containing the location of mines and counts of mines in adjacent cells.
     * @param   gameover  true when the game is over, false otherwise
     * @param   location  the int array {row, col} of the cell that was clicked.  It is {-1,-1} when the game starts
     * 
     * VERY IMPORTANT NOTE:
     * The graphics package starts drawing at the BOTTOM of the window (row 0 is the bottom row).  This is
     * not an issue except that if you print out theMines (System.out.print), the mines will not be in the
     * same location.  You will need 2 "row" variables:  
     *      one will be the index for theMines/board.  
     *      The second is the row for the graphics board.  
     * Examine draw_row in the first for loop below to see how it is defined.  You would use the 
     * variable r in that for loop to get the value out of board/theMines.
     */
    public static void draw_board(boolean[][] board, int[][] theMines, boolean gameOver, int[] location) {
        //  TO BE IMPLEMENTED BY YOU:
        //  you must find the values for the number of rows and the number of columns
        //  the values of 10 are only there as placeholders.  YOUR ASSIGNMENT WILL NOT BE AN ACTUAL NUMBER.
        int num_rows =10;
        int num_cols = 10;
        int size = Math.max(num_rows, num_cols);
        final double WIN_SIZE = 10.0;  // the size of the window
        final double CELL_WIDTH = WIN_SIZE/size;
        final double CENTER = .48;
        /*
         * IMPLEMENTED FOR YOU.  YOU DO NOT NEED TO CHANGE THIS PART
         * if both values in location are -1, then the game has not been played.  
         * set the color to blue the draw the board
         */
        if (location[0]==-1 && location[1] == -1)
        {
            StdDraw.setPenColor(StdDraw.BLUE);   // set the color
            for (int r = 0; r < num_rows; r++)
                for (int c = 0; c < num_cols; c++)
                {     
                   StdDraw.filledSquare(c+CENTER, r+CENTER, CENTER);   // draw a box
                }
        }
        else{
            if (isFlagOn) {
                addFlag(theMines.length, location, CENTER);
                return;
            }

            
        /*
         * TO BE IMPLEMENTED BY YOU:
         * Only draw the square indicated by location using the same filledSquare command used above.
         * If they selected a cell that contains a mine, draw the square in red
         * Otherwise, fill the cell in green.  
         *            If the number of neighbors is not 0, write the number of neighbors using the command:
         *                      StdDraw.text(c+ CENTER, r + CENTER, "" + theMines[r][c]);
         *            You will need to change the color of the pen to black in order to see it
         *                      
         * Finally, if gameIsOver is true, draw the number of neighbors/mines for EVERY cell.  Do not change
         * the color of any cell.  You will neet to change the color of the pen to black in order to see it.
         */
    }
        
        ///////////////////////////////  REMOVE THE NEXT 12-13 LINES ///////////////////////////////////
        ///   These are included so you can see the numbering of cells ONLY - not part of the final game
        String output;    
        for (int r = 0; r < num_rows; r++)
                for (int c = 0; c < num_cols; c++)
                {     
                    StdDraw.setPenColor(StdDraw.CYAN);   // set the color

                    int draw_row = num_rows - 1 - r;          // r will be used for the ROW in the arrays, 
                                                              // draw_row will be used for drawing the box 
                    StdDraw.filledSquare(c+CENTER, draw_row+CENTER, CENTER);   // draw a box
                    StdDraw.setPenColor(StdDraw.BLACK);
                    output = r+", "+c;
                    StdDraw.text(c+CENTER, draw_row+CENTER, output);

                }
        ///////////////////////////////  REMOVE ALL OF THIS ///////////////////////////////////
 
    }

    /**
     * main    - Runs the game 
     */
    public static void main(String[] args) {
        final  int ROW_SIZE = 10;  // the number of rows in the game board
        final  int COL_SIZE = 10;  // the number of columns in the game board

        int[] location = {-1,-1};  // an (row, col) coordinate pair needed for identifying the cell
                                   // selected by the mouseclick.
        boolean canMove = true;    // used to determine when the game is over
        boolean[][] board = new boolean[ROW_SIZE][COL_SIZE];
        int[][] theMines = new int[ROW_SIZE][COL_SIZE];

        setup(board, theMines);     // Initialize the board(s)
        location = handleMouseClick(board);    //   REMOVE  - THIS IS TO GET YOU STARTED ////////////////////////
        draw_board(board, theMines,false, location);    //   REMOVE  - THIS IS TO GET YOU STARTED ////////////////////////

        while (canMove)
        {
            location = handleMouseClick(board);    // get the location where the mouse was clicked
            draw_board(board, theMines, false, location);    // update the board

            if (gameIsOver(board, theMines, location) !=0)   //  the game is over
                canMove = false;
        } 
        draw_board(board, theMines, true, location);    // draw the final board
        endBanner(board, theMines, location);   // give the reason
    }
}