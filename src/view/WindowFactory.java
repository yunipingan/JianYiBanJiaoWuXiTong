package view;

public class WindowFactory implements IWindowFactory {

	public AbstractWindow createWindow(String windowType){
		AbstractWindow window = null;
		switch(windowType){
		case "loading":{
			window = new LoadingWindow("登录");
			break;
		}
		case "menu":{
			window = new MenuWindow("功能选择");
			break;
		}
		case "course":{
			window = new CourseWindow("课表");
			break;
		}
		case "grade":{
			window = new GradeWindow("成绩");
			break;
		}
		}
		return window;
	}
	
}
