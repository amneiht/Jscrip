
package ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import extract.lib.Klist;

public class Read {
	private static int[] op = { '[', '{', '(' ,']', '}', ')'};
	private static Kword keyword = new Kword();
	private static Kword ope = new Kword();
	private static int ch = 0;// doc truoc 1 ky tu
	private static int point = 0;
	private static int[] key = new int[30];
	static final int len = 1000;
	static InputStream in;
	static Stack<String> text = new Stack<String>();

	static void init() {
		String s = new File("").getAbsolutePath() + "/ope.txt";
		List<String> h = getText(s);
		for (String sd : h) {
			String[] d = sd.split(":");
			ope.add(d[0], Integer.parseInt(d[1]) + len);
		}
		s = new File("").getAbsolutePath() + "/code.txt";
		h = getText(s);
		int i = 0;
		for (String sd : h) {
			keyword.add(sd, i);
			i++;
		}
	}

	protected void check() {

		try {
			int p = 0;
			while (ch != -1) {
				p = keyword.findl(get());
				switch (p) {
				case Klist.J_text:
					check_text();
					break;
				case Klist.J_if:
					check_jf();
				default:
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void check_jf() {
		// TODO Auto-generated method stub

	}

	private void check_text() {
		
	}

	static boolean bget;

	protected static String get() throws IOException {
		while (ch <= ' ') // loai cac ky tu thua
		{
			ch = in.read();
		}
		bget = ischar(ch);
		point = 0;
		key[0] = ch;
		ch = in.read();
		while (bget != ischar(ch)) {
			point++;
			key[point] = ch;
			ch = in.read();
		}
		if (key[point] == ';')
			point--;
		// if(ch==-1) cont=false;
		return new String(key, 0, point);
	}

	static protected String getString() throws IOException {
		StringBuilder st = new StringBuilder();
		int d = ch;
		ch = in.read();
		while (ch != '"' && d != '/') {
			d = ch;
			st.append((char) ch);
			ch = in.read();
		}
		ch = in.read();
		return st.toString();
	}

	static boolean ischar(int a) {
		if (a >= '0' && a <= '9')
			return true;
		if (a == '_')
			return true;
		a = a | 0x60;
		return (a >= 'A' && a <= 'Z');
	}
	static boolean isope(int ch)
	{
		return bget;
		
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
		init();
	}
}
