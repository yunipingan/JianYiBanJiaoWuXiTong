package utils;

import java.awt.Toolkit;
import java.util.List;

import beans.Course;
import beans.Grade;
import beans.IMydata;

public class SystemParameters {
	public static double COMPUTER_WIDTH;
	public static double COMPUTER_HEIGHT;
	public static List<IMydata> courses;
	public static List<IMydata> grades;
	public static String userId;
	public static String userPsd;
	public static boolean isRemember;
	
	static{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		COMPUTER_HEIGHT = toolkit.getScreenSize().getHeight();
		COMPUTER_WIDTH = toolkit.getScreenSize().getWidth();
	}
}
