package variable.funtion;

import java.util.LinkedList;

import variable.Var;

public class Stack {
	static LinkedList<Var> st = new LinkedList<Var>();

	static void push(Var d) {
		st.add(d);
	}

	static Var pop() {
		if (st.isEmpty())
			return null;
		return st.removeLast();
	}
}
