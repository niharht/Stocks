//Use for debugging when not running Tomcat

package alphaVantagePackage;


import java.util.Scanner;

public class App{
	public static void main(String[] args){
		String apiKey = ""; //use ApiKey from AlphaVantage here

        
    	Scanner scanner = new Scanner(System.in);

    	QuoteEndpoint quote_endpoint = new QuoteEndpoint(apiKey);
    	
    	System.out.println("Welcome to the Stocks App");
    	System.out.println("Please enter the symbol you would like to see");

    	String symbol = scanner.next();

    	Data globalquotedata = quote_endpoint.global(symbol);

    	System.out.println("Symbol: " + globalquotedata.getSymbol() + " has a price of $" + globalquotedata.getPrice());





	}
}