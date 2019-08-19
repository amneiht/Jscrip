package variable.funtion;

import java.util.LinkedList;
import java.util.List;

import variable.Var;

public class Local {
	private List<Var> lca = new LinkedList<Var>();

	public void add(Var z) {
		lca.add(z);
	}

	public Var get(String d) {
		for (Var z : lca) {
			if (d.equals(z.getName()))
				return z;
		}
		return null;
	}
}
