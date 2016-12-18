package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import adapters.DataAdapter;
import adapters.IAdapter;
import utils.SystemParameters;

public class GradeWindow extends AbstractWindow {

	private List<JTextArea>jTextAreas = new ArrayList<JTextArea>();
	
	public GradeWindow(String title) {
		super(title);
	}
	
	@Override
	public void initWindow() {
		int width = 600;
		int height = 600;
		super.setComputerWidth(width);
		super.setComputerHeight(height);
		int x = (int)(SystemParameters.COMPUTER_WIDTH-width)/2;
		int y = (int)(SystemParameters.COMPUTER_HEIGHT-height)/2;
		setBounds(x, y, width, height);
		
	}

	@Override
	public void addComponent() {
		Container container = getContentPane();
		JScrollPane scrollPane = new JScrollPane();
		//��ȡgrade��
		int num = SystemParameters.grades.size();
		//��һ�в���˵��
		JPanel jPanel = new JPanel(new GridLayout(num+1, 1));
		JLabel tipsLable = new JLabel("�γ̱�š��γ����ơ��ɼ���ѧ�֡��γ����͡���������");
		tipsLable.setBackground(Color.yellow);
		jPanel.add(tipsLable);
		for(int i=0; i<num; i++){
			JTextArea jTextArea = new JTextArea();
			jTextAreas.add(jTextArea);
			jPanel.add(jTextArea);
		}
		scrollPane.setViewportView(jPanel);
		container.add(scrollPane);
	}

	@Override
	public void loadData() {
		IAdapter adapter = new DataAdapter(jTextAreas, SystemParameters.grades);
		adapter.loadData();
	}

}
