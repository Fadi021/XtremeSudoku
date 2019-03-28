//All the libraries required to be imported and used 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;



public class InputsPanel extends JPanel implements Observer {
	
//Buttons To be Representend on the Inputs panel	

 ButtonGroup groupNum; 
 JToggleButton[] numberBTN; 
 JButton newBTN;
 JButton exitBTN; 

//Allows an Update for Notification to UpdateAction
 public void update(Observable o, Object arg) {
  switch ((UpdateAction) arg) {
   case NEW_GAME:
    break;
  }
 }
 // Sets controller to Control inputs done by the user calls Action Controller class
 public void setController(ActionController actionController) {
  newBTN.addActionListener(actionController);
  exitBTN.addActionListener(actionController);

  for (int i = 0; i < 9; i++)
   numberBTN[i].addActionListener(actionController);
 }


// border layout disply for the game

public InputsPanel() {
  super(new BorderLayout());
  
  groupNum = new ButtonGroup();
  numberBTN = new JToggleButton[9];
  
  //Creates Panels and buttons of the game 
  
  JPanel gameAlign = new JPanel();
  gameAlign.setLayout(new BoxLayout(gameAlign, BoxLayout.PAGE_AXIS));
  add(gameAlign, BorderLayout.NORTH);
  JPanel gameOptions = new JPanel(new FlowLayout(FlowLayout.LEADING));
  gameOptions.setBorder(BorderFactory.createTitledBorder(" Menu "));
  gameAlign.add(gameOptions);
  exitBTN = new JButton("Close");
  exitBTN.setFocusable(false);
  gameOptions.add(exitBTN);
  newBTN = new JButton("New");
  newBTN.setFocusable(false);
  gameOptions.add(newBTN);
// object being created to be used in layout
 
JPanel gameNumbers = new JPanel();
  gameNumbers.setLayout(new BoxLayout(gameNumbers, BoxLayout.PAGE_AXIS));
  gameNumbers.setBorder(BorderFactory.createTitledBorder(" Numbers: "));
  gameAlign.add(gameNumbers);


  JPanel gameNumbers2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
  gameNumbers.add(gameNumbers2);

// a for loop checking for numbers less than 9 
  for (int i = 0; i < 9; i++) {
   numberBTN[i] = new JToggleButton("" + (i + 1));
   numberBTN[i].setPreferredSize(new Dimension(40, 40));
   numberBTN[i].setFocusable(false);
   groupNum.add(numberBTN[i]);
   gameNumbers2.add(numberBTN[i]);
  }
 }


}
