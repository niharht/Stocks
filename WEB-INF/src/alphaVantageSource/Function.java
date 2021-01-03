package alphaVantagePackage;


public class Function implements Parameter{
	private String parameter;

	public Function(String parameter){
		this.parameter = parameter;
	}

	public String getKey(){
		return "function";
	}

	public String getValue(){
		return parameter;
	}
}