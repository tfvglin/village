package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;

import edu.xidian.village.action.UserAction;

public class JsonTest extends TestCase{

	
	public void testgetJson() throws JSONException
	{
		String jsonString = "{\"img\":\"dd\",\"user.name\":\"dd\",\"user.phone\":\"dd\",}";
		//:"dd"，"user.email":"dd"，"user.realName":"dd"，"user.nearName":"dd",}';
		JSONObject jsonObject = new JSONObject(jsonString);
		 Map result = new HashMap();
	        Iterator iterator = jsonObject.keys();
	        String key = null;
	        String value = null;
	        
	        while (iterator.hasNext()) {

	            key = (String) iterator.next();
	            value = jsonObject.getString(key);
	            System.out.println(key+"----"+value);
	            result.put(key, value);

	        }
	        

	}
	
	public void testSendJson()
	{
		UserAction u = new UserAction();
		//Demo_One/json
		 String s=sendPost("http://localhost:8880/Village/userModify", "{\"img\":\"null\",\"user.name\":\"yy\",\"user.phone\":\"里\",\"user.email\":\"22342322@qq.com\",\"user.realName\":\"881238\",\"user.nearName\":\"tdfstt\"}");
	        System.out.println(s);
	}
	
	 public static String sendPost(String url, String param) {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	            /*URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("content-type", "text/html");
	           
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            conn.connect();
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	           // conn.getInputStream();
*/       
	        	URL realUrl = new URL(url);
	        	 HttpURLConnection httpURLConnection = (HttpURLConnection) realUrl
	        	 .openConnection();
	        	 httpURLConnection.setDoOutput(true);
	        	 httpURLConnection.setDoInput(true);
	        	 httpURLConnection.setRequestMethod("POST"); httpURLConnection.setConnectTimeout(5000);
	        	 httpURLConnection.setReadTimeout(5000);
	        	 httpURLConnection.setRequestProperty("content-type", "text/html");
	        	 httpURLConnection.connect();
	        	 BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(
	        	 httpURLConnection.getOutputStream(), "UTF-8"));
	        	 out1.write("{\"img\":\"aa\",\"user.name\":\"yy\",\"user.phone\":\"里\",\"user.email\":\"22342322@qq.com\",\"user.realName\":\"881238\",\"user.nearName\":\"tdfstt\"}"); 
	        	 out1.flush();
	        	 httpURLConnection.getInputStream();
	        	
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return result;
	    }    
	}

