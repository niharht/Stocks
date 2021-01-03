package alphaVantagePackage;


import java.net.URI;
import java.net.http.*;
import java.io.IOException;
import java.lang.InterruptedException;
import java.net.MalformedURLException;
import java.lang.IllegalArgumentException;



public class AlphaVantageAPIConnector{
	private static final String BASE_URL = "https://www.alphavantage.co/query?";
	private final String apiKey;

	private String data = "";

	public AlphaVantageAPIConnector(String apiKey){
		this.apiKey = apiKey;
	}

	public String sendRequest(Parameter... parameters){
		HttpRequest request;

		String params = getParameters(parameters);
		String url = BASE_URL + params;

		try{
			request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.build();

			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			this.data = response.body();
		}catch(IOException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			e.printStackTrace();
		}

		return this.data;
	}


	private String getParameters(Parameter... parameters){
		StringBuilder url = new StringBuilder();
		String key_value;
		if(parameters != null){
			for(Parameter parameter : parameters){
				if(parameter != null){
					key_value = "&" + parameter.getKey() + "=" + parameter.getValue();
					url.append(key_value);
				}
			}
			key_value = "&" + "apikey" + "=" + this.apiKey;
			url.append(key_value);

		}else {
			throw new IllegalArgumentException();
		}

		return url.toString();
	}


}

