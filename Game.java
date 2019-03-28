import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

//This class represents the game Creates a solution for the game to be used for the game

public class Game extends Observable {
 //Generates game and solution
 //Check inputs of the user to check for Valid input

 private int[][] solution;
 private int[][] playable;
 private int inputNumber;



//genereate soultion for the sudoku game
// takes a number of the list and check if is a posible solution in the given X Y position for game
 
 private int[][] solutionSudoku(int[][] game, int index) {
  if (index > 80)
   return game;

  int x = index % 9;
  int y = index / 9;

  List < Integer > numbers = new ArrayList < Integer > ();
  for (int i = 1; i <= 9; i++) numbers.add(i);
  Collections.shuffle(numbers);

  while (numbers.size() > 0) {
   int number = nextNumber(game, x, y, numbers);
   if (number == -1)
    return null;

   game[y][x] = number;
   int[][] tmpGame = solutionSudoku(game, index + 1);
   if (tmpGame != null)
    return tmpGame;
   game[y][x] = 0;
  }

  return null;
 }
 
//Copies the solution of the game 
 
private int[][] copy(int[][] game) {
int[][] copy = new int[9][9];
for (int y = 0; y < 9; y++) {
 for (int x = 0; x < 9; x++)
  copy[y][x] = game[y][x];
}
return copy;
}


// Generates the Game
// Fills a list with possible positions
// The list is shuffled and passed through the method gamecreator
 // abd the return value is returned
 private int[][] gameCreator(int[][] game) {
  List < Integer > positions = new ArrayList < Integer > ();
  for (int i = 0; i < 81; i++)
   positions.add(i);
  Collections.shuffle(positions);
  return gameCreator(game, positions);
 }

// generates game from solution and calls isValid to validate the inputs
 
 private int[][] gameCreator(int[][] game, List < Integer > positions) {
  while (positions.size() > 0) {
   int position = positions.remove(0);
   int x = position % 9;
   int y = position / 9;
   int temp = game[y][x];
   game[y][x] = 0;
   if (!validated(game))
    game[y][x] = temp;
  }

  return game;
 }

//Validates the game
 //compares the numbers with the one of the Solutions

 private boolean validated(int[][] game) {
  return validated(game, 0, new int[] {
   0
  });
 }

 
 //Is validates the input:  From the generated solution
 //any parameter position XY = 0 are considerd blanks then every value gets a numbers a tries to find multiple solutions
 

 private boolean validated(int[][] game, int index, int[] numberOfSolutions) {
  if (index > 80)
   return ++numberOfSolutions[0] == 1;

  int x = index % 9;
  int y = index / 9;

  if (game[y][x] == 0) {
   List < Integer > numbers = new ArrayList < Integer > ();
   for (int i = 1; i <= 9; i++)
    numbers.add(i);

   while (numbers.size() > 0) {
    int number = nextNumber(game, x, y, numbers);
    if (number == -1)
     break;
    game[y][x] = number;

    if (!validated(game, index + 1, numberOfSolutions)) {
     game[y][x] = 0;
     return false;
    }
    game[y][x] = 0;
   }
  } else if (!validated(game, index + 1, numberOfSolutions))
   return false;

  return true;
 }




 public Game() {
  createGame();
 
 }

//generates a new game upon input command from The inputs Pannel
 // Sends and updated the UpdateAction
 
 public void createGame() {
  solution = solutionSudoku(new int[9][9], 0);
  playable = gameCreator(copy(solution));
  setChanged();
  notifyObservers(UpdateAction.NEW_GAME);
 }

//sets input done by the user from the Extreme Panel
 
 public void setInputNumber(int inputNumber) {
  this.inputNumber = inputNumber;
 
  
 }

// Gets the input enter by the user
 
 public int getInputNumber() {
  return inputNumber;
 }


// This sets of functions create A soultion and checks each user input with the solution
 
 
 public void setNumber(int x, int y, int number) {
  playable[y][x] = number;
 }


 public int getNumber(int x, int y) {
  return playable[y][x];
 }



 private boolean validX(int[][] game, int y, int number) {
  for (int x = 0; x < 9; x++) {
   if (game[y][x] == number)
    return false;
  }
  return true;
 }


 private boolean validY(int[][] game, int x, int number) {
  for (int y = 0; y < 9; y++) {
   if (game[y][x] == number)
    return false;
  }
  return true;
 }


 private boolean validBlock(int[][] game, int x, int y, int number) {
  int x1 = x < 3 ? 0 : x < 6 ? 3 : 6;
  int y1 = y < 3 ? 0 : y < 6 ? 3 : 6;
  for (int yy = y1; yy < y1 + 3; yy++) {
   for (int xx = x1; xx < x1 + 3; xx++) {
    if (game[yy][xx] == number)
     return false;
   }
  }
  return true;
 }


 private int nextNumber(int[][] game, int x, int y, List < Integer > numbers) {
  while (numbers.size() > 0) {
   int number = numbers.remove(0);
   if (validX(game, y, number) && validY(game, x, number) && validBlock(game, x, y, number))
    return number;
  }
  return -1;
 }


}
