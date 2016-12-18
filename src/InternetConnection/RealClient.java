package InternetConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.SystemParameters;

public class RealClient implements IClientProxy{
	
	public static OkHttpClient client = createClient();
	public static RealClient myClient;
	public static String htmlString;
	private String term;
	
	private RealClient(){}
	public synchronized static RealClient getInstance(){
		if(myClient == null){
			myClient = new RealClient();
		}
		return myClient;
	}
	
	public Request getRequest(String type){
		Request request = null;
		switch (type) {
		case "load":{
			FormBody builder = new FormBody.Builder()
			.add("PASSWORD", SystemParameters.userPsd)
			.add("USERNAME", SystemParameters.userId)
			.build();
			request = new Request.Builder().url("http://jwxt.gdufe.edu.cn/jsxsd/xk/LoginToXkLdap")
			.post(builder)
			.build();
			break;
		}
		case "course":{
			FormBody builder = new FormBody.Builder()
			.add("xnxq01id", term)
			.build();

	    	request = new Request.Builder().url("http://jwxt.gdufe.edu.cn/jsxsd/xskb/xskb_list.do")
			.post(builder)
			.build();
			break;
		}
			
		case "grade":{
			FormBody builder = new FormBody.Builder()
			.add("kksj", term)//开课时间
			.build();

			request = new Request.Builder().url("http://jwxt.gdufe.edu.cn/jsxsd/kscj/cjcx_list")
			.post(builder)
			.build();
			}
		}
		return request;
		
	}
	
	private static OkHttpClient createClient(){
		
		OkHttpClient.Builder builder = new OkHttpClient.Builder();  
		
		builder.cookieJar(new CookieJar() {  
		    private final HashMap<String, List<Cookie>> cookieStore = new HashMap<String, List<Cookie>>();  
		  
		    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {  
		        cookieStore.put(url.host(), cookies);  
		    }  
		  
		    public List<Cookie> loadForRequest(HttpUrl url) {  
		        List<Cookie> cookies = cookieStore.get(url.host());  
		        return cookies != null ? cookies : new ArrayList<Cookie>();  
		    }  
		});  
		return builder.build();
	}

	@Override
	public Response excute(String type) {
		// TODO Auto-generated method stub
		try {
			return  client.newCall(getRequest(type)).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}

	@Override
	public void setTerm(String term) {
		System.out.println(term+"学期");
		this.term = term;
	}

}
