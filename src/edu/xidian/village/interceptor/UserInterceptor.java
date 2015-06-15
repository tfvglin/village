package edu.xidian.village.interceptor;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@Component("userInterceptor")
public class UserInterceptor extends MethodFilterInterceptor{

/*	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//UserAction action = (UserAction) invocation.getAction();
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		if(session.get("user")==null)
			return Action.INPUT;
		else
			return invocation.invoke();
	}*/

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("aaa");
		System.out.println(invocation.invoke());
		
		return invocation.invoke();
	/*	ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		if(session.get("user")==null)
		{
			System.out.println("Ã»µÇÂ½");
			return Action.INPUT;
		}
		else
		{
			System.out.println("µÇÂ½ÁË");
			return invocation.invoke();
		}*/
		
	}
	

	/*@Override
	public void setIncludeMethods(String includeMethods) {
		// TODO Auto-generated method stub
		super.setIncludeMethods("userInfo");
	}
*/
	
}
