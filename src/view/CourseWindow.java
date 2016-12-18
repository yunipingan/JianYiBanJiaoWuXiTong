package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import adapters.DataAdapter;
import adapters.IAdapter;
import beans.IMydata;
import InternetConnection.ClientProxy;
import parseHtml.ParseCourse;
import utils.SystemParameters;

public class CourseWindow extends AbstractWindow {

	private List<JTextArea>jTextAreas = new ArrayList<JTextArea>();
	
	public CourseWindow(String title) {
		super(title);
	}
	
	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		int width = 600;
		int height = 600;
		super.setComputerWidth(width);
		super.setComputerHeight(height);
		int x = (int)(SystemParameters.COMPUTER_WIDTH-width)/2;
		int y = (int)(SystemParameters.COMPUTER_HEIGHT-height)/2;

		setBounds(x, y, width, height);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//new ClientProxy().getData();
	}

	@Override
	public void addComponent() {
		Container container = getContentPane();
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();
		
		jPanel1.setBackground(Color.ORANGE);
		jPanel2.setBackground(Color.GREEN);
		
		jPanel1.setLayout(new GridLayout(1, 8));
		jPanel2.setLayout(new GridLayout(12, 1));
		jPanel3.setLayout(new GridLayout(6, 7));
		
		jPanel1.add(new JLabel());
		for(int i=1; i<=7; i++){
			jPanel1.add(new JLabel("ÐÇÆÚ"+i));
		}
		
		//jPanel2.add(new JLabel());
		for(int i=1; i<=12; i++){	
			jPanel2.add(new JLabel("µÚ"+i+"½Ú"));
		}
		for(int i=1; i<=6; i++){
			for(int j=1; j<=7; j++){
				JTextArea jTextArea = new JTextArea();
				jTextArea.setLineWrap(true);
				jTextAreas.add(jTextArea);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(jTextArea);
				jPanel3.add(scrollPane);
			}
		}
		
		container.add(jPanel1, BorderLayout.NORTH);
		container.add(jPanel2, BorderLayout.WEST);
		container.add(jPanel3, BorderLayout.CENTER);
	}

	@Override
	public void loadData() {
		IAdapter adapter = new DataAdapter(jTextAreas, SystemParameters.courses);
		adapter.loadData();
	}
	
	

}
