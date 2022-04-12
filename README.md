# project-hofstra_shangold_wang
project-hofstra_shangold_wang created by GitHub Classroom

# READ ME FOR HOW TO PLAY
After you call the script, the game will ask you for your and your opponent's names (you will alternate turns with your opponent). Each of you will start with 7 cards in your deck. When prompted you can ask for cards 1-13 (representing Ace-King in a deck of cards). If you find a card in an opponent's deck, you will take their card and get 1 point added to your score. If not, you will "go fish" in the main deck of cards, and automatically take one card. If you have a set of three cards, 5 points will be added to your score. Right now, we currently have the game set up so whoever gets 5 points first, wins (just to keep the game quick, for now).

# Overall info for Iteration 2 (was note creator app, now changed to go fish app)

## What user stories were completed this iteration? 
We worked on the the go fish game during this iteration. More specifically, we developed a Player object; a class that keeps track of the Player's deck of cards and alters them when needed; a class that updates the Player's points when there exists a set of three of the same cards in the Player's deck; and a class that calls all of these other classes and methods to actually run the program.

## What user stories do you intend to complete next iteration? 
We intend to make a Computer player object, as right now there can only be human-user players. Also, we want to add different game functionality with more rule flexibility and have the user decide how many players can play the game, as right now, only two players can play at a time.

## Is there anything that you implemented but doesn't currently work? 
The update-points-when-sets class is still a work in progress; and currently, if you take a card from a player, the other player will be able to take the card right back. We plan on fixing this in the next iteration.

## What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
Just call the script!:)

## Primary Branches that we created for the game

### go-fish-script Branch
Includes the script that runs the game.

### play-game Branch
Includes tha main class that calls other classes and methods to run the game.

### player Branch
Creates the player object, with deck, name, and points instance variables.

### shuffle_deck Branch
Includes methods that can be implemented to fill, alter, and delete the contents of Players' decks.

### update-points-when-sets
Includes methods that updates a Player's points and deck when they have 3 of the same number card in their deck

### Player-deck-helper-methods Branch
Helper methods were made to help with game functionality. This includes methods to check if a player has a given card and methods to take cards from another player or the main deck. Methods were also made to determine when a player has a full set of any card number or if any deck is out of cards. Methods can be added for a computer player to automate parts of a turn. This would allow users to play both against other players or against the computer.




