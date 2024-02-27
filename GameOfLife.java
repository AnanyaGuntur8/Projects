package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.

 * @author Seth Kelley 
 * @author Maxwell Goldberg
 */
public class GameOfLife {

    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;

    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)

    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */
    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }

    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */
    public GameOfLife (String file) {

        // WRITE YOUR CODE HERE
        StdIn.setFile(file);
        //rows and columns 
        int row = StdIn.readInt();
        int col = StdIn.readInt();
        //set the state of the grid and check if it's alive or not 
        //initialize the grid
        grid = new boolean[row][col];
        //Traverse through the grid
        for(int r=0; r <row; r++){
            for(int c=0; c<col; c++ ){
                //check the value of the grid
                grid[r][c] = StdIn.readBoolean();
                //reading the nubmer of alive cells
            
            if(grid[r][c]){
                    totalAliveCells++;
                }
            }
        }



    }

    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {
        return grid;
    }
    
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        return totalAliveCells;
    }

    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {
        // WRITE YOUR CODE HERE
        //giving you the value of the grid
        if(grid[row][col]){
            return true;
        }
        return false; // update this line, provided so that code compiles
    }

    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive () {
        //traverse through the grid to find the state of the cell
        for(int r= 0; r<grid.length; r++){
            for(int c = 0; c<grid[r].length; c++){
                if(grid[r][c]){
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are 
     * horizontally, vertically, or diagonally adjacent.
     * 
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {
        //first write the code for if the cell is adjancent to the alive cell
        //see if the cell is adjectne
        int aliveNeighbors = 0;
        int numberOfRows= grid.length;
        int numberOfCol = grid[0].length; //finds the number of rwos
        for(int i=-1; i<=1;i++){
            for(int j=-1; j<=1;j++){
                //consider wrapping, it;s a circle, shift the graph
            int wrapRow = (row+i+ numberOfRows) %numberOfRows;
            //reusing the cycle to reset

            //wraps the grid because it lowkey duplicates the grid
            int wrapCol = (col+j+ numberOfCol  ) %numberOfCol;//again wraps the grid by saying starting point, moving to the j value then adding the number of colums 
            //and then dividing whole numbers to find how many rows are remaining. THis wraps the grid because it goes back to the starting point after you do the mod
            //recieved help from a peer.  
                
                if((i!=0||j!=0)&&grid[wrapRow][wrapCol]){
                    //chack if the neighboring cell
                        aliveNeighbors +=1;

                }
//col+ row? side eye

            }
        }
        return aliveNeighbors; // update this line, provided so that code compiles
    }

    /**
     * Creates a new grid with the next generation of the current grid using 
     * the rules for Conway's Game of Life.
     * 
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {
        boolean[][] otherGrid = new boolean[grid.length][grid[0].length];
        // WRITE YOUR CODE HERE
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[r].length;c++){
                //call num to check the number of alive neighbors
                
                int numberOfAliveNeighbors = numOfAliveNeighbors(r, c);
                if(grid[r][c]){
                    if(numberOfAliveNeighbors<=1){
                        otherGrid[r][c]=false;
                    }
                    else if(numberOfAliveNeighbors==2|| numberOfAliveNeighbors==3){
                        otherGrid[r][c]=true;
                    }
                    else if(numberOfAliveNeighbors>=4){
                        otherGrid[r][c]=false;
                    }
                //cound tht enumber of alive neighbors
                //check if the cell is alive or not and then call num of alive neighbors

               } 
               else{ 
                if(!(grid[r][c])){
                if(numberOfAliveNeighbors==3){
                    otherGrid[r][c]=true;
                }
               }

               }
            }
            }
    return otherGrid;
        }
        //rules of the game: for each cell, use the numOfAliveNeighbors method to determine how many cells are alive around a ce

        
        //once u get the number of alive neighbors, you check the cell is alive, if it's that then you check ifit has two to three nieghbors then you add that cell to the new grid. 
    // num of neighbors that are alive and you have to check if the cell is alive or not if cell is alive and it has two three N then it gets added to the 2d array array Ij 

    /**
     * Updates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     * 
     * Updates totalAliveCells instance variable
     */
    public void nextGeneration () {
//create a new board (grid) to be returned, representing the new generation 
    boolean[][] newGrid= computeNewGrid();
    //update the current grid
    //ur current grid becomes the new grid
    grid=newGrid;
    //copunt the new number of alivecells 
    for(int r= 0;r<grid.length;r++){
        for(int c = 0;c<grid[0].length;c++){
            if(grid[r][c]){
                totalAliveCells++;
            }
        }
    }
        // WRITE YOUR CODE HERE
    }

    /**
     * Updates the current grid with the grid computed after multiple (n) generations. 
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {    
        for(int i= 0; i<n;i++){
            nextGeneration();
        }
        // WRITE YOUR CODE HERE
    }

    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    public int numOfCommunities() {
        //implement union-find 
        //if a cell is given to , youre iterating thru the grid and you find if the cell is alive and check it's neig and union
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(grid.length, grid[0].length);
        //traverse thru the grid
        for(int r=0; r<grid.length;r++){
            for(int c=0; c<grid[r].length;c++){
            
                // first find cell alive or not
                if(grid[r][c]){
                   //after determine the neighbors of the cell
                   
                   int numberOfRows= grid.length;
                   int numberOfCol = grid[0].length;
                    for(int i=-1; i<=1;i++){
                        for(int j=-1; j<=1;j++){
                        //consider wrapping, it;s a circle, shift the graph
                            int wrapRow = (r+i+ numberOfRows)%numberOfRows;
                            //reusing the cycle to reset
        
                            //wraps the grid because it lowkey duplicates the grid
                            int wrapCol = (c+j+numberOfCol)%numberOfCol;//again wraps the grid by saying starting point, moving to the j value then adding the number of colums 
        //and then dividing whole numbers to find how many rows are remaining. THis wraps the grid because it goes back to the starting point after you do the mod
    //recieved help from a peer.  
                        
                            if((i!=0||j!=0)&&grid[wrapRow][wrapCol]){
            //reusing the cycle to reset
                                uf.union(r, c, wrapRow, wrapCol);
                                //foud=nd comm. 
        //wraps the grid because it lowkey duplicates the grid
                            }
                        }
        
                    }
                    
                }
            }


            
        }
        //return counter 
        int com = 0; 
        for(int i=0; i<grid.length; i++){
        for(int j=0;j<grid[i].length; j++){
                //traversing the array and using the private function 
                     int convert = i * grid[i].length + j;
                if(grid[i][j]&&(uf.find(i, j)==convert)){
            
                    com+=1;
                }
            }
        }

        return com; 
    }
}

