import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



// This class controls all the action done in the Input Panel sends update the other classes depending on user input
public class ActionController implements ActionListener {
 private Game game;

 public ActionController(Game game) {
  this.game = game;
 }

// Preforms the action done by user making an input in the game
//Sends an Update to the Game class to be updated based on the input of the User
 public void actionPerformed(ActionEvent e) {
  if (e.getActionCommand().equals("New"))
   game.createGame();
  else if (e.getActionCommand().equals("Close"))
   System.exit(0);

  else
   game.setInputNumber(Integer.parseInt(e.getActionCommand()));
 }
}