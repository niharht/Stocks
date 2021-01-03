package alphaVantagePackage;


public class QuoteEndpoint{
	private final AlphaVantageAPIConnector connector;
	GlobalQuote gq = new GlobalQuote();

	public QuoteEndpoint(String apiKey){
		connector = new AlphaVantageAPIConnector(apiKey);
	}

	public Data global(String symbol){
		String json = connector.sendRequest(new Function("GLOBAL_QUOTE"), new Symbol(symbol));

		return gq.from(json);
	}
}