package alphaVantagePackage;


public class Data{

	private String symbol;
	private String open;
	private String high;
	private String low;
	private String price;
	private String volume;
	private String latest_trading_day;
	private String previous_close;
	private String change;
	private String change_percent;

	//used for Global Quote
	public Data(String symbol, String open, String high, String low, String price, String volume, String latest_trading_day, String previous_close, String change, String change_percent){
		this.symbol = symbol;
		this.open = open;
		this.high = high;
		this.low = low;
		this.price = price;
		this.volume = volume;
		this.latest_trading_day = latest_trading_day;
		this.previous_close = previous_close;
		this.change = change;
		this.change_percent = change_percent;
	}


	public String getSymbol(){
		return this.symbol;
	}

	public Double getOpen(){
		return Double.parseDouble(this.open);
	}

	public Double getHigh(){
		return Double.parseDouble(this.high);
	}

	public Double getLow(){
		return Double.parseDouble(this.low);
	}

	public Double getPrice(){
		return Double.parseDouble(this.price);
	}

	public Double getVolume(){
		return Double.parseDouble(this.volume);
	}

	public String getLatestTradingDay(){
		return this.latest_trading_day;
	}

	public Double getPreviousClose(){
		return Double.parseDouble(this.previous_close);
	}

	public String getChange(){
		return this.change;
	}

	public String getChangePercent(){
		return this.change_percent;
	}

}