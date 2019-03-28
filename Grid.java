import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Grid extends JLabel {
 private int xPos;
 private int yPos; 

// Set X and Y position on the Grid for the Game which creates our 2d dimension game
 public Grid(int x, int y) {
  super("", CENTER);
  this.xPos = x;
  this.yPos = y;
  
  // Create the dimensions of the board as well as the
  // Colour and Font
  setPreferredSize(new Dimension(50, 50));
  setBorder(BorderFactory.createLineBorder(Color.BLACK));
  setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
  setOpaque(true);
 }

//Input sets input depending if input is from user or not
 // checks for proper input from the user
 public void setInput(int number, boolean userInput) {
  setText(number > 0 ? number + "" : "");
 }

//returns the x and y position

 public int getXpos() {
  return xPos;
 }

 public int getYPos() {
  return yPos;
 }
}
