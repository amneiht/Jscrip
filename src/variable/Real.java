package variable;

public class Real implements Var {
	private Double gt = 0.0;
	private String name=null;
	public Real(String nam,double d)
	{
		name=nam;
		gt=d;
	}
	public void set(double a) {
		gt = a;
	}

	public double get() {
		return gt;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getStringType() {
		// TODO Auto-generated method stub
		return "real";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
