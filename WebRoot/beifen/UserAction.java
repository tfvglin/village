package edu.xidian.village.action;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;

import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import edu.xidian.village.service.UserService;
import edu.xidian.village.util.Fetch;
import edu.xidian.village.vo.User;

@Controller("userAction")
@Scope("prototype") 
public class UserAction<T> extends SuperAction {
	private static  BASE64Encoder encoder = new sun.misc.BASE64Encoder();      
    private  BASE64Decoder decoder = new sun.misc.BASE64Decoder();  
	private User user;
	private UserService userServiceImpl;
	private Fetch fetch;
	
	private Map<String,Object> umap = new HashMap<String, Object>();

	private String imageCode;
	private String sign ;
	
	
	
	 private InputStream inputStream;

	 
	 
	public Fetch getFetch() {
		return fetch;
	}
	@Resource
	public void setFetch(Fetch fetch) {
		this.fetch = fetch;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public InputStream getInputStream() {
	        return inputStream;
	    }
	   
	 public void setInputStream(InputStream inputStream) {
	        this.inputStream = inputStream;
	    }


	public String getSign() {
		return sign;
	}


	public void setSign(String sign) {
		this.sign = sign;
	}


	public Map<String, Object> getUmap() {
		return umap;
	}


	public void setUmap(Map<String, Object> umap) {
		this.umap = umap;
	}


	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	
	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	@Resource
	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	
	public String userInfo()
	{
		
		user=userServiceImpl.getUser(user.getName());
		umap.put("userinfo", user);
		
		return SUCCESS;
	}


	public String userModify()
	{
		
		BufferedReader br;
		String imgCode;
		Map result = new HashMap();
		User u = new User();
		try {
			JSONObject jsonObject ;
			String jsonStr = Fetch.fetchInputStream(request.getInputStream());
			jsonObject = new JSONObject(jsonStr);
			
			imgCode = jsonObject.getString("img");
			u.setEmail(jsonObject.getString("user.email"));
			
			u.setName(jsonObject.getString("user.name"));
			u.setNearName(jsonObject.getString("user.nearName"));
			u.setRealName(jsonObject.getString("user.realName"));
			u.setPhone(jsonObject.getString("user.phone"));
			
			user =userServiceImpl.getUser(u.getName());
			u.setId(user.getId());
			u.setPassword(user.getPassword());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			sign="error";
		}
		/*try {
		
			
			br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
		
			String line = null;  
			StringBuilder sb = new StringBuilder();  
			while ((line = br.readLine()) != null) {  
			    sb.append(line);  
			}
			 jsonStr = sb.toString();
			 System.out.println(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			sign="data error";
			inputStream =  new   ByteArrayInputStream(sign.getBytes());
			return SUCCESS;
		}  */
       if(jsonStr==null||jsonStr.trim()=="")
       {
    	   sign="not receive data";
    	   
       }
       else{
    	   
	    	JSONObject jsonObject ;
			try {
				jsonObject = new JSONObject(jsonStr);
				
				imgCode = jsonObject.getString("img");
				u.setEmail(jsonObject.getString("user.email"));
				
				u.setName(jsonObject.getString("user.name"));
				u.setNearName(jsonObject.getString("user.nearName"));
				u.setRealName(jsonObject.getString("user.realName"));
				u.setPhone(jsonObject.getString("user.phone"));

				
			} catch (Exception e) {
				e.printStackTrace();
				sign="json error";
				inputStream =  new   ByteArrayInputStream(sign.getBytes());
				return SUCCESS;
			}
	
			
			try{
				user =userServiceImpl.getUser(u.getName());
				u.setId(user.getId());
				u.setPassword(user.getPassword());
				
			}
			catch(Exception ex)
			{
				sign="user unexception";
				inputStream =  new   ByteArrayInputStream(sign.getBytes());
				return SUCCESS;
			}
			
			
			
			if(imgCode!=null&&!imgCode.equals("null"))
			{
				
				
				sign=(base64StringToImage(imgCode,u.getName())&&userServiceImpl.saveUserInfo(u))?"ok":"error";
			
			}
			else
				sign=(userServiceImpl.saveUserInfo(u))?"ok":"error";
		
       }
    
       System.out.println(sign);
       inputStream =  new   ByteArrayInputStream(sign.getBytes());
		return SUCCESS;
	}

	
	public String userRegist()
	{
	
		if(user==null)
		{
			sign="格式错误";
			inputStream =  new   ByteArrayInputStream(sign.getBytes());
			return SUCCESS;
		}
		if(userServiceImpl.find(user)!=null)
			sign="exist";
		else{
			//String userImg = request.getParameter("userImg");
			
			if(userServiceImpl.addUser(user))
				sign="ok";
			else
				sign="error";
		}
		inputStream =  new   ByteArrayInputStream(sign.getBytes());
		return SUCCESS;
	}
	public String userCheckLogin()
	{
		String token = request.getParameter("token");
		if(userServiceImpl.checkToken(user.getName(), token))
			sign="ok";
		else
			sign="error";
		inputStream =  new   ByteArrayInputStream(sign.getBytes());
		return SUCCESS;
	}
	public String userLogin()
	{
		if(userServiceImpl.find(user)==null)
			umap.put("sign","notexist");
		else if(userServiceImpl.checkPassword(user))
		{
			User u = userServiceImpl.getUser(user.getName());
			//request.getSession().setAttribute("user", userServiceImpl.getUser(user.getName()));
			umap.put("sign","ok");
			umap.put("token", u.getId());
			umap.put("userinfo", u);
		}
		else
			umap.put("sign","error");
			
		//inputStream = new StringBufferInputStream(sign);
		return SUCCESS;
	}

	public String userLogout()
	{
		request.getSession().removeAttribute("user");
		sign="ok";
		inputStream =  new   ByteArrayInputStream(sign.getBytes());
		return SUCCESS;
	}
	
	public String userUploadImg()
	{
		String img = request.getParameter("img");
		System.out.println(base64StringToImage(img, "lsn"));
		sign="ok";
		inputStream =  new   ByteArrayInputStream(sign.getBytes());
		return SUCCESS;
	}
	
	 private boolean base64StringToImage(String base64String,String name){   
		 
		 String realPath = application.getRealPath("/");
		 
	        try {      
	            byte[] bytes1 = decoder.decodeBuffer(base64String);      
	                
	            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);      
	            BufferedImage bi1 =ImageIO.read(bais);   
	            
	            File w2 = new File(realPath+"uploads/userhead/"+name+".jpg");  
	            
	            return  ImageIO.write(bi1, "jpg", w2); 
	              
	           
	        } catch(IOException | IllegalArgumentException ie) {      
	        	
	            return false;
	        }      
	    }      
	 
	 
	 static String getImageBinary(){      
	        File f = new File("d:/img/aa.jpg");             
	        BufferedImage bi;      
	        try {      
	            bi = ImageIO.read(f);      
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();      
	            ImageIO.write(bi, "jpg", baos);      
	            byte[] bytes = baos.toByteArray();      
	           //  return bytes.toString();     
	            return encoder.encodeBuffer(bytes).trim();      
	        } catch (IOException e) {      
	            e.printStackTrace();      
	        }      
	        return null;      
	    }      

	
}
