package edu.xidian.village.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebContent {

	public static String getWebCon(String domain) {
		
		StringBuffer sb = new StringBuffer();
	
		try {
			java.net.URL url = new java.net.URL(domain);
			BufferedReader in = new BufferedReader(new InputStreamReader(url
					.openStream(),"GBK"));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
		} catch (Exception e) { // Report any errors that arise
			e.printStackTrace();
		}
		finally{
			
		}
		return sb.toString();
	}
}
