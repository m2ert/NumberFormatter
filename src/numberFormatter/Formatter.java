package numberFormatter;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Formatter extends JPanel implements ActionListener {
	
		private static final long serialVersionUID = 1L;
		
		private JButton formatBtn;
	    private JButton resetBtn;
	    private JLabel numberLabel,resultLabel;
	    private JTextField numberText;
	    
	    public Formatter() {
	    
	    	formatBtn = new JButton ("Format");
	    	resetBtn = new JButton ("Reset Form");
	        numberLabel = new JLabel ("Please enter your number :");
	        numberText = new JTextField ();
	        resultLabel = new JLabel ("");
	        
	        setPreferredSize (new Dimension (335, 285));
	        setLayout (null);

	        add (formatBtn);
	        add (resetBtn);
	        add (numberLabel);
	        add (numberText);
	        add (resultLabel);
	        
	        formatBtn.setBounds (5, 190, 100, 20);
	        resetBtn.setBounds (230, 190, 100, 20);
	        numberLabel.setBounds (10, 20, 170, 25);
	        numberText.setBounds (10, 50, 315, 25);
	        resultLabel.setBounds (10, 90, 315, 25);
	        
	        numberText.addKeyListener(new KeyAdapter() {
	        	public void keyReleased(java.awt.event.KeyEvent evt) {
	                try {
	                    long number = Long.parseLong(numberText.getText());
	                } catch (Exception e) {
	                	resultLabel.setText("* Enter only numeric digits [0-9] and max 19");
	                	numberText.setText("");
	                }
	            }
	     
	         });
	        
	        formatBtn.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){ 
	            	resultLabel.setText("Result is: " + addCommasToNumber(numberText.getText(),","));
	        }  
	      });
	        
	      resetBtn.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	               numberText.setText("");  
	               resultLabel.setText("");  
	        }  
	      });
	    }
	    
	    
	    public static void main (String[] args) {
	        JFrame frame = new JFrame ("Number Formatter");
	        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	        frame.getContentPane().add(new Formatter());
	        frame.pack();
	        frame.setVisible (true);
	    }


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		/* Main function */
		public static String addCommasToNumber(String number,String seperatorObject) {
			
			
			int numberLength= number.length(); /* get a length value of string */
			int totalSeperator = (int) Math.floor((numberLength-1)/3); /* total seperator object (',' , '.' etc) */
			
			String formattedString = number.substring(0,numberLength-(totalSeperator*3)); /* Get a first val left side */

			while (totalSeperator > 0)    {
			formattedString = 
					formattedString + 
					seperatorObject + 
					number.substring(numberLength-(totalSeperator*3),numberLength-((totalSeperator-1)*3)); 
			
			totalSeperator = totalSeperator - 1;   
			
			}
		
			return formattedString;
		}
	    
	    
	    
	    

	
}
