 ----Battle Ships-------
Step 1 – Create the ocean map: 
The ocean map is represented by a 10 by 10 grid of different characters. The grid is managed by a two dimensional array. You will use this 2D array to save where the user and computer decide to place their ships, as well as when someone tries to attack a location and misses. At the start of the game the array 
will be empty and as the game is played you will change what is stored at each index of the array accordingly.
Once you create your 2D array you need a way to display it to the user so they can choose coordinates.

Step 2 – Deploy player’s ships: 
Once you have your ocean map, you'll need to ask the user where they would like to place their ships. 
The player should deploy 5 ships. A ship will be stored in a single index of the array as a special character. 
To place the player's ships, they need to tell you the coordinates of where the ship should be placed, and you need to update the ocean map to reflect their choices. 
Use a Scanner to allow the user to enter in input.

Step 3 – Deploy computer’s ships: 
The computer will deploy 5 ships by randomly picking X and Y coordinates. Your code is responsible for generating these locations, checking if they are valid, and if so placing the ships accordingly.
• you cannot place the ship on a location that is already taken by another ship (player’s or computer’s)
• you can’t place ships outside the 10 by 10 grid
If the computer tries to place the ship somewhere it can't be, regenerate random coordinates until all ships are placed appropriately.

Step 4 – Battle: 
Player's Turn
Once the player and computer have placed their ships it's time to start the battle! During the battle, the player and computer will take turns guessing X and Y coordinates of the opponent’s ships.
Every coordinate guessed should be marked so they players know not to guess there again.
When the player enters X and Y coordinates you should check if those coordinates are valid within the Ocean Map and haven't been guessed by the user yet, keep re-prompting until the user enters a valid guess. 
Once the guess is valid your program needs to evaluate the result of the move.
Computer's Turn
After the player guesses a coordinate it's the computer's turn to guess. The computer's attack should be two randomly generated coordinates. 
You will need to keep generating random numbers until you get a valid guess, meaning a location that is within the bounds of the board and the computer hasn't already guessed.
Once the computer makes a valid guess, you want to print a little update to the user.
The battle will continue to run until one of the players is out of ships.

Step 5 - Game Over: 
The game is over when one player or computer has no ship left.
