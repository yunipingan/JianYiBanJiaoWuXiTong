package main;

import utils.XMLUtilWindow;
import view.AbstractWindow;
import view.IWindowFactory;

public class Client {

	public static void main(String[] args) {
	
		IWindowFactory windowFactory = (IWindowFactory) XMLUtilWindow.getBean();
		AbstractWindow window = windowFactory.createWindow("loading");
		window.initWindow();
		window.addComponent();
		window.showWindow();
		
	}

}
