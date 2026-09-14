/*
$$$$$$$$$$$$$$$$$$
$$$Requirements$$$
$$$$$$$$$$$$$$$$$$

4 colored home quadrants.
Players take turns rolling a six-sided die, deploying tokens out of their yard, and marching them around a track to reach the home goal cell

*/

/*
******************
***Objects List***
******************

player 1 throws dice. Depending on score, moves their pieces. Turn goes to player 2 and repeats.


* The dice. It rolls and tells a number 1-6, whenever it is rolled.

* A piece knows its position.

* Player knows its color. Has reference to its pieces.

* We need a board to tell the terrain, either what is the next cell and what are the rules of that cell.

* We also need cell. The track would be made of these. This is because -
1) Here there is not 2D space. But its one-way track, so we need the concept of "next" cell, or chain.


* We need input: to capture player clicks (piece, position, dice)

* We need display: to draw board, to show current player's state

* We need controller: manages turn loop rotation and enforces state machine locks

* We need composite : creates stuff and injects into controller

* We need main: creates composite and starts the game

*/

/*
**********
***Dice***
**********

* Knows: number of faces
* Does: tell a random number from 1 to 6
* Collab: none

*/

/*
***********
***Piece***
***********

* Knows: Its position, color
* Does: Moves to given position
* Collab: none

*/

/*
************
***Player***
************

* Knows: list of its pieces, its color, its state (won or not)
* Does: 
** // NO: agrees to roll dice when asked. No, player is not representing real human. So, its passive and not interacts with input or display
** // NO: picks which piece to move
** moves to a position when asked
* Collab: none

*/

/*
*********
***map***
*********

* Knows: list of cells
* Does: tells which cell is the next cell to a given cell
* Collab: none

*/

/*
**********
***Cell***
**********

* Knows: Its type (yard, startingSpace, normalTrack, starSpace, homeColumn, homeTriangle)
* Does: 
* Collab: none

*/

/*
***********
***Input***
***********

* Knows: last input
* Does: Read user click and saves
* Collab: none

*/

/*
*************
***Display***
*************

* Knows: paintSymbol for different grid information
* Does: paints the grid
* Collab: none

*/

/*
****************
***Controller***
****************

* Knows: Players, map, input, display, dice
* Does: starts the game and prompts player 1 to throw dice. On each player's turn, prompts the player to throw dice. When user responds, it takes the input from the input. It then rolls the dice and asks user for which move it wants to move. Then it validates the move and tells the player that you can move that piece to that position. Player moves to that position that piece. Once that move has been made, controller checks, what state should game be in, and on basis of that decides next and can pass dice prompt to another player or same player.  
* Collab: input, display, dice, players, map

*/

/*
***************
***Composite***
***************

* Knows:
* Does: Creates dice, display, input, map, player with pieces, and passes to controller. 
* Does: Starts the game
* Collab: dice, display, input, map, player, piece, controller

*/

/*
**********
***Main***
**********

* Knows: Config?
* Does: Passes config to composite, and starts
* Collab: composite

*/


