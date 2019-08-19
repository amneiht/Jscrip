package variable.funtion;

import variable.Var;

public abstract class Method {
	protected Local lvar = new Local();

	public abstract void run();

	public Var get(String d) {
		Var ret = lvar.get(d);
		if (ret != null)
			return ret;
		return Global.get(d);
	}
}
