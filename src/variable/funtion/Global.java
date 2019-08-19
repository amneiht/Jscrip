package variable.funtion;

import java.util.HashMap;

import variable.Var;

public class Global {
	// static List<Var> glb=new ArrayList<Var>();
	private static HashMap<String, Var> glb = new HashMap<String, Var>();

	public static void add(Var d) {
		glb.put(d.getName(), d);
	}

	public static Var get(String d) {
		return glb.get(d);
	}
}
