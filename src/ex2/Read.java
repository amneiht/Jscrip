
package ex2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import extract.lib.Klist;

public class Read {
	protected static int ch = 0;// doc truoc 1 ky tu
	private static int point = 0;
	private static int[] key = new int[30];
	static final int len = 1000;
	static InputStream in;
	protected static Stack<String> text = new Stack<String>();
	static Queue<String> que = new Queue<String>();

	static void init(InputStream tin) {
		in = tin;
	}

	private void code(String t) {
		// khai bao mang de cmn sau

	}

	protected static String getword(InputStream in) throws IOException {
		point = 0;
		key[0] = ch;
		ch = get();
		while (ischar(ch)) {
			point++;
			key[point] = ch;
			ch = get();
		}
		if (key[point] == ';')
			point--;
		return new String(key, 0, point);
	}

	protected static int kget() // lay bien in tu
	{
		try {
			while (ch <= ' ') // loai cac ky tu thua
			{
				ch = get();
			}
			if (ch == '"') {
				String t;

				t = getString(in);

				que.push(t);
				return Klist.J_text;
			} else {
				if (ischar(ch)) {
					String t = getword(in);
					int a = binarySearch(t);
					if (a > -1)
						return a;
					else {
						que.push(t);
						return Klist.J_m;
					}
				} else
					return Klist.J_false; // bao loi
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Klist.J_false;
		}
	}

	static int binarySearch(String x) {
		int l = 0, r = Klist.list.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;

			int res = x.compareTo(Klist.list[m]);

			// Check if x is present at mid
			if (res == 0)
				return m;

			// If x greater, ignore left half
			if (res > 0)
				l = m + 1;

			// If x is smaller, ignore right half
			else
				r = m - 1;
		}

		return -1;
	}

	static protected String getString(InputStream in) throws IOException {
		StringBuilder st = new StringBuilder();
		int d = ch;
		st.append((char) ch);
		ch = get();
		while (ch != '"' && d != '/') {
			d = ch;
			st.append((char) ch);
			ch = get();
		}
		ch = get();
		String ld = st.toString();
		que.push(ld);// ?
		return ld;
	}

	static protected double getNumber(InputStream in) throws IOException // use when ch is number
	{
		StringBuilder st = new StringBuilder();
		int d = ch;
		st.append((char) ch);
		while (ch != '"' && d != '/') {
			d = ch;
			st.append((char) ch);
			ch = get();
		}
		try {
			double k = Double.parseDouble(st.toString());
			return k;
		} catch (Exception r) {
			return Double.NaN;
		}
	}

	public static int get() throws IOException {
		return in.read();
	}

	public static boolean ischar(int a) {
		if (a >= '0' && a <= '9')
			return true;
		if (a == '_')
			return true;
		a = a | 0x60;
		return (a >= 'A' && a <= 'Z');
	}

	protected int find(String a) {
		return 0;
		// for(int )
	}

	public static List<String> getText(String s) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
			List<String> ret = new LinkedList<String>();
			String rd = in.readLine();
			while (rd != null) {
				ret.add(rd);
				rd = in.readLine();
			}
			in.close();
			return ret;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// init();
	}
}
