import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


// Controls all inputs made by the user in Extreme panel

public class ExtremeController implements MouseListener {
 private ExtremePanel extremePanel; 
 private Game game; 

 
 public void mouseClicked(MouseEvent e) {}
 public void mouseEntered(MouseEvent e) {}
 public void mouseExited(MouseEvent e) {}
 public void mouseReleased(MouseEvent e) {}
 
 // Sets game panel to control(extremePanel) and conects it to the game
 
 
 public ExtremeController(ExtremePanel extremePanel, Game game) {
  this.extremePanel = extremePanel;
  this.game = game;
 }

//When user tries to input numbers, this functions is called and updates the game based off the action
 
 public void mousePressed(MouseEvent e) {
  JPanel panel = (JPanel) e.getSource();
  Component component = panel.getComponentAt(e.getPoint());
  if (component instanceof Grid) {
   Grid grid = (Grid) component;
   int x = grid.getXpos();
   int y = grid.getYPos();

//Controls inputs made by the User, evaluates them and Updates candiates in Class UpdateAction 
   
   if (e.getButton() == MouseEvent.BUTTON1) {
    int number = game.getInputNumber(); 
    grid.setInput(number, true);
   }
  }
 }


}
