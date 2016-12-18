package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;
import utils.SystemParameters;
import utils.XMLUtilWindow;

public class LoadingWindow extends AbstractWindow implements ActionListener{

	private JTextField userIdText;
	private JPasswordField userPsdJTextArea;
	
	public LoadingWindow(String title) {
		super(title);
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
		super.setjPanel(new JPanel());
		JLabel jLabel = new JLabel();
		
		jLabel.setIcon(new ImageIcon("src\\loading.png"));
		jLabel.setBounds(0, 0, getComputerWidth(), getComputerHeight()/2);

		container.add(jLabel, BorderLayout.NORTH);
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(3,1));
		
		JPanel jPanel1_1 = new JPanel();
		userIdText = new JTextField(11);
		userIdText.setInputVerifier(new InputVerifier() {
			
			@Override
			public boolean verify(JComponent input) {
				Pattern pattern = Pattern.compile("[0-9]{1,11}");
			    Matcher matcher = pattern.matcher((CharSequence) (((JTextField)input).getText()));  
			    return matcher.matches();
			}
		});
		
		jPanel1_1.add(new JLabel("Ñ§ºÅ"), BorderLayout.WEST);
		jPanel1_1.add(userIdText, BorderLayout.CENTER);
		
		JPanel jPanel1_2 = new JPanel();
		userPsdJTextArea = new JPasswordField(11);
		jPanel1_2.add(new JLabel("ÃÜÂë"), BorderLayout.WEST);
		jPanel1_2.add(userPsdJTextArea, BorderLayout.CENTER);
		
		JPanel jPanel1_3 = new JPanel();
		JButton button = new JButton("µÇÂ¼");
		button.addActionListener(this);
		jPanel1_3.add(button, BorderLayout.CENTER);
		
		jPanel1.add(jPanel1_1);
		jPanel1.add(jPanel1_2);
		jPanel1.add(jPanel1_3);
		
		jPanel1.setSize(20, 20);
		container.add(jPanel1, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			String userId = userIdText.getText().trim();
			String userPsd = userPsdJTextArea.getText().trim();
			if(userId.equals("")||userId==null||userPsd.equals("")||userPsd==null){
				return;
			}
			SystemParameters.userId = userId;
			SystemParameters.userPsd = userPsd; 
			//System.out.println(SystemParameters.userId+" "+ SystemParameters.userPsd);
			IWindowFactory windowFactory = (IWindowFactory) XMLUtilWindow.getBean();
			AbstractWindow window = windowFactory.createWindow("menu");
			new Controller(window,"load").open();
			closeWindow();
		
	}

	@Override
	public void loadData() {
		
	}	
	
}

