public class Model {
	private int[] buttons;
	private boolean turn;//true = randul lui x //fals randul lui O
	private int buttonsPressed;
	
	Model()
	{
		buttons = new int[9];
		for(int i=0;i<9;i++)
			buttons[i] = -1;// am marcat ca un patratel nebifat
	}

	public int getButtons(int i) {
		return buttons[i];
	}

	public void setButtons(int i,int x) {
		this.buttons[i] = x;
	}

	public boolean getTurn() {
		return turn;
	}

	public void nextTurn() {
		turn = !turn;
	}
	public void setTurn(boolean x) {
		turn = x;
	}
	public int getButtonsPressed() {
		return buttonsPressed;
	}

	public void incButtonPressed() {
		this.buttonsPressed++;
	}
	public boolean checkWin(int player,int x, int y, int z)
	{
		return buttons[x] == player  && buttons[y] == player && buttons[z] == player;
	}
	
}
