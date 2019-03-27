
import java.util.List;

public class unitTestValidX {
	
//Test case for validX
// This method is called by generatesolution to check if there is a position avaible 
// Validate:
// When generatesolution creates a new souliton positons are for the numbers are validated 
// generateSolution sends a 9x9 grid
// position and number int the input are compared
// True: when number in position [x][y] is equal to the number for the generatedSolution checks all the numbers in the X row
// False: when number in x = positon[x][y] is equal to 0
// Expected values: when the number in the pos[x][y] = 0 and the number from Solution equals = 0

    public static void main(String args[]) {
         System.out.println(validX(0,0));
         System.out.println(validX(2,-1));
    }
    
     public static boolean validX(int posibleNumber, int number) {

		   if (posibleNumber == number){
		    return false;
		   }
		  return true;
		 }
     
  
}
