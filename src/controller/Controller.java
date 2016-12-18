package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import beans.Course;
import okhttp3.Response;
import parseHtml.IParseHtml;
import parseHtml.ParseCourse;
import parseHtml.ParseHtmlFactory;
import rx.Observable;
import rx.Subscriber;
import InternetConnection.ClientProxy;
import view.AbstractWindow;

public class Controller implements IController{

	private ClientProxy clientProxy = new ClientProxy();
	private AbstractWindow window;
	private String choice;
	
	public Controller(AbstractWindow window, String choice) {
		super();
		this.window = window;
		this.choice = choice;
	}
	
	public Controller(AbstractWindow window, String term, String choice) {
		this(window, choice);
		clientProxy.setTerm(term);
		
	}

	@Override
	public void open() {
		//���ж���
		myObservable.subscribe(mySubscriber);
	}

	//���۲���
    Observable<Response> myObservable = Observable.create(  
            new Observable.OnSubscribe<Response>() {  

				@Override
				public void call(Subscriber<? super Response> arg0) {
					//����ͬ����������첽����
					arg0.onNext(clientProxy.excute(choice));
					arg0.onCompleted();
				}  
            }  
        );
	
    //�۲���
    Subscriber<Response> mySubscriber = new Subscriber<Response>() {  
    	
    	List<Course> courses = new ArrayList<>();
    	
    	//�첽����������Ϻ���лص�
        @Override  
        public void onNext(Response arg0) { 
        	try {
        		IParseHtml parseHtml = ParseHtmlFactory.getIParseHtml(choice);
        		if(parseHtml!=null)
            	parseHtml.parse(readHtml(arg0));
        		arg0.close();
			} catch (Exception e) {
				System.out.println("����ʧ��"+e.toString());
			}
        	
        }  
        
        @Override  
        public void onCompleted() {System.out.println("onCompleted");
        	window.initWindow();
    		window.addComponent();
    		window.showWindow();
    		window.loadData();
        }  
      
        @Override  
        public void onError(Throwable e) { 
        	System.out.println("��ѯʧ��"+e.toString());
        	//onCompleted();
        }  
    };  
    
    String readHtml(Response response){
		StringBuffer sBuffer = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
					new InputStreamReader(response.body().byteStream(), "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sBuffer.append(line);
				//System.out.println(line);
			}
			
		} 
		catch (IOException e) {
			
		}
		return sBuffer.toString();
    }

}
