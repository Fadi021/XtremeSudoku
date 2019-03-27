
import java.util.Objects;

// Unit test 3:
// Expected value NullpointerException
// What happens when you try to make the system print a empty  Grid
//We can import the object class and catch this Exception
// is not recommended to catch null exception is better to avoid them
//When runnig this program you will get
public class unitTestNullException {

	 public static void main(String args[]) {
		 
		 TestHelper getVal = new TestHelper();
		 testObjects(getVal.test);
	    }
	 public static void testObjects(Object arg) {
		  Object checked = Objects.requireNonNull(arg, "Argument Should not be Null");
		  checked.toString();
		}

}
