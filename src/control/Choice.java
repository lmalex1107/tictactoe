package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Choice extends JFrame implements ActionListener, ItemListener{
	
	String level="";
	ButtonGroup schwierigkeitsgrad;
	JRadioButton einfach;
	JRadioButton mittel;
	JRadioButton schwer;
	JButton jbutton;
	Controller controller;
	
	public Choice(Controller controller) {
		this.controller = controller;
	}
	
	
	
	
	public Choice() {
		JPanel jpanel = new JPanel();
		
		JLabel jlabel = new JLabel("Bitte treffen Sie eine Wahl!");
		einfach = new JRadioButton("einfach");
		mittel = new JRadioButton("mittel");
		schwer = new JRadioButton("schwer");
		
		einfach.addItemListener(controller);
		mittel.addItemListener(controller);
		schwer.addItemListener(controller);
		
		jbutton = new JButton("OK");
		jbutton.addActionListener(controller);
		
		
		
		schwierigkeitsgrad = new ButtonGroup();
		schwierigkeitsgrad.add(einfach);
		schwierigkeitsgrad.add(mittel);
		schwierigkeitsgrad.add(schwer);
		
		jpanel.add(jlabel);
		jpanel.add(einfach);
		jpanel.add(mittel);
		jpanel.add(schwer);
		jpanel.add(jbutton);
		
		this.add(jpanel);
		this.setSize(200, 150);
		this.setVisible(true);
		
	}
	
	public static void main(String args[]) {
		Choice choice = new Choice();
		choice.setVisible(true);
	}

	public String getLevel() {
		return this.level;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.jbutton) {
			controller.changeLevel(this.level);
		}
		
	}




	@Override
	public void itemStateChanged(ItemEvent arg0) {
		System.out.println("Change!");
		if (this.einfach.isSelected() == true) {
			this.level = "einfach";
			}
		else if (this.mittel.isSelected() == true) {
			this.level = "mittel";
		}
		else if (this.schwer.isSelected() == true) {
			this.level = "schwer";
		}
		System.out.println(this.level);
	}
	
}
