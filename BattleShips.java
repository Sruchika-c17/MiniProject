package Project1;

import java.util.Scanner;

public class BattleShips {
	public static int Rows = 10;
    	public static int Cols = 10;
    	public static int pShips;//PlayerShips
    	public static int cShips;//ComputerShips
    	public static String[][] grid = new String[Rows][Cols];
    	public static int[][] missedGuesses = new int[Rows][Cols];

	public static void main(String[] args) {
	  System.out.println("**** Welcome to Battle Ships game ****");
          System.out.println("Right now, the sea is empty.");
   
        //Step 1 – Creating ocean map
        createOceanMap();

        //Step 2 – Deploy player’s ships
        deployPlayerShips();

        //Step 3 - Deploy computer's ships
        deployComputerShips();
        
        //Step 4 - Battle
        do {
            Battle();
        }
        while(BattleShips.pShips != 0 && BattleShips.cShips != 0);

        //Step 5 - Game over
        gameOver();
	}
	
	//creating ocean map
	public static void createOceanMap() {
		
		System.out.println("   0123456789");
		
		
		for(int i = 0; i < Rows; i++) {
            System.out.print(i + " |");

            for (int j = 0; j < Cols; j++){
            	grid[i][j]=" ";
                System.out.print(grid[i][j]);
            }

            System.out.println("| " + i);
        }

		
		System.out.println("   0123456789");
		
	}
	
	//To Deploy the player ships
	public static void deployPlayerShips() {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Deploy your ships:");
        //Player has to deploy 5 ships
        BattleShips.pShips = 5;
        for (int i = 1; i <= BattleShips.pShips;) {
            System.out.print("Enter X coordinate for your ship " + i + " : ");
            int x = sc.nextInt();
            System.out.print("Enter Y coordinate for your ship " + i + " : ");
            int y = sc.nextInt();

            if((x >= 0 && x < Rows) && (y >= 0 && y < Cols) && (grid[x][y] == " "))
            {
                grid[x][y] = "@";
                i++;
            }
            else if((x >= 0 && x < Rows) && (y >= 0 && y < Cols) && grid[x][y] == "@")
                System.out.println("You can't place two or more ships on the same location.");
            else if((x < 0 || x >= Rows) || (y < 0 || y >= Cols))
                System.out.println("You can't place ships outside the " + Rows + " by " + Cols + " grid.");
        }
        printOceanMap();   //printing the ocean map after deploying player ships
	}
	
	//To deploy computer ships randomly
	public static void deployComputerShips() {
	  System.out.println("Computer is deploying ships");
        //Deploying five ships for computer
        BattleShips.cShips = 5;
        for (int i = 1; i <= BattleShips.cShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);

            if((x >= 0 && x < Rows) && (y >= 0 && y < Cols) && (grid[x][y] == " "))
            {
                grid[x][y] = "x";
                System.out.println(i + ". ship DEPLOYED");
                i++;
            }
        }
	}
	
	//starting the battle
	public static void Battle() {
	  playerTurn();
          computerTurn();
          printOceanMap();

        System.out.println();
        System.out.println("Your ships: " + BattleShips.pShips + " | Computer ships: " + BattleShips.cShips);
        System.out.println();	
	}
	
	public static void playerTurn() {

	  System.out.println("YOUR TURN");
	  int x,y;
        do {

          Scanner sc = new Scanner(System.in);
          System.out.print("Enter X coordinate: ");
          x = sc.nextInt();
          System.out.print("Enter Y coordinate: ");
          y = sc.nextInt();
            
          if ((x >= 0 && x < Rows) && (y >= 0 && y < Cols)) //valid guess
          {
        	  if (grid[x][y] == "x") //if computer ship is already there then computer loses ship
              {
        		  System.out.println("Boom! You sunk the ship!");
                  grid[x][y] = "!"; //Marking as Hit 
                  --BattleShips.cShips;
               }
               else if (grid[x][y] == "@") {
            	   System.out.println("Oh no, you sunk your own ship :(");
                   grid[x][y] = "x";
                   --BattleShips.pShips;
                   ++BattleShips.cShips;
               }
               else if (grid[x][y] == " ") {
                   System.out.println("Sorry, you missed");
                   grid[x][y] = "-";
               }
           }
           else if ((x < 0 || x >= Rows) || (y < 0 || y >= Cols))  //invalid guess
               System.out.println("You can't place ships outside the " + Rows + " by " + Cols + " grid");
       }
       while((x < 0 || x >= Rows) || (y < 0 || y >= Cols));  //keep re-prompting till valid guess
}
	
	public static void computerTurn() {
		
	   System.out.println("COMPUTER'S TURN");
        //Computer guessing co-ordinates
        int x,y;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);

            if ((x >= 0 && x < Rows) && (y >= 0 && y < Cols)) //valid guess
            {
                if (grid[x][y] == "@") //if player ship is already there then player looses ship
                {
                    System.out.println("The Computer sunk one of your ships!");
                    grid[x][y] = "x";   
                    --BattleShips.pShips;
                    ++BattleShips.cShips;
                }
                else if (grid[x][y] == "x") {
                    System.out.println("The Computer sunk one of its own ships");
                    grid[x][y] = "!";   //Marking as Hit
                    --BattleShips.cShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Computer missed");
                  //Saving missed guesses for computer
                    if(missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1;

                }
            }
        }
        while((x < 0 || x >= Rows) || (y < 0 || y >= Cols));  //keep re-prompting till valid guess
	}

	public static void gameOver() {
	  System.out.println("Your ships: " + BattleShips.pShips + " | Computer ships: " + BattleShips.cShips);
        if(BattleShips.pShips > 0 && BattleShips.cShips <= 0)
            System.out.println("Hurray! You win the battle :)");
        else
            System.out.println("Sorry, you lost the battle");
        System.out.println();
	}
	
	//To print the ocean map
	public static void printOceanMap(){
        System.out.println();
        System.out.println("   0123456789");
        
        for(int x = 0; x < Rows; x++) {
            System.out.print(x + " |");

            for (int y = 0; y < Cols; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("| " + x);
        }

        System.out.println("   0123456789");
        
    }
}