package Util;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import edu.xidian.village.util.Fetch;

public class NewsTest extends TestCase{

	public void testGetNew()
	{
		Fetch f = new Fetch();
		List<String> list =f.getContent();
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
}
