

To run you need to Dowload this:
  - Need java compiler
  - Download the XtremeSudoku.ZIP 
 extract file on any folder of your choosing

how to run:
- Open Command prompt and complie ExtremeSudoku.java 
- ExtremeSudoku is the main part of the game and it calls and creates all the classes
- Change Directory to the the folder containing the ExtremeSudoku.java
- run program
  - javac ExtremeSudoku.java
  - java ExtremeSudoku
 
# XtremeSudoku

ExtremeSudoku implements the game of Sudoku on a Java application. It was writen using Jave SE 8.
XtremeSudoku uses swing to create a GUI

- Class Explanation:
  - ExtremeSudoku(): Is the Main/Start part of the game. It builds up the classesand creates the interface of the game. prints out plyable game 
  - InputsPanel(): Creates two panels for User Input.
  - ExtremePanel(): creates pannel to be buit for the grid Input
  - Grid(): Creates a grid for the game
  - Game(): Prints out a 9x9 sudoku game with 0. all the 0 represent blank spots for user input
  - UpdateAction(): Updates The action done by the Controller and connects them to the panels
  - ExtremeController(): Controls all the action done in the Extreme panel / grid inputs updates game class for change
  - ActionController(): This class controls all the action done in the Input Panel sends update the other classes depending on user input
- User Story 
  - ExtremeSudoku upon the starting of the game user is showed with a 9x9 Sudoku grid. The user completes the game filling in the blanks     spots with the correct number. When user inputs a number they toggle a Button this action is captured by the ActionController then       calls the setInputNumber function in the Game class. The Game class would then notify the ExtremePanel class that the game has been     updated. Extreme panel sets up the game depending on user input. When User clicks on “New” button. The action done by the User is       going to be captured by the ActionController class this class calls the Game class to create a new 9x9 Sudoku grid. After creating       the game the Game class will notify the Observer to and the game will be Updated. When the user hits the “Exit” button UpdateAction     will call the System.exit(0). This will cause the ExtremeSudoku app to terminate.




