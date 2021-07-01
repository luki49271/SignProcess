package com.Contum.Integration;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscribers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ApiHandler {

	public String filePath;
	public String authorizationHeader;
	String boundary = Long.toHexString(System.currentTimeMillis());
	
	static HttpClient httpClientForREST;
	static HttpRequest httpRequestForREST;
	static String gsOrgKey = "";
	static String gsUserName;
	static String apiToken = "hgqlinj17tvr3iolbern9f1f0b70fuvmjt2rpsbl6eozk3njcl3h9kkx83qkqhdo"; 

	public ApiHandler(String filePath) {
		this.filePath = filePath;
	}

	public String sendUploadTemporary() throws IOException, InterruptedException, Exception, TimeoutException {
		String sResponse = "";
		httpClientForREST = HttpClient.newBuilder().version(Version.HTTP_1_1).followRedirects(Redirect.NORMAL)
				.connectTimeout(Duration.ofSeconds(20)).build();

		java.io.File fBody = new java.io.File(filePath);
		httpRequestForREST = HttpRequest.newBuilder()
				//Oriana miatt átírva a link!!  oriana: https://demo.esignanywhere.net/Api/v4/sspfile/uploadtemporary  elozo: https://demo.xyzmo.com/api/v4.0/sspfile/uploadtemporary
				.uri(URI.create("https://demo.esignanywhere.net/Api/v4/sspfile/uploadtemporary"))
				.timeout(Duration.ofMinutes(2))
				.header("Content-Disposition", "Attachment;filename=Contract_Sample.pdf")
				.header("apiToken", apiToken)
				.POST(BodyPublishers.ofFile(fBody.toPath())).build();


		CompletableFuture<String> f = httpClientForREST.sendAsync(httpRequestForREST, BodyHandlers.ofString())
				.thenApply(HttpResponse::body);

		sResponse = f.get(30, TimeUnit.SECONDS);
		System.out.println("Response from UploadTemporary:");
		System.out.println(sResponse + "\r\n");
		String ret[] = sResponse.split(":");
		return ret[1].substring(1,ret[1].length()-2);
		
	}

	public void sendRequest(String url,String body) throws Exception {
		String sResponse = "";
//		System.out.println(body);
		httpClientForREST = HttpClient.newBuilder().version(Version.HTTP_1_1).followRedirects(Redirect.NORMAL)
				.connectTimeout(Duration.ofSeconds(20)).build();
		
		httpRequestForREST = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.timeout(Duration.ofMinutes(2))
				.header("Content-Type", "application/json")
				.header("accept", "application/json")
				.header("apiToken", apiToken)
				.POST(BodyPublishers.ofString(body))
				.build();
		
		CompletableFuture<String> f = httpClientForREST.sendAsync(httpRequestForREST, BodyHandlers.ofString())
				.thenApply(HttpResponse::body);
		
		// error handling:
		BodyHandler<Path> bodyHandler = (rspInfo) -> rspInfo.statusCode() == 200 ?
				  BodySubscribers.ofFile(Paths.get("/tmp/f")) :
				  BodySubscribers.replacing(Paths.get("/NULL")); 
				  
	
		sResponse = f.get(30, TimeUnit.SECONDS);
		String sRespToPrint = sResponse.replaceAll(",", ",\r\n");
		System.out.println(sRespToPrint);
		if(sRespToPrint.contains("EnvelopeId")) {
			isReady(sRespToPrint);
		}
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("SUCCES");
		System.out.println("----------------------------------------------------------------");
		
	}
	
	public void isReady(String id) throws Exception, Exception {
		String envId = id.substring(15);
		envId = envId.substring(0,36);
		System.out.println(envId);
		String response = "alma";
		while(!response.contains("Completed")) {
			response = sendGetEnvelope(envId);
			System.out.println("****************************");
			Thread.sleep(10000); // 10sec delay
		}
		System.out.println("Document sign is finished");
		ArrayList<String> keys = new ArrayList<String>();
		keys.add("ComboBox_USB64GB");
		keys.add("ComboBox_USB128GB");
		keys.add("ComboBox_SSD512GB");
		keys.add("ComboBox_SSD1TB");
		keys.add("ComboBox_HDD512GB");
		keys.add("ComboBox_HDD1TB");
		keys.add("TextBox_CustomerName");
		keys.add("TextBox_CustomerAddress");
		keys.add("TextBox_CustomerMobile");
		keys.add("TextBox_CustomerEmail");
		
		for( String key : keys) {
			jsonHelper(response, key);
		}


		
	}
	
	public void jsonHelper(String json, String key) {
		ArrayList<String> lines = new ArrayList<String>();
    	
    	for (String word : json.split(",")) {
    		lines.add(word);
		}
    	String value ="";
        
    	for (int i = 0; i<lines.size(); i++) {
    		if(lines.get(i).contains(key)) {
    			value = lines.get(i+2);
    			if(value.length()>2) {
    				value = value.substring(value.indexOf(":")+2,value.indexOf("}")-1);
    	    		System.out.println(key.substring(key.indexOf("_")+1) +" : " +value);
    				break;
    			}
    			else
    			value = value.substring(value.indexOf(":")+2,value.indexOf(":")+3 );
        		System.out.println(key.substring(key.indexOf("_")) +" : " +value);
    			
    		break;

    		}
    		
    	}
    	
	}
	
	public String sendGetEnvelope(String id) throws Exception, InterruptedException {
		
		httpClientForREST = HttpClient.newBuilder().version(Version.HTTP_1_1).followRedirects(Redirect.NORMAL)
				.connectTimeout(Duration.ofSeconds(20)).build();

		httpRequestForREST = HttpRequest.newBuilder()
				.uri(URI.create("https://demo.esignanywhere.net/Api/v5/envelope/"+id))
				.timeout(Duration.ofMinutes(2))
				.header("organizationKey", gsOrgKey)
				.header("apiToken", apiToken)
				.GET().build();
		
		HttpResponse<String> response = httpClientForREST.send(httpRequestForREST, BodyHandlers.ofString());

//		System.out.println("EnvelopeID: \r\n");
//		System.out.println(response.body());

		return response.body();
	}


}
