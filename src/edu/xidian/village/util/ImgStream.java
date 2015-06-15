package edu.xidian.village.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImgStream {

	
	public static InputStream getImgStream(String imgUrl) throws Exception
	{
		URL url = new URL(imgUrl);  
	       
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
        
        conn.setRequestMethod("GET");  
       
        conn.setConnectTimeout(5 * 1000);  
        
        return conn.getInputStream();  
       
       /* byte[] data =readInputStream(inStream); 
       
        File imageFile = new File("D:/BG.jpg");  
        
        FileOutputStream outStream = new FileOutputStream(imageFile);  
       
        outStream.write(data);  
      
        outStream.close();  */
	}
	
	 public static byte[] readInputStream(InputStream inStream) throws Exception{  
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	        //����һ��Buffer�ַ���  
	        byte[] buffer = new byte[1024];  
	        //ÿ�ζ�ȡ���ַ������ȣ����Ϊ-1������ȫ����ȡ���  
	        int len = 0;  
	        //ʹ��һ����������buffer������ݶ�ȡ����  
	        while( (len=inStream.read(buffer)) != -1 ){  
	            //���������buffer��д�����ݣ��м����������ĸ�λ�ÿ�ʼ����len�����ȡ�ĳ���  
	            outStream.write(buffer, 0, len);  
	        }  
	        //�ر�������  
	        inStream.close();  
	        //��outStream�������д���ڴ�  
	        return outStream.toByteArray();  
	    }  
}
