package ezparkproject;

import java.awt.Color;  
import java.awt.Font;  
import java.awt.event.FocusAdapter;  
import java.awt.event.FocusEvent;  
import javax.swing.JTextField;  

/* Reference: http://javaswingcomponents.blogspot.com/2012/05/how-to-create-simple-hinttextfield-in.html: */ 

/* Used by Ashutosh Yadav for the purposes of adding JTextfield hints for Date of Birth and other RegFrame component */
  
public class TextHint extends JTextField {  
  
  Font inFocusFont = new Font("Tahoma", Font.PLAIN, 12);  
  Font outFocusFont = new Font("Tahoma", Font.PLAIN, 12);  
  
  public TextHint(final String hint) {  
  
    setText(hint);  
    setFont(outFocusFont);  
    setForeground(Color.GRAY);  
  
    this.addFocusListener(new FocusAdapter() {  
  
      public void inFocus(FocusEvent e) {  
    	  
        if (getText().equals(hint)) {  
          setText("");  
          setFont(inFocusFont);  
        } else {  
          setText(getText());  
          setFont(inFocusFont);  
        }  
      }  
  
      public void outFocus(FocusEvent e) {  
    	  
        if (getText().equals(hint)|| getText().length()==0) {  
          setText(hint);  
          setFont(outFocusFont);  
          setForeground(Color.GRAY);  
        } else {  
          setText(getText());  
          setFont(inFocusFont);  
          setForeground(Color.BLACK);  
        }  
      }  
    });  
  
  }  
}  