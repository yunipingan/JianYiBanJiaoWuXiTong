package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Controller;
import utils.SystemParameters;
import utils.XMLUtilWindow;

public class MenuWindow extends AbstractWindow implements ActionListener {
	
	JComboBox<String> jComboBox;
	String term = "2014-2015-1";
	
	public MenuWindow(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initWindow() {
		int width = 400;
		int height = 400;
		super.setComputerWidth(400);
		super.setComputerHeight(400);
		int x = (int)(SystemParameters.COMPUTER_WIDTH-width)/2;
		int y = (int)(SystemParameters.COMPUTER_HEIGHT-height)/2;
		setBounds(x, y, width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void addComponent() {
		Container container = getContentPane();
		JPanel jPanel = new JPanel();
		
		JPanel jPanel1 = new JPanel(new GridLayout(3, 1));
		jComboBox = new JComboBox<String>();
		jComboBox.addItem("2014-2015-1");
		jComboBox.addItem("2014-2015-2");
		jComboBox.addItem("2015-2016-1");
		jComboBox.addItem("2015-2016-2");
		jComboBox.addItem("2016-2017-1");
		jComboBox.addItem("2016-2017-2");
		jComboBox.setActionCommand("termCB");
		jComboBox.addActionListener(this);
	
		
		JButton searchGradeBtn = new JButton("查课表");
		JButton searchCourseBtn = new JButton("查成绩");
		searchCourseBtn.addActionListener(this);
		searchGradeBtn.addActionListener(this);
		
		jPanel1.add(jComboBox);
		jPanel1.add(searchCourseBtn);
		jPanel1.add(searchGradeBtn);
		jPanel.add(jPanel1, BorderLayout.CENTER);
		container.add(jPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IWindowFactory windowFactory = (IWindowFactory) XMLUtilWindow.getBean();
		switch (e.getActionCommand()) {
		case "查课表":{
			AbstractWindow window = windowFactory.createWindow("course");
			window.setTitle(term+"课表");
			new Controller(window, term, "course").open();

			break;
		}

		case "查成绩":{
			AbstractWindow window = windowFactory.createWindow("grade");
			window.setTitle(term+"成绩");
			new Controller(window, term, "grade").open();
			break;
		}
		
		case "termCB":{
			term = jComboBox.getSelectedItem().toString();
			break;
		}
		
		}
		
		
	}

	@Override
	public void loadData() {
	}

}
