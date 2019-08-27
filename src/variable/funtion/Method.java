package variable.funtion;

import variable.Var;
import variable.funtion.exec.Exe;

public abstract class Method implements Exe {
	protected Local lvar = new Local();
	protected Stack<Var> st=new Stack<Var>();
	protected int point=0;
	public Var get(String d) {
		Var ret = lvar.get(d);
		if (ret != null)
			return ret;
		return Global.get(d);
	}
}
