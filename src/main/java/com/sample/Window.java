package com.sample;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;


public class Window {
	public static JFrame frame;
	
	public static String updateFrame(String question, List<String> options){
		final JDialog[] dialog = new JDialog[1];
		JOptionPane optionPane = new JOptionPane();
		final String[] selectedValue = new String[1];
		optionPane.setMessage(question);
	    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(options.size(), 1));
	    String[] buttonsTxt = options.toArray(new String[options.size()]);
	    JButton[] buttons = new JButton[buttonsTxt.length];
	    for (int i = 0; i < buttonsTxt.length; i++)
	    {
	        buttons[i] = new JButton(buttonsTxt[i]);
	        panel.add(buttons[i]);
	        
	     // Add an ActionListener to the button
	        buttons[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Get the text of the button that was clicked
	            	selectedValue[0] = ((JButton)e.getSource()).getText();

	                // Print the selected value
	                System.out.println("Selected value: " + selectedValue[0]);
	                dialog[0].dispose();
	            }
	        });
	    }
	    optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
	    optionPane.remove(1);
	    optionPane.add(panel);
	    dialog[0] = optionPane.createDialog(null, "Answer this question:");
	    dialog[0].setVisible(true);
			    
	    return selectedValue[0];
	    
//	    int index = JOptionPane.showOptionDialog(null, questionValue, "Answer the question:",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, 
//                options.toArray(new String[options.size()]), options.get(0));
//		
//		return options.get(index);
	}
	
	public static void showMatch(String title){
		JOptionPane.showMessageDialog(frame, "Best horror movie for you:\n" + title);
	}
}
