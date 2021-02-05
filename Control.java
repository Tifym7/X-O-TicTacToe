import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class Control {
	private Model model;
	private View view;
	private Random random  = new Random();
	
	public Control(Model model,View view) {
		this.model = model;
		this.view = view;
		view.addButtonListener(new ButtonListener());
		firstTurn();
		
	}
	public void firstTurn( ) {//se alege random daca incepe X sau O
		if(random.nextInt(2) == 0) {
			model.setTurn(true);
			view.setTextfield("X turn");
		}else
		{
			model.setTurn(false);
			view.setTextfield("O turn");
		}
	}
	public void endGame() {//combinatiile pe verticala,orizontala si diagonale
		if(model.checkWin(1, 0, 1, 2))
			{
				view.xWins(0, 1, 2);
				return;
			}
		if(model.checkWin(1,3,4,5))
			{
				view.xWins(3, 4, 5);
				return;
			}
		if(model.checkWin(1, 6, 7, 8))
			{
				view.xWins(6, 7, 8);
				return;
			}
		if(model.checkWin(1,0,3,6))
			{
				view.xWins(0, 3, 6);
				return;
			}
		if(model.checkWin(0, 1, 4, 7))
			{
				view.xWins(1, 4, 7);
				return;
			}
		if(model.checkWin(1, 2, 5, 8))
			{
				view.xWins(2, 5, 8);
				return;
			}
		if(model.checkWin(1, 0, 4, 8))
			{
				view.xWins(0, 4, 8);
				return;
			}
		if(model.checkWin(1, 2, 4, 6))
		{
			view.xWins(2, 4, 6);
			return;
		}
		if(model.checkWin(0, 0, 1, 2))
			{
				view.oWins(0, 1, 2);
				return;
			}
		if(model.checkWin(0,3,4,5))
			{
				view.oWins(3, 4, 5);
				return;
			}
		if(model.checkWin(0, 6, 7, 8))
			{
				view.oWins(6, 7, 8);
				return;
			}
		if(model.checkWin(0,0,3,6))
			{
				view.oWins(0, 3, 6);
				return;
			}
		if(model.checkWin(0, 1, 4, 7))
			{
				view.oWins(1, 4, 7);
				return;
			}
		if(model.checkWin(0, 2, 5, 8))
			{
				view.oWins(2, 5, 8);
				return;
			}
		if(model.checkWin(0, 0, 4, 8))
			{
				view.oWins(0, 4, 8);
				return;
			}
		if(model.checkWin(0, 2, 4, 6))
		{
			view.oWins(2, 4, 6);
			return;
		}
		if(model.getButtonsPressed() == 9)
			view.noWin();
	}
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton buttonPressed = (JButton) e.getSource();
			int poz = -1;
			for(int i=0;i<9;i++)
				if(view.getButtons(i) == buttonPressed)
					poz = i;
			if(buttonPressed.getText()=="")
			{
				if(model.getTurn())//a ales X
				{
					buttonPressed.setForeground(new Color(255,0,0));
					buttonPressed.setText("X");
					model.setButtons(poz, 1);
					model.nextTurn();
					view.setTextfield("O turn");
					model.incButtonPressed();
					
					
				}else // a ales O
				{
					buttonPressed.setForeground(new Color(0,0,255));
					buttonPressed.setText("O");
					model.setButtons(poz, 0);
					model.nextTurn();
					view.setTextfield("X turn");
					model.incButtonPressed();
				}
				endGame();//verifica daca mutarea a condus la castig
			}
			
		}
		
	}
}