package alphaVantagePackage;

import java.util.List;
import java.util.Map;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;



public class GlobalQuote{

	private Data GQ_data;

	private static JsonParser PARSER;






	public Data from(String json){
		//send the parsed Data
		this.GQ_data = parseJSON(json);

		return this.GQ_data;
	}

	private Data parseJSON(String json){
		Gson gson = new Gson();
		JsonElement jsonelement = PARSER.parseString(json);
		JsonObject jsonobject = jsonelement.getAsJsonObject();
		//JsonArray array  = jsonelement.getAsJsonArray();

		JsonObject members = jsonobject.getAsJsonObject("Global Quote");

		//Debugging
		//System.out.println("Members: " + members);

		if(members.entrySet().isEmpty() == true){
			return new Data("Symbol does not exist", "0", "0", "0", "0", "0", "0", "0", "0", "0");
		}

		String symbol = members.get("01. symbol").getAsString();
		String open = members.get("02. open").getAsString();
		String high = members.get("03. high").getAsString();
		String low = members.get("04. low").getAsString();
		String price = members.get("05. price").getAsString();
		String volume = members.get("06. volume").getAsString();
		String latest_trading_day = members.get("07. latest trading day").getAsString();
		String previous_close = members.get("08. previous close").getAsString();
		String change = members.get("09. change").getAsString();
		String change_percent = members.get("10. change percent").getAsString();

		return new Data(symbol, open, high, low, price, volume, latest_trading_day, previous_close, change, change_percent);
		
	}
	
}