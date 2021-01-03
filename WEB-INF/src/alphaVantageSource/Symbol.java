package alphaVantagePackage;


public class Symbol implements Parameter{
	private String parameter;

	public Symbol(String parameter){
		this.parameter = parameter;
	}

	public String getKey(){
		return "symbol";
	}

	public String getValue(){
		return parameter.toUpperCase();
	}

}