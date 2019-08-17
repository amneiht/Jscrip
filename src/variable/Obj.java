package variable;

import java.util.ArrayList;
import java.util.HashMap;

public class Obj implements Var {
	String name=null;
	ArrayList<Var> arr=new ArrayList<Var>();
	HashMap<String,Integer> list=new HashMap<String,Integer>();
	public Obj(ArrayList<Var> k)
	{
		arr=k;
		int f=k.size();
		for(int i=0;i<f;i++)
		{
			list.put(arr.get(0).getName(), i);
		}
	}
	public Var getProp(String a)
	{
		Object d=list.get(a);
		if(d==null) return null;
		return arr.get((int)d);
	}
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getStringType() {
		// TODO Auto-generated method stub
		return "obj";
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
