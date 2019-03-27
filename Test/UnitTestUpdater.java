

//
public class UnitTestUpdater {
    static boolean newGameInput = false;
    
	public static void update(){
		newGameInput = true;
		
	}
	public static boolean getUpdateNotification(){
		return newGameInput;
	}
	
	
 
    
    
}