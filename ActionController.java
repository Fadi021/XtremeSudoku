//import libraries needed to perform various functions
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



// This class controls all the actions in the Input Panel and sends updates to the other classes
public class ActionController implements ActionListener {
 private Game game;

 public ActionController(Game game) {
  this.game = game;
 }

// Performs the action inputed by the user
// Sends an Update to the Game class based on the input of the User
 public void actionPerformed(ActionEvent e) {
  if (e.getActionCommand().equals("New"))
   game.createGame();
  else if (e.getActionCommand().equals("Close"))
   System.exit(0);

  else
   game.setInputNumber(Integer.parseInt(e.getActionCommand()));
 }
}
