package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractWindow extends JFrame {
	
	private int computerWidth;
	private int computerHeight;
	public JPanel jPanel;
	
	public AbstractWindow(String title){
		super(title);
	}
	
	public int getComputerWidth() {
		return computerWidth;
	}

	public void setComputerWidth(int computerWidth) {
		this.computerWidth = computerWidth;
	}

	public int getComputerHeight() {
		return computerHeight;
	}

	public void setComputerHeight(int computerHeight) {
		this.computerHeight = computerHeight;
	}

	public JPanel getjPanel() {
		return jPanel;
	}

	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}
	
	public void showWindow(){
		this.setVisible(true);
	}
	
	public void closeWindow(){
		this.dispose();
	}
	
	@Override
	public void setTitle(String title) {
		super.setTitle(title);
	}
	
	public abstract void initWindow();
	public abstract void addComponent();
	public abstract void loadData();
	
}
