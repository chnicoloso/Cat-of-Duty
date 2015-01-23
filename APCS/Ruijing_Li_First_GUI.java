import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Ruijing_Li_First_GUI
{
  public static void main(String[] args)
  {
    JFrame window = new JFrame("My First GUI");
    

    window.setDefaultCloseOperation(3);
    

    window.setBounds(200, 200, 500, 500);
    

    window.setResizable(true);
    

    JLabel label = new JLabel("A Wild Pikachu Appeared!");
    label.setHorizontalAlignment(0);
    
    JButton button = new JButton("Don't push this red button");
    button.setBackground(Color.red);
    
    JToggleButton tbuton = new JToggleButton("HELLLLO", false);
    
    JRadioButton radio = new JRadioButton("MAGIC!!!", false);
    
    JSlider seesaw = new JSlider();
    
    JTextField tfield = new JTextField("Strange words have mysteriously appeared");
    
    JTextArea tarea = new JTextArea("WRITE LIKE THE WIND", 5, 3);
    

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 2));
    
    JPanel panel2 = new JPanel();
    
    JPanel panel3 = new JPanel();
    

    panel.add(label);
    panel.add(button);
    panel.add(tbuton);
    panel.add(radio);
    panel2.add(seesaw);
    panel3.add(tfield);
    panel3.add(tarea);
    


    window.getContentPane().add(panel, "Center");
    window.getContentPane().add(panel2, "First");
    window.getContentPane().add(panel3, "Last");
    

    window.setVisible(true);
  }
}