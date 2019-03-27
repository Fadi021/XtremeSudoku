import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;


//Main class of the game 
//Implements the Look and feel of the game

public class ExtremeSudoku extends JFrame {
 public ExtremeSudoku() {
   
  super("ExtrmeSudoku");
  Game game = new Game();	
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  getContentPane().setLayout(new BorderLayout());

 
//Creates the the game to be played
//JPanles and Controller are set 
//add observer on inputs Panel and Extreme Panel
 
  ActionController actionController = new ActionController(game);
  InputsPanel inputsPanel = new InputsPanel();
  inputsPanel.setController(actionController);
  add(inputsPanel, BorderLayout.NORTH);

  ExtremePanel extremePanel = new ExtremePanel();
  ExtremeController extremeController = new ExtremeController(extremePanel, game);
  extremePanel.setGame(game);
  extremePanel.setExtremeController(extremeController);
  add(extremePanel, BorderLayout.CENTER);

  game.addObserver(inputsPanel);
  game.addObserver(extremePanel);

  pack();
  setLocationRelativeTo(null);
  setVisible(true);
 }

 public static void main(String[] args) {

  try {
   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  } catch (Exception ex) {
   ex.printStackTrace();
  }
  new ExtremeSudoku();
 }
}