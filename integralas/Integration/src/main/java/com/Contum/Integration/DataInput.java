package com.Contum.Integration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.Contum.Integration.models.sendEnvelope1s1cc;

public class DataInput {
	
	ApiHandler api;
	ArrayList<String> datas = new ArrayList<String>();
	
	public DataInput(ApiHandler api) throws Exception {
		this.api = api;
		getData();
	}
	
	public void send() throws Exception {
		sendEnvelope1s1cc.setParameters(datas.get(0), datas.get(1), datas.get(2), datas.get(3), datas.get(4), datas.get(5)
				, datas.get(6), datas.get(7));
		api.sendRequest("https://demo.xyzmo.com/api/v4.0/envelope/send",sendEnvelope1s1cc.getRequest());
	}
	
	public void getData() throws Exception {
		
		 
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\blukacs\\OneDrive - Contum Kft\\Szakdoga\\integralas\\Integration\\src\\main\\java\\com\\Contum\\Integration\\models\\data.txt"));
		
		String line;
		while((line = in.readLine()) != null)
		{
		    datas.add(line);
		}
		in.close();
		
	}
	

}
