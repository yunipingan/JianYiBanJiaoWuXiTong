package view;

public class WindowFactory implements IWindowFactory {

	public AbstractWindow createWindow(String windowType){
		AbstractWindow window = null;
		switch(windowType){
		case "loading":{
			window = new LoadingWindow("��¼");
			break;
		}
		case "menu":{
			window = new MenuWindow("����ѡ��");
			break;
		}
		case "course":{
			window = new CourseWindow("�α�");
			break;
		}
		case "grade":{
			window = new GradeWindow("�ɼ�");
			break;
		}
		}
		return window;
	}
	
}
