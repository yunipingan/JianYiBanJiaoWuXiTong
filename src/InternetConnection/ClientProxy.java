package InternetConnection;

import okhttp3.Response;

public class ClientProxy implements IClientProxy{
	
	IClientProxy client = RealClient.getInstance();

	@Override
	public Response excute(String type) {
		return client.excute(type);
	}

	@Override
	public void setTerm(String term) {
		client.setTerm(term);
	}
	
}
