package edu.xidian.village.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletInputStream;

import org.springframework.stereotype.Component;

@Component("fetch")
public class Fetch {

	private List<String> titleList = new ArrayList<String>();
	private List<String> paraList = new ArrayList<String>();
	private List<String> contentList = new ArrayList<String>();
	
	final static String SOURC_URL =  "http://jwh.xidian.edu.cn/";
	
	
	
	private	Pattern titleP = Pattern.compile("class=\"tj\".+?href=\"(.+?)\"");
	private	Pattern paraP  = Pattern.compile("<P(\"[^\"]*\"|'[^']*'|[^'\">])*>(.+?)</P>");
	private	Pattern  isImgP = Pattern.compile("<IMG");
	private	Pattern  textP = Pattern.compile("<SPAN(\"[^\"]*\"|'[^']*'|[^'\">])*>(.+?)</SPAN>");
	private Pattern imgUrlP = Pattern.compile("src=\"(.+?)\"");
	
	
	
	String webHtml = WebContent.getWebCon(SOURC_URL);
	
	
	public List<String> getTitle()
	{
		Matcher titleM = titleP.matcher(webHtml);
		while(titleM.find())
			titleList.add(titleM.group(1));
		return titleList;
	}
	
	public List<String> getPara()
	{
		Matcher paraM ;
		Iterator<String> it = getTitle().iterator();
		while(it.hasNext())
		{
			String newsHtml = WebContent.getWebCon(SOURC_URL+it.next());
			paraM = paraP.matcher(newsHtml);
			while(paraM.find())
				paraList.add(paraM.group(2));
		}
		return paraList;
	}
		
	public List<String> getContent()
	{
		Matcher isImgM;
		Matcher textM;
		
		Iterator<String> it = getPara().iterator();
		while(it.hasNext())
		{
			String paraStr = it.next();
			isImgM = isImgP.matcher(paraStr);
			if(isImgM.find())
			{
				
			}
			else{
				textM = textP.matcher(paraStr);
				StringBuilder sb = new StringBuilder();
				while(textM.find())
				{
					sb.append(textM.group(2).trim().replaceAll("<.*?>", "").replaceAll("&nbsp;",""));
				}
				sb.append("/n");
				contentList.add(sb.toString());
			}
		}
		return contentList;
	}
	
	public InputStream imgStream(String imgPara)
	{
		InputStream in = null;
		Matcher imgUrlM;
		imgUrlM = imgUrlP.matcher(imgPara);
		if(imgUrlM.find())
		{
			in=imgStream(SOURC_URL+imgUrlM.group(1));
		}
		return in;
	}


	public static String fetchInputStream(ServletInputStream ss) throws Exception
	{
		
			BufferedReader br = new BufferedReader(new InputStreamReader(ss,"utf-8"));
			String s;
			StringBuilder sb = new StringBuilder();
			while((s=br.readLine())!=null)
			{
				sb.append(s);
			}
			return sb.toString();
			
		
	}
	
}
