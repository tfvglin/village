package edu.xidian.village.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 InputStream in = request.getInputStream();  
		 if(in != null) {  
		        System.out.println("流不是空的。");  
		   
		    } else {  
		        System.out.println("流是空的。");  
		    }  
		 BufferedReader br;
		 br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			
			String line = null;  
			StringBuilder sb = new StringBuilder();  
			while ((line = br.readLine()) != null) {  
			    sb.append(line);  
			}
			// jsonStr = sb.toString();
			 System.out.println(sb.toString());
		//super.service(arg0, arg1);
	}
	
	

}
