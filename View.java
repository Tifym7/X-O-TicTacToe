import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class View extends JFrame {
	JLabel textfield;
	JPanel title_panel;
	JPanel button_panel;
	JButton[] buttons;
	
	public View() {
		textfield = new JLabel();
		title_panel = new JPanel();
		button_panel = new JPanel();
		buttons = new JButton[9];
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font(Font.SERIF,Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,255,150));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font(Font.DIALOG,Font.BOLD,120));
			buttons[i].setFocusable(false);
		}
		
		title_panel.add(textfield);
		this.add(title_panel,BorderLayout.NORTH);
		this.add(button_panel);
		}
	public JLabel getTextfield() {
		return textfield;
	}
	public void setTextfield(String turn)
	{
		textfield.setText(turn);
	}
	public JPanel getTitle_panel() {
		return title_panel;
	}
	public JPanel getButton_panel() {
		return button_panel;
	}
	public JButton getButtons(int i) {
		return buttons[i];
	}
	public void addButtonListener(ActionListener buttonListener) {
		for(int i=0;i<9;i++)
			buttons[i].addActionListener(buttonListener);
	}
	public void xWins(int a,int b, int c) {
		buttons[a].setBackground(Color.red);
		buttons[b].setBackground(Color.red);
		buttons[c].setBackground(Color.red);
		
		for(int i=0;i<9;i++)
			buttons[i].setEnabled(false);
		textfield.setText("X wins");
	}
	
	public void oWins(int a,int b, int c) {
		buttons[a].setBackground(Color.blue);
		buttons[b].setBackground(Color.blue);
		buttons[c].setBackground(Color.blue);
		
		for(int i=0;i<9;i++)
			buttons[i].setEnabled(false);
		textfield.setText("O wins");
	}
	public void noWin() {
		for(int i=0;i<9;i++)
			buttons[i].setEnabled(false);
		textfield.setText("Nobody wins");
	}
	
}
