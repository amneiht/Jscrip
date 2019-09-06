package ex2;

import java.util.LinkedList;

public class Stack<E> {
	private LinkedList<E> st = new LinkedList<E>();

	public void push(E d) {
		st.add(d);
	}

	public E pop() {
		if (st.isEmpty())
			return null;
		return st.removeLast();
	}

	public boolean isempty() {
		return st.isEmpty();
	}

	public E show() {
		return st.getLast();
	}
}
