package InternetConnection;

import okhttp3.Response;

public interface IClientProxy {

	Response excute(String type);
	void setTerm(String term);
	
}
