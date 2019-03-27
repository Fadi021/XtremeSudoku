

//Implementation Test case
// In this part we are implementing the Sudoku Game 
// This test case prints a sudoku 9x9 Grid
// All the 0's int the grid are considered in the blanks spost for the game Input
// Expected use: When user makes input to create new game this inpute is capture by the Action controller
//then the gamem class is called to create the new game
// when finnish Game class notifies the observers and Updates game with updateAction
// This is verifying that the class communicate correctly and when a new game is created the Wholy system is notifies
// Expected Values
// 9x9 Sudoku grid
// True : means that the updater was notified by the TestHelper when the game was created

public class ImplementationTest {
	
	   public static void main(String args[]) {
		   TestHelper test = new TestHelper();
		   UnitTestUpdater Update = new UnitTestUpdater();
		   
		   test.test1(Update);
		   test.print(test.test1(Update));
		   System.out.println(Update.getUpdateNotification());
	    }
}
