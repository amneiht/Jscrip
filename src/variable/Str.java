package variable;

public class Str  implements Var{

	private String st=null,name=null;
	public Str(String nst,String nname)
	{
		st=nst;
		name=nname;
	}
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getStringType() {
		// TODO Auto-generated method stub
		return "str";
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String get() {
		// TODO Auto-generated method stub
		return st;
	}

}
