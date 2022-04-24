# project-hofstra_shangold_wang
project-hofstra_shangold_wang created by GitHub Classroom
## Note: this was formerly the Note Creator Project
# READ ME FOR HOW TO PLAY
After you call the script, the game will ask you for your and your opponent's names (you will alternate turns with your opponent). NOTE: If you wish to player a computer, type in "computer" for the name of player 2. Each of you will start with 7 cards in your deck. When prompted you can ask for cards 1-13 (representing Ace-King in a deck of cards). If you find a card in an opponent's deck, you will take their card and get 1 point added to your score. If not, you will "go fish" in the main deck of cards, and automatically take one card. If you have a set of three cards, 5 points will be added to your score. Right now, we currently have the game set up so whoever gets 5 points first, wins (just to keep the game quick, for now).

# Overall info for Iteration 3 (was note creator app, now changed to go fish app)

### What user stories were completed this iteration? 
We worked on the go fish game during this iteration. More specifically, we developed an extension of the Player object so we can have a computer play against a user; we added more methods to print out the contents of the players' decks; we added methods to confirm that a player can rightfully ask for a card; and we refactored the class that calls all of these other classes and methods to actually run the program.

### Is there anything that you implemented but doesn't currently work? 
Nope!

### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
Just call the script!:)

# Primary Branches that we created for the game

### go-fish-script Branch
Includes the script that runs the game.

### play-game Branch
Includes tha main class that calls other classes and methods to run the game.

### player Branch
Creates the player object, with deck, name, and points instance variables.

### ComputerPlayer Barnch
Appends computer/automated selection methods to the player object and the goFish class

### shuffle_deck Branch
Includes methods that can be implemented to fill, alter, and delete the contents of Players' decks.

### add-print-deck-to-game
Includes methods and additions to methods that prints out the players' decks each turn

### clean-code
We used this branch to focus on refactoring the Game and goFish classes (abstracting methods, more tests, etc...)

### update-points-when-sets
Includes methods that updates a Player's points and deck when they have 3 of the same number card in their deck

### Player-deck-helper-methods Branch
Helper methods were made to help with game functionality. This includes methods to check if a player has a given card and methods to take cards from another player or the main deck. Methods were also made to determine when a player has a full set of any card number or if any deck is out of cards. Methods can be added for a computer player to automate parts of a turn. This would allow users to play both against other players or against the computer.




