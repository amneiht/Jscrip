package extract.lib;

import java.util.LinkedList;

public class Tree {
	protected int ch = 0;
	String str = null;
	LinkedList<Tree> cmn = new LinkedList<Tree>();
	String text = "false";

	public Tree() {
		
	}

	public Tree(int a) {
		ch = a;
	}

	void add(String a, String b, int p) {
		if (p >= a.length()) {
			str = b;
			// Creat.println(a);
		} else {
			int k = a.charAt(p);
			;
			int d = get(k);
			if (d > -1) {

				cmn.get(d).add(a, b, p + 1);
			} else {
				Tree cc = new Tree(k);
				cmn.addFirst(cc);
				cc.add(a, b, p + 1);
			}
		}
	}

	int get(int a) {
		int i = 0;
		for (Tree s : cmn) {
			if (s.ch == a)
				return i;
			i++;
		}
		return -1;
	}

	boolean isend() {
		return str != null;
	}

	void write() throws Exception {
		if (!cmn.isEmpty()) {
			int qa = 0;
			for (Tree ks : cmn) {
				// Creat.println("else if");
				if (qa == 0)
					Creat.println(" if (Read.ch==\'" + (char) ks.ch + "\' ) \n { ");
				else
					Creat.println("else if (Read.ch==\'" + (char) ks.ch + "\' ) \n { ");
				Creat.println("Read.ch=Read.get();");
				ks.write();
				Creat.println("}");
				qa++;
			}
			if (str == null) {
				if (ch != 0)
					Creat.println("return  Klist.J_" + text + "  ;");
			} else
				Creat.println("else return Klist." + str + ";");
		} else {

			if (str != null)
				Creat.println(" return Klist." + str + ";");
			else
				Creat.println("return  Klist.J_" + text + "  ;");
		}
	}
}
