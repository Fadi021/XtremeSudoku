
import java.util.Scanner;

public class unitTestUpdateNotification {
	static TestHelper test = new TestHelper();
	public static void main(String []args){
		Scanner testIn = new Scanner(System.in);
		System.out.println(" 1 to Update ActionListener");
		System.out.println(" 2 Not to Update ActionListener");
		int number = testIn.nextInt();
		
		while(true){
			if(number == 1){
				test.update();
				System.out.println(test.getUpdate());
				break;
			}
			else if(number == 2){
				System.out.println(test.getUpdate());
				break;
			}
			
		}
	 }
	

}
