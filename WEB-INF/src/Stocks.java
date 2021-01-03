import alphaVantagePackage.*;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Hashtable;

public class Stocks extends HttpServlet{

	private static Hashtable<String,Double> Listings;

	static{
		Listings = new Hashtable<String,Double>();
		Listings.put("VFIAX", 300.77);
	}

   String apiKey = "WQNITDZV6EI4VJRQ";
   QuoteEndpoint quote_endpoint = new QuoteEndpoint(apiKey);
   Data GlobalQuoteData;



	public void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException{
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			try{
				out.println("<!DOCTYPE html>");
      			out.println("<html><head>");
      			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
      			out.println("<title>Output Servlet</title></head>");
         		out.println("<body><h2>You have entered:</h2>");

         		String symbol_name = request.getParameter("symbol");
               GlobalQuoteData = quote_endpoint.global(symbol_name);

         		if(symbol_name == null || htmlFilter(symbol_name.trim()).length() == 0){
         			out.println("<p>Symbol: MISSING</p>");
         		} else {
                  out.println("<p>Symbol Name: " + GlobalQuoteData.getSymbol() + "</p>");
                  out.println("<p>Open: $" + GlobalQuoteData.getOpen() + "</p>");
                  out.println("<p>High: $" + GlobalQuoteData.getHigh() + "</p>");
                  out.println("<p>Low: $" + GlobalQuoteData.getLow() + "</p>");
                  out.println("<p>Price: $" + GlobalQuoteData.getPrice() + "</p>");
                  out.println("<p>Volume: " + GlobalQuoteData.getVolume() + "</p>");
                  out.println("<p>Latest Trading Day: " + GlobalQuoteData.getLatestTradingDay() + "</p>");
                  out.println("<p>Previous Close $: " + GlobalQuoteData.getPreviousClose() + "</p>");
                  out.println("<p>Change: $" + GlobalQuoteData.getChange() + "</p>");
                  out.println("<p>Change Percent: " + GlobalQuoteData.getChangePercent() + "</p>");
         		}




			}finally{
				out.close(); //always close
			}
	}

	private Double price(String symbol){
		return Listings.get(symbol);
	}


		// Filter the string for special HTML characters to prevent
   		// command injection attack
   	private static String htmlFilter(String message) {
      	if (message == null) return null;
      	int len = message.length();
      	StringBuffer result = new StringBuffer(len + 20);
      	char aChar;
 
      	for (int i = 0; i < len; ++i) {
         	aChar = message.charAt(i);
         	switch (aChar) {
            	 case '<': result.append("&lt;"); break;
            	 case '>': result.append("&gt;"); break;
             	case '&': result.append("&amp;"); break;
            	 case '"': result.append("&quot;"); break;
            	 default: result.append(aChar);
         	}
      	}
      	return (result.toString());
   	}
}