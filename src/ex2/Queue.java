package ex2;

import java.util.LinkedList;

public class Queue<E> {
	private LinkedList<E> st = new LinkedList<E>();

	public void push(E d) {
		st.add(d);
	}

	public E pop() {
		if (st.isEmpty())
			return null;
		return st.removeFirst();
	}
	public boolean isempty()
	{
		return st.isEmpty();
	}
}
