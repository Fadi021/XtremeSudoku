import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


// ExtremePanel creates the Input panels
// Interacts with Update action class to Update the game
public class ExtremePanel extends JPanel implements Observer {

 private Grid[][] sudokuGrid; // Array of fields.
 private JPanel[][] sudokuPanel; // Panels holding the fields.

 //Creates grid and concatenates it with Panel
 public ExtremePanel() {
  super(new GridLayout(3, 3));

  sudokuPanel = new JPanel[3][3];
  for (int y = 0; y < 3; y++) {
   for (int x = 0; x < 3; x++) {
    sudokuPanel[y][x] = new JPanel(new GridLayout(3, 3));
    sudokuPanel[y][x].setBorder(BorderFactory.createLineBorder(Color.GRAY));
    add(sudokuPanel[y][x]);
   }
  }

  sudokuGrid = new Grid[9][9];
  for (int y = 0; y < 9; y++) {
   for (int x = 0; x < 9; x++) {
    sudokuGrid[y][x] = new Grid(x, y);
    sudokuPanel[y / 3][x / 3].add(sudokuGrid[y][x]);
   }
  }
 }



 //Creates game hides Number Candidates to create Game
 public void setGame(Game game) {
  for (int y = 0; y < 9; y++) {
   for (int x = 0; x < 9; x++) {
    sudokuGrid[y][x].setBackground(Color.WHITE);
    sudokuGrid[y][x].setInput(game.getNumber(x, y), false);
   }
  }
 }



//input listener connects extreme panel to extreme controller inputs are Controled by the Controller
 public void setExtremeController(ExtremeController extremeController) {
  for (int y = 0; y < 3; y++) {
   for (int x = 0; x < 3; x++)
    sudokuPanel[y][x].addMouseListener(extremeController);
  }
 }
 
 //Update notification
 public void update(Observable o, Object arg) {
  switch ((UpdateAction) arg) {
   case NEW_GAME:
    setGame((Game) o);
    break;

  }
 }
 
}
